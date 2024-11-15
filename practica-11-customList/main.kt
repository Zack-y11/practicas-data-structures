class customList<T>{
    private val elements = mutableListOf<T>()

    fun add(element: T): Boolean{
        return if(element !in elements){
            elements.add(element)
            println("Tarea agregada con exito")
            true
        }else{
            println("Tarea ya existente")
            false
        }
    }
    fun remove(element: T): Boolean{
        return if(element in elements){
            elements.remove(element)
            println("Tarea eliminada con exito")
            true
        }else{
            println("Tarea no existente")
            false
        }
    }
    fun showAll(){
        if(elements.isEmpty()){
            println("No hay tareas")
        }else{
            println("Tareas:")
            elements.forEach { println("- $it") }
        }
    }
    fun size(): Int{
        return elements.size
    }
}

fun main(){
    val list = customList<String>()
    var opcion: Int
    do {
        println("GESTOR DE TAREAS")
        println("1. Agregar tarea")
        println("2. Eliminar tarea")
        println("3. Mostrar tareas" )
        println("4. Salir")
        opcion = readLine()?.toIntOrNull()?:0
        when(opcion){
            1 -> {
                println("Ingrese la tarea")
                val tarea = readLine()?: ""
                list.add(tarea)
            }
            2 -> {
                println("Ingrese la tarea")
                val tarea = readLine()!!
                list.remove(tarea)
            }
            3 -> {
                list.showAll()
            }
            4 -> {
                println("Saliendo...")
            }
            else -> {
                println("Opcion no valida")
            }
        }   
    }
    

}