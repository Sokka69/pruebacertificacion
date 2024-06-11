package cl.talentodigital.huachitos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.talentodigital.huachitos.model.MascotasResponse
import cl.talentodigital.huachitos.model.network.ApiService
import cl.talentodigital.huachitos.model.network.RetrofitClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MascotasViewModel : ViewModel() {
    // LiveData
    val listaMascotas = MutableLiveData<List<MascotasResponse>>()
    val errores = MutableLiveData<String>()

    fun getMascotas() {
        // Implementacion corrutina
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val respuesta = RetrofitClass.retrofit.create(ApiService::class.java)
                val call = respuesta.getMascotas()
                call.enqueue(object : Callback<List<MascotasResponse>> {
                    override fun onResponse(
                        call: Call<List<MascotasResponse>>,
                        response: Response<List<MascotasResponse>>
                    ) {
                        if (response.isSuccessful) {
                            listaMascotas.postValue(response.body())
                        } else {
                            errores.postValue(
                                "Error en la API - ${
                                    response.errorBody().toString()
                                }"
                            )
                        }
                    }

                    override fun onFailure(p0: Call<List<MascotasResponse>>, t: Throwable) {
                        errores.postValue("Error de Falla - ${t.message}")
                    }
                })
            } catch (e: Exception) {
                e.printStackTrace()
                errores.postValue("Error al obtener datos - ${e.message}")
            }
        }
    }
}