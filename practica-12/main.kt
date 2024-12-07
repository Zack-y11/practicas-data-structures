data class Task(val name: String, val priority: Int)

class ThreeNode(val task:Task){
    var left: ThreeNode? = null
    var right: ThreeNode? = null
}

class ThreeTasks(){
    private var raiz: ThreeNode?=null

    fun insert(task: Task){
        raiz = recursiveInsert(raiz, task)
    }

    private fun recursiveInsert(current: ThreeNode?, task: Task): ThreeNode{
        if(current == null){
            return ThreeNode(task)
        }
        if(task.priority < current.task.priority){
            current.left = recursiveInsert(current.left, task)
        }else{
            current.right = recursiveInsert(current.right, task)
        }
        return current
    }

    fun showInOrder(){
        showInOrderRecursive(raiz)
    }

    private fun showInOrderRecursive(node:ThreeNode? ){
        if(node != null){
            showInOrderRecursive(node.left)
            println("Tarea: ${node.task.name}, Prioridad: ${node.task.priority}")
            showInOrderRecursive(node.right)
        }
    }

}


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

    fun getAll():List<T>{
        return elements
    }
}

fun main(){
    val list = customList<Task>()
    val three = ThreeTasks()
    var opcion: Int
    do {
        println("GESTOR DE TAREAS")
        println("1. Agregar tarea")
        println("2. Eliminar tarea")
        println("3. Mostrar tareas" )
        println("4. Mostrar tareas por prioridad")
        println("5. Salir")
        opcion = readLine()?.toIntOrNull()?:0
        when(opcion){
            1 -> {
                println("Ingrese la tarea")
                val tarea = readLine()!!
                println("Ingrese la prioridad")
                val prioridad = readLine()?.toIntOrNull()?:0
                val nuevaTarea= Task(tarea, prioridad)
                list.add(nuevaTarea)
            }
            2 -> {
                if(list.size()>0){
                    println("Seleccione la tarea que desea eliminar")
                    list.getAll()
                    println("Ingrese el nombre exacto de la tarea")
                    val nombre = readLine()?:""
                    val eliminarTarea = list.getAll().find { it.name == nombre }
                    if(eliminarTarea != null){
                        list.remove(eliminarTarea)
                    }
                }else{
                    println("No hay tareas para eliminar")
                }
            }
            3 -> {
                list.showAll()
            }
            4 ->{
                three.showInOrder() 
            }
            5 -> {
                println("Saliendo...")
            }
            else -> {
                println("Opcion no valida")
            }
        }   
    } while (opcion != 4)
}