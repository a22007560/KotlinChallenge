package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException(name:String, message: String ="$name não tem carta para conduzir o veículo indicado"):Exception(message) {
}