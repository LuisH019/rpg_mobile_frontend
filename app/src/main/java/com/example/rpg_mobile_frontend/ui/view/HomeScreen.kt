// Arquivo: ui/view/HomeScreen.kt
package com.example.rpg_mobile_frontend.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController

@Composable
fun HomeScreen(controller: PersonagemCreationController, onNewCharacter: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Personagens Criados:")
        Spacer(Modifier.height(16.dp))

        if (controller.savedCharacters.isEmpty()) {
            Text("Nenhum personagem foi criado ainda.")
        } else {
            Column {
                controller.savedCharacters.forEachIndexed { index, personagem ->
                    Text("${index + 1}. Raça: ${personagem.raca::class.java.simpleName}, Classe: ${personagem.classe::class.java.simpleName}")
                    Spacer(Modifier.height(4.dp))
                }
            }
        }

        Spacer(Modifier.height(32.dp))

        Button(onClick = onNewCharacter) {
            Text("Criar Novo Personagem")
        }
    }
}