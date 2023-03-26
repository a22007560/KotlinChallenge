package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(indetificador: String, var motor: Motor) : Veiculo(indetificador), Ligavel {
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x || posicao.y == y) {
            throw AlterarPosicaoException()
        } else {
            if (estaLigado()) {
                posicao.alterarPosicaoPara(x, y)
                motor.desligar()
            }
        }
    }

    override fun ligar() {
        motor.ligar()
    }

    override fun desligar() {
        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.ligado
    }

    override fun toString(): String {
        return "Carro | $identificador | $dataDeAquisicao | $posicao"
    }
}