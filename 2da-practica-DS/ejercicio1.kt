fun main (){
    val numeros = Array(3) { 0 }
    var suma = 0

    for (i in numeros.indices){
        while(true){
            try{
                print("Ingresa un numero entero (${i + 1}/3):")
                numeros[i] = readLine()!!.toInt()
                break
            }catch (e: NumberFormatException){
                println("Ingresa un numero valido")
            }
        }
        suma += numeros[i]
    }
    println("La suma de los numeros es: $suma")
}