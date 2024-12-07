//Algoritmos de busqueda

//busquela lineal (secuenciales)
fun busquedaLineal(arr: List<Int>, x: Int): Int {
    for (i in arr.indices) {
        if (arr[i] == x) {
            return i
        }
    }
    return -1
}
//busqueda binaria
fun busquedaBinaria(arr: List<Int>, x: Int): Int {
    var inicio = 0
    var fin = arr.size - 1
    while (inicio <= fin) {
        val medio = inicio + (fin - inicio) / 2
        when {
            arr[medio] == x -> return medio
            arr[medio] < x -> inicio = medio + 1
            else -> fin = medio - 1
        }
    }
    return -1
}
//suo de las busquedas
fun main() {
    val list1 = List(10000){it}
    val list2 = List(10000){(1..10000).random()}
    val x = 5000
    val resultadoLineal = busquedaLineal(list1, x)
    val resultadoBinario = busquedaBinaria(list2, x)
    if(resultadoLineal != -1){
        println("Encontrado en el indice: $resultadoLineal")
    }else{
        println("No encontrado")
    }
    if(resultadoBinario != -1){
        println("Encontrado en el indice: $resultadoBinario")
    }else{
        println("No encontrado")
    }

}