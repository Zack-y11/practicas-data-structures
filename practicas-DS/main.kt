

import kotlin.text.toDouble
fun potencia(numUno: Double, numDos: Double): Double? {
    return Math.pow(numUno, numDos);
}

fun calculate(numUno: Double, numDos: Double, operacion: String): Double? {
    return when (operacion) {
        "+" -> numUno + numDos
        "-" -> numUno - numDos
        "*" -> numUno * numDos
        "/" -> {
            if (numDos == 0.0) {
                null  // Indica un error de división por cero
            } else {
                numUno / numDos
            }
        }
        "**" -> if(numUno == 0.0 && numDos == 0.0) null else potencia(numUno, numDos)
        else -> null  // Indica una operación inválida
    }
}

fun main() {
    println("Ingrese el primer número /base:")
    val num1 = readLine()?.toDouble()
    println(" You selected $num1")

    println("Ingrese el segundo número / exponente:")
    val num2 = readLine()?.toDouble()
    println(" You selected $num2")
    println("Ingrese la operación que desea realizar (+, -, *, /, **):")
    val operacion = readLine()
    println(" You selected $operacion")

    if (num1 != null && num2 != null && operacion != null) {
        val result = calculate(num1, num2, operacion)
        if (result != null) {
            println("El resultado de la operación es: $result")
        } else {
            println("Error: Operación inválida o división por cero.")
        }
    } else {
        println("Error: Entrada inválida. Asegúrese de ingresar números válidos y una operación.")
    }
}


