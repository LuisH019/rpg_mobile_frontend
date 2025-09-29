package com.example.rpg_mobile_frontend.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController
import classes.Classe

@Composable
fun ClassesScreen(controller: PersonagemCreationController, onNext: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Escolha a Classe:")

        controller.classes.forEach { classe ->
            Button(
                onClick = {
                    controller.selectClasse(classe)
                    onNext()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(classe::class.java.simpleName)
            }
        }
    }
}