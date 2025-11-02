// Arquivo: ui/view/PersonagemResumoScreen.kt
package com.example.rpg_mobile_frontend.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController
import androidx.compose.material3.AlertDialog

@Composable
fun PersonagemResumoScreen(controller: PersonagemCreationController, onPrevious: () -> Unit, onNext: () -> Unit) {
    val personagem = controller.personagemFinal
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Personagem Criado com Sucesso!") },
            text = { Text("Seu novo personagem, ${personagem?.raca?.let { it::class.java.simpleName } ?: "nome desconhecido"} ${personagem?.classe?.let { it::class.java.simpleName } ?: ""}, está pronto para a aventura.") },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        onNext()
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }

    if (personagem != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Resumo do Personagem:")
            Spacer(Modifier.height(16.dp))
            Text("Raça: ${personagem.raca::class.java.simpleName}")
            Text("Classe: ${personagem.classe::class.java.simpleName}")
            Spacer(Modifier.height(16.dp))
            Divider()
            Spacer(Modifier.height(16.dp))
            Text("Atributos:")
            personagem.atributos.forEach { (nome, valor) ->
                Text("$nome: $valor")
            }
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = onPrevious) {
                    Text("Voltar")
                }
                Button(onClick = { showDialog = true }) {
                    Text("Finalizar Criação")
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Personagem não foi finalizado. Volte para a tela anterior.")
            Button(onClick = onPrevious) {
                Text("Voltar")
            }
        }
    }
}