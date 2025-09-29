package com.example.rpg_mobile_frontend.controller

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import classes.Classe
import classes.clerigo.Academico
import classes.clerigo.Clerigo
import classes.guerreiro.Barbaro
import classes.guerreiro.Guerreiro
import classes.ladrao.Bardo
import classes.ladrao.Ladrao
import classes.mago.Ilusionista
import classes.mago.Mago
import dados.Dado
import racas.Anao
import racas.Elfo
import racas.Halfling
import racas.Humano
import racas.Raca
import rpg.dados.somar
import personagem.Estilos

class PersonagemCreationController {

    var selectedRaca by mutableStateOf<Raca?>(null)
        private set

    var selectedClasse by mutableStateOf<Classe?>(null)
        private set

    var selectedAtributos by mutableStateOf<Map<String, Int>>(emptyMap())
        private set

    var selectedAtributoDistribution by mutableStateOf<String?>(null)
        private set

    var generatedAttributeValues by mutableStateOf<List<Int>>(emptyList())
        private set

    val racas: List<Raca> = listOf(Anao(), Elfo(), Halfling(), Humano())
    val classes: List<Classe> = listOf(Guerreiro(), Ladrao(), Clerigo(), Mago(), Barbaro(), Bardo(), Academico(), Ilusionista())
    private val estilos = Estilos()

    fun selectRaca(raca: Raca) {
        selectedRaca = raca
    }

    fun selectClasse(classe: Classe) {
        selectedClasse = classe
    }

    fun selectAtributoDistribution(style: String) {
        selectedAtributoDistribution = style
        generateAttributes()
    }

    private fun generateAttributes() {
        val dados = MutableList(3) { Dado(6) }

        when (selectedAtributoDistribution) {
            "Clássico" -> {
                selectedAtributos = estilos.estiloClassico(dados)
            }
            "Heroico" -> {
                generatedAttributeValues = estilos.estiloHeroico(dados)
            }
            "Aventureiro" -> {
                generatedAttributeValues = estilos.estiloAventureiro(dados)
            }
        }
    }

    fun assignAttributes(assignments: Map<String, Int>) {
        selectedAtributos = assignments
    }
}