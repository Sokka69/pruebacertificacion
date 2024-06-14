package cl.talentodigital.huachitos.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.huachitos.databinding.ActivityMainBinding
import cl.talentodigital.huachitos.viewmodel.MascotasViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        // Configurar  Vista
        setContentView(binding.root)

        //Configuracion ViewModel
        var viewModelMascotas = ViewModelProvider(this)[MascotasViewModel::class.java]

        //Configurar RecyclerView
        binding.listaRecycler. layoutManager = LinearLayoutManager(this)

        //Configurar Adapter
        var adapterMascotas = MascotaAdapter(listOf())
        binding.listaRecycler.adapter = adapterMascotas

        //Configurar Observador
        viewModelMascotas.listaMascotas.observe(this) { datosMascota ->
            adapterMascotas = MascotaAdapter(datosMascota)
            binding.listaRecycler.adapter = adapterMascotas


        }
        viewModelMascotas.listarMascotas()
    }


}
