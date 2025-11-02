// Arquivo: MainScreen.kt
package com.example.rpg_mobile_frontend.ui.view

import androidx.compose.runtime.*
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController

@Composable
fun MainScreen(controller: PersonagemCreationController) {
    var isCreating by remember { mutableStateOf(false) }

    if (isCreating) {
        var currentStep by remember { mutableStateOf(1) }
        val navigateToNext: () -> Unit = { currentStep++ }
        val navigateToPrevious: () -> Unit = { if (currentStep > 1) currentStep-- }
        val resetCreation: () -> Unit = { isCreating = false }

        when (currentStep) {
            1 -> RacasScreen(controller = controller, onNext = navigateToNext)
            2 -> ClassesScreen(controller = controller, onNext = navigateToNext, onPrevious = navigateToPrevious)
            3 -> AtributosScreen(controller = controller, onNext = navigateToNext, onPrevious = navigateToPrevious)
            4 -> PersonagemResumoScreen(controller = controller, onPrevious = navigateToPrevious, onNext = resetCreation)
        }
    } else {
        HomeScreen(controller = controller, onNewCharacter = {
            controller.resetState()
            isCreating = true
        })
    }
}