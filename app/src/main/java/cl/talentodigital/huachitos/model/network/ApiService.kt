package cl.talentodigital.huachitos.model.network

import cl.talentodigital.huachitos.model.MascotasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    //Listado de Mascotas
    @GET("animales")
    fun getMascotas(): Call<List<MascotasResponse>>

    //Detalle Mascota
    @GET("animales/{id_mascota}")
    fun getDetalleMascota(@Path("id_mascota") mascotaCargada: Long): Call<MascotasResponse>

}