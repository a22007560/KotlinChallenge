package pt.ulusofona.cm.kotlin.challenge.models

abstract class Veiculo(var indetificador: String) {

    abstract fun requerCarta():Boolean
}