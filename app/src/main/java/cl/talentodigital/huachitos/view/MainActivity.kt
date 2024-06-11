package cl.talentodigital.huachitos.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.huachitos.R
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

        //Vincular RecyclerView
        binding.listaMascotas.layoutManager = LinearLayoutManager(this)

        //Configurar Adapter
        var adapterMascotas = MascotasAdapter(listOf())
        binding.listaMascotas.adapter = adapterMascotas

        //Configurar Observador
        viewModelMascotas.listaMascotas.observe(this) { datosMascotas ->
            adapterMascotas = MascotasAdapter(datosMascotas)
            binding.listaMascotas.adapter = adapterMascotas


        }
        viewModelMascotas.errores.observe(this){

            binding.listaMascotas.visibility = View.GONE
        }




    }
}