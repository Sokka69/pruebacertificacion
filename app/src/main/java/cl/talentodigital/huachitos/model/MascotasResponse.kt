package cl.talentodigital.huachitos.model

data class MascotasResponse(
    val id: Long,
    val nombre: String,
    val tipo: String,
    val color: String,
    val edad: String,
    val estado: String,
    val genero: String,
    val descFisica: String,
    val descPersonalidad: String,
    val descAdicional: String,
    val esterilizado: Boolean,
    val vacunas: Long,
    val imagen: String,
    val equipo: String,
    val region: String,
    val comuna: String
)
