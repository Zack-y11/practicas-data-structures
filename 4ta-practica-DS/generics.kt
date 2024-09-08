// Ejemplo 1
class Caja<T>(val contenido: T) {
    fun obtenerContenido(): T {
        return contenido
    }
}

// Ejemplo 2
fun <T> imprimirDato(elemento: T) {
    println(elemento)
}

// Ejemplo 3
fun <T : Number> sumar(a: T, b: T): Double {
    return a.toDouble() + b.toDouble()
}

fun <T> imprimirSiEsNumero(numero: T) where T:Number{
    println(numero.toDouble())
}

fun main(args: Array<String>) {

    val cajaInt = Caja(24)
    val cajaString = Caja("It's a String!")
    val name = "Isaac"
    val pi = 3.1415
    val suma = sumar(57, pi)

    println("--------------------Ejemplo 1--------------------")
    println(cajaInt.obtenerContenido())
    println(cajaString.obtenerContenido())
    println("--------------------Fin--------------------\n")
    println("--------------------Ejemplo 2--------------------")
    imprimirDato(name)
    imprimirDato(pi)
    println("--------------------Fin--------------------\n")
    println("--------------------Ejemplo 3--------------------")
    println("La sume es: " + suma)
    println("--------------------Fin--------------------\n")
    println("--------------------Ejemplo 4--------------------")
    println(imprimirSiEsNumero(suma))
    println("--------------------Fin--------------------\n")
}
