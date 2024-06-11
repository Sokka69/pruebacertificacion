package cl.talentodigital.huachitos.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClass {
    //Se crea una intancia de retrofit que se configura
    companion object {
        //Conecta a la API
        val retrofit = Retrofit.Builder()
            .baseUrl("https://caso-perritos-adopcion-c74apk0pl-talento-projects.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}