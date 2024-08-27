fun main(){
    val notas = Array(4) { 0.0 }
    var promedio = 0.0;

    for (i in notas.indices){
        while(true){
            try{
                print("Ingresa la nota ${i + 1}/4:")
                notas[i] = readLine()?.toDoubleOrNull()?:continue
                if (notas[i] < 0 || notas[i] > 10){
                    println("Ingresa una nota valida")
                }else{
                    break
                }
            }catch (e: NumberFormatException){
                println("Ingresa una nota valida")
            }
        }
        promedio += notas[i]
    }
    promedio /= 4
    println("El promedio de las notas es: $promedio")
}