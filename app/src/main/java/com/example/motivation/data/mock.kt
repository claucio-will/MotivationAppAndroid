package com.example.motivation.data

import com.example.motivation.infra.Constantes
import kotlin.random.Random

data class Phrase(val description: String, val category: Int)

class Mock {

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", Constantes.FILTER.HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", Constantes.FILTER.HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", Constantes.FILTER.HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", Constantes.FILTER.HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", Constantes.FILTER.HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", Constantes.FILTER.HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", Constantes.FILTER.SUNNY),
        Phrase("Você perde todas as chances que você não aproveita.", Constantes.FILTER.SUNNY),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", Constantes.FILTER.SUNNY),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", Constantes.FILTER.SUNNY),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", Constantes.FILTER.SUNNY),
        Phrase("Se você acredita, faz toda a diferença.", Constantes.FILTER.SUNNY),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", Constantes.FILTER.SUNNY)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int): String {
        val filtered = listPhrases.filter { (it.category == value || value == Constantes.FILTER.ALL) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }

}