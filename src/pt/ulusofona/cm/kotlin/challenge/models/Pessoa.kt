package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

import java.util.Date
import java.util.concurrent.TimeUnit

class Pessoa(val nome: String, val dataDeNascimento: Date) : Movimentavel{

    val veiculos = mutableListOf<Veiculo>()
    val posicao = Posicao(0, 0)
    var carta : Carta? = null

    fun comprarVeiculo(veiculo: Veiculo){
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador:String):Veiculo {
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val it = veiculos.iterator()
        while (it.hasNext()) {
            val veiculo = it.next()
            if (veiculo.identificador == identificador) {
                it.remove()
                veiculo.dataDeAquisicao = Date()
                comprador.comprarVeiculo(veiculo)
                return
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                if(veiculo.requerCarta() && !temCarta()) {
                    throw PessoaSemCartaException(nome)
                } else {
                    veiculo.moverPara(x, y)
                    return
                }
            }
        }
    }

    fun temCarta() : Boolean {
        return carta != null
    }

    fun tirarCarta() {
        val diff = Date().time - dataDeNascimento.time
        val idade = TimeUnit.MILLISECONDS.toDays(diff) / 365
        if (idade >= 18) {
            carta = Carta()
        } else {
            throw MenorDeIdadeException()
        }
    }

    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x || posicao.y == y) {
            throw AlterarPosicaoException()
        } else {
            posicao.alterarPosicaoPara(x, y)
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${SimpleDateFormat("dd-MM-YYYY").format(dataDeNascimento)} | $posicao"
    }


}