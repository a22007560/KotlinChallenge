package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

import java.util.Date

class Pessoa(val nome: String, val dataDeNascimento: Date) {

    val veiculos = mutableListOf<Veiculo>()
    val posicao = Posicao(0, 0)

    fun comprarVeiculo(identificador: Veiculo){

    }

    //fun venderVeiculo(identificador: String) : Veiculo {
        //return Veiculo()
    //}

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {

    }

    fun temCarta() : Boolean {
        return true
    }

    fun tirarCarta() {

    }




}