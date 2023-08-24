package com.example.gopharma.models

data class Cliente(var id : Int?, var nome : String, var email : String, var celular : String, var senha : String, var confsenha: String="teste")
{
    override fun toString(): String {
        return nome
    }
}