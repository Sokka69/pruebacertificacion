package cl.talentodigital.huachitos.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.huachitos.databinding.ItemMascotaBinding
import cl.talentodigital.huachitos.model.MascotasResponse
import com.squareup.picasso.Picasso

class MascotaAdapter(private val listaMascotas: List<MascotasResponse>) :
    RecyclerView.Adapter<MascotaAdapter.MascotasViewHolder>() {

    class MascotasViewHolder(val binding: ItemMascotaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotasViewHolder {

        val binding = ItemMascotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MascotasViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listaMascotas.size
    }

    override fun onBindViewHolder(holder: MascotasViewHolder, position: Int) {
        val mascotas = listaMascotas[position]

        holder.binding.txtNameMascota.text = mascotas.nombre
        holder.binding.txtEdad.text = mascotas.edad
        holder.binding.txtTipo.text = mascotas.tipo
        holder.binding.txtGenero.text = mascotas.genero

        Picasso.get().load(mascotas.imagen).into(holder.binding.imgMascota)

        //Configurar el click
        holder.binding.root.setOnClickListener {
            // abrir la actividad de detalle
            Toast.makeText(
                holder.binding.root.context, "Haciendo click en $position", Toast.LENGTH_SHORT
            ).show()
        }

    }
}

