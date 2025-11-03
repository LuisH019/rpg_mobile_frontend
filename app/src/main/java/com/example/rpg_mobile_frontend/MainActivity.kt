package com.example.rpg_mobile_frontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rpg_mobile_frontend.ui.view.MainScreen
import com.example.rpg_mobile_frontend.ui.theme.Rpg_mobile_frontendTheme
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController
import android.content.Context

class MainActivity : ComponentActivity() {

    private lateinit var controller: PersonagemCreationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        controller = PersonagemCreationController(applicationContext) // PASSA CONTEXT
        enableEdgeToEdge()
        setContent {
            Rpg_mobile_frontendTheme {
                MainScreen(controller = controller)
            }
        }
    }
}