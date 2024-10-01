import java.io.File

fun readFile(path: String): String{
    val file = File(path)
    return file.readText()

}

fun writeFile(path:String, content: String){
    val file = File(path)
    file.appendText(content)

}


fun main(){
    val path = "C:/Users/Zack/Desktop/UNIVO/CICLO-IV/Estructura-de-Datos/practicas-data-structures/6ta-practica-DS/files/example.txt"
    val content = readFile(path)
    println("-----------EJERCICIO 1-------------")
    println(content)
    println("-----------EJERCICIO 2-------------")
    val insert = "\nthis is an example in the subject Data Structures"
    writeFile(path, insert)
    println("Se ha agregado el texto")
}   