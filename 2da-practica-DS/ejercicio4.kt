

import kotlin.io.readLine

/*
Ejercicio 4: Crea un programa que permita al usuario ingresar 4 números enteros y los
almacene en un array. Luego, encuentra y muestra el número mayor del array. Usa trycatch para manejar entradas no numéricas
*/

fun main(){
    val arrayEnteros = Array(4) { 0 }
    var maxValue : Int = 0

    for (i in arrayEnteros.indices){
        try{
            println("Ingresa un numero entero: ${i+1}/4: ")
            arrayEnteros[i] = readLine()!!.toInt()
        }catch(e: Exception){
            println("Tipo de dato no esperado: ${e.message}")
        }
    }
    for (i in arrayEnteros.indices){
        if(arrayEnteros[i] > maxValue){
            maxValue = arrayEnteros[i]
        }
    }
    println("El valor numero mayor del array es: ${maxValue}")


}