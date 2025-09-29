package com.example.rpg_mobile_frontend.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController

@Composable
fun MainScreen(controller: PersonagemCreationController) {
    var currentStep by remember { mutableStateOf(1) }

    when (currentStep) {
        1 -> RacasScreen(controller = controller) { currentStep = 2 }
        2 -> ClassesScreen(controller = controller) { currentStep = 3 }
        3 -> AtributosScreen(controller = controller)
    }
}