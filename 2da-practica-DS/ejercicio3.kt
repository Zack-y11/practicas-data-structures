fun main() {
    val cadenaTexto = Array(5) {""}
    for (i in cadenaTexto.indices) {
        try {
            print("Ingresa una cadena de texto (${i+1}/5): ")
            cadenaTexto[i] = readLine() ?: ""
        } catch (e: Exception) {
            println("Ingresa una cadena de texto válida")
        }
    }   
    println("cadenas ingresadas")
     for (cadena in cadenaTexto) {
        print(cadena)
     }
}
