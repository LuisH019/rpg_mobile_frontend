// Arquivo: AtributoAssignment.kt
package com.example.rpg_mobile_frontend.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AtributoAssignment(controller: PersonagemCreationController) {
    val atributosNomes = listOf("forca", "destreza", "constituicao", "inteligencia", "sabedoria", "carisma")

    val assignedAttributes = remember {
        mutableStateMapOf<String, Int?>().apply {
            atributosNomes.forEach { put(it, null) }
        }
    }

    val unassignedValues = remember {
        mutableStateListOf<Int>().apply { addAll(controller.generatedAttributeValues) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Valores Gerados (clique para atribuir):")
        Spacer(Modifier.height(8.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            unassignedValues.forEach { valor ->
                Button(
                    onClick = { /* Sem ação */ },
                    modifier = Modifier.size(80.dp, 40.dp).padding(4.dp)
                ) {
                    Text("$valor")
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            atributosNomes.forEach { atributo ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Coluna 1: Nome do Atributo
                    Column(modifier = Modifier.weight(1f)) {
                        Text("$atributo: ${assignedAttributes[atributo]?.toString() ?: "Nenhum"}")
                    }

                    // Coluna 2: Botões de Atribuição
                    Column(modifier = Modifier.weight(1f)) {
                        if (assignedAttributes[atributo] == null) {
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                unassignedValues.forEach { valor ->
                                    Button(
                                        onClick = {
                                            assignedAttributes[atributo] = valor
                                            unassignedValues.remove(valor)
                                        },
                                        modifier = Modifier.size(80.dp, 40.dp).padding(4.dp)
                                    ) {
                                        Text(valor.toString())
                                    }
                                }
                            }
                        } else {
                            Spacer(Modifier.height(40.dp))
                        }
                    }
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }

        Spacer(Modifier.height(16.dp))

        val allAttributesAssigned = assignedAttributes.all { it.value != null }
        if (allAttributesAssigned) {
            Button(
                onClick = {
                    val finalAssignment = assignedAttributes.mapValues { it.value!! }
                    controller.assignAttributes(finalAssignment)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Confirmar Atribuição")
            }
        }
    }
}