package com.example.todoapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
data class CepResponse(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String
)
interface ViaCepService {
    @GET("{cep}/json/")
    fun getAddress(@Path("cep") cep: String): Call<CepResponse>
}