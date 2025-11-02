// Arquivo: ui/view/AtributosScreen.kt
package com.example.rpg_mobile_frontend.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController
import com.example.rpg_mobile_frontend.ui.components.AtributoAssignment

@Composable
fun AtributosScreen(controller: PersonagemCreationController, onNext: () -> Unit, onPrevious: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (controller.selectedAtributoDistribution == null) {
            Text("Escolha o Estilo de Distribuição de Atributos:")
            Spacer(Modifier.height(16.dp))
            Button(onClick = { controller.selectAtributoDistribution("Clássico") }) {
                Text("Estilo Clássico")
            }
            Button(onClick = { controller.selectAtributoDistribution("Heroico") }) {
                Text("Estilo Heróico")
            }
            Button(onClick = { controller.selectAtributoDistribution("Aventureiro") }) {
                Text("Estilo Aventureiro")
            }
        } else {
            AtributosDisplay(controller, onNext, onPrevious)
        }
    }
}

@Composable
fun AtributosDisplay(controller: PersonagemCreationController, onNext: () -> Unit, onPrevious: () -> Unit) {
    Column {
        Text("Distribuição de Atributos: ${controller.selectedAtributoDistribution}")
        Spacer(Modifier.height(16.dp))

        if (controller.selectedAtributoDistribution == "Clássico") {
            controller.selectedAtributos.forEach { (nome, valor) ->
                Text("$nome: $valor")
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = onPrevious) {
                Text("Voltar")
            }
            Button(onClick = {
                controller.salvarPersonagem()
                onNext()
            }) {
                Text("Avançar para o Resumo")
            }
        } else {
            AtributoAssignment(
                controller = controller,
                onNext = {
                    controller.salvarPersonagem()
                    onNext()
                },
                onPrevious = onPrevious
            )
        }
    }
}