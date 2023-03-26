package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo(var identificador: String): Movimentavel {
    var posicao: Posicao = Posicao(0,0)
    var dataDeAquisicao: Date = Date()


    abstract fun requerCarta():Boolean


}