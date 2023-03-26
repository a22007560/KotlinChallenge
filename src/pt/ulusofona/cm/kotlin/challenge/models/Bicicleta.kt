package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.text.SimpleDateFormat

class Bicicleta(identificador: String) : Veiculo(identificador) {
    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x && posicao.y == y) {
            throw AlterarPosicaoException()
        } else {
            posicao.alterarPosicaoPara(x, y)
        }
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | ${SimpleDateFormat("dd-MM-YYYY").format(dataDeAquisicao)} | $posicao"
    }
}