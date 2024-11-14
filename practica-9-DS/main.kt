fun fibonnaci (n: Int):Int{
    return if (n <= 1){
        n
    }else{
        fibonnaci(n-1) + fibonnaci(n-2)
    }
}

fun sumaRecursiva(n: Int):Int{
    return if (n <= 1){
        1
    }else{
        n + fibonnaci(n-1)
    }
}

fun sumaLista(lista: List<Int>):Int{
    return if (lista.isEmpty()){
        return 0
    }else {
        lista[0] + sumaLista(lista.drop(1))
    }
}

fun main() {
    //ejemplo fibonnaci
    val num = 5
    println("Fibonnaci de $num es ${fibonnaci(num)}")

    //suma recursiva
    val numero = 20
    println("Suma recursiva de $numero es = ${sumaRecursiva(numero
    )}")

    val numerosEnLista = listOf(1,2,3,4,5)
    println("La suma de los numeros en la lista es: ${sumaLista(numerosEnLista)}")

}