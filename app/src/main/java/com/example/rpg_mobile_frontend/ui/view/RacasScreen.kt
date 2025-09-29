package com.example.rpg_mobile_frontend.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController
import racas.Raca

@Composable
fun RacasScreen(controller: PersonagemCreationController, onNext: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Escolha a Raça:")

        controller.racas.forEach { raca ->
            Button(
                onClick = {
                    controller.selectRaca(raca)
                    onNext()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(raca::class.java.simpleName)
            }
        }
    }
}