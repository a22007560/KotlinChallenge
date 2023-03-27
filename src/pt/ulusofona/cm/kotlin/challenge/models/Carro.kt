package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.text.SimpleDateFormat

class Carro(indetificador: String, var motor: Motor) : Veiculo(indetificador), Ligavel {
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (posicao != Posicao(x, y)) {
            if (estaLigado()) {
                posicao.alterarPosicaoPara(x, y)
                motor.desligar()
            }
        } else {
            throw AlterarPosicaoException()
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
        return "Carro | $identificador | ${SimpleDateFormat("dd-MM-YYYY").format(dataDeAquisicao)} | $posicao"
    }
}