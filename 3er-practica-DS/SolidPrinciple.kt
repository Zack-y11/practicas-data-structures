//Principios SOLID
//-1 Single Responsability Principle (SRP) 

//Mal ejemplo de SRP
// class factura (val items: List<Item>) {
//     fun calcularTotal(): Double {
//         return items.sumOf{ it.precio }
//     }

//     fun generateReport(): String{
//         return "reporte de la factura"

//     }
// }
data class Item(val nombre: String, val precio: Double)

class factura (val items: List<Item>){
    fun calcularTotal(): Double{
        return items.sumOf{ it.precio }
    }
}

class ReporteFactura {
    fun generar(factura: factura){
        println("reporte de la factura")

    }
}

//-2 OPEN CLOSE PRINCIPLE (OCP)
open class Empleado (val nombre: String, val horasTrabajadas: Int, val precioHora: Double){
    open fun CalcularSalario(): Double{
        return horasTrabajadas * precioHora.toDouble()
    }
}

class EmpleadoConBono(nombre: String, horasTrabajadas: Int,precioHora: Double, val bono : Double): Empleado(nombre, horasTrabajadas, precioHora){
    override fun CalcularSalario (): Double {
        return super.CalcularSalario() + bono
    }
}


//-3 Liskov Substitution Principle (LSP)
fun main (args: Array<String>){
    fun imprimirSalario(empleado: Empleado){
        println("El salario de ${empleado.nombre} es de: ${empleado.CalcularSalario()}")
    }

    val empleado = Empleado("Juan", 40, 12.0)
    val empleadoConBono = EmpleadoConBono("Pedro", 40, 12.0, 60.0)

    imprimirSalario(empleado)
    imprimirSalario(empleadoConBono)
}

//-4 Interface Segregation Principle (ISP)
interface trabajador {
    fun trabajar()
}
interface Asistente{
    fun asistir()
}
interface Reportero{
    fun generarReportar()
}

class Programador: trabajador{
    override fun trabajar(){
        println("Programando...")
    }
}
class Albañil : trabajador{
    override fun trabajar(){
        println("Construyendo...")
    }
}

/*
//-5 Dependency Inversion Principle (DIP)
 */
interface Notificaciones{
    fun enviarNotificaciones(mensaje: String)
}

class ServiciosEmail: Notificaciones{
    override fun enviarNotificaciones(mensaje: String){
        println("Enviando Email: $mensaje")
    }
}

class Notificacion(val servicio: Notificaciones){
    fun enviarUnaNotificacion(){
        servicio.enviarNotificaciones("mensaje importante")
    }
}