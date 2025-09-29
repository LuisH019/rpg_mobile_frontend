package com.example.rpg_mobile_frontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rpg_mobile_frontend.ui.view.MainScreen
import com.example.rpg_mobile_frontend.ui.theme.Rpg_mobile_frontendTheme
import com.example.rpg_mobile_frontend.controller.PersonagemCreationController

class MainActivity : ComponentActivity() {

    private val controller = PersonagemCreationController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Rpg_mobile_frontendTheme {
                MainScreen(controller = controller)
            }
        }
    }
}