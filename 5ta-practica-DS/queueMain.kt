class Node<T>(val value: T, var next: Node<T>? = null)
class Queue<T> {
    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    private var size = 0

    fun enqueue(value: T) {

        val newNode = Node(value)
        if (rear != null) {
        rear?.next = newNode
        }
        rear = newNode
        if (front == null) {
        front = rear
        }
        size++
    }
        
    fun dequeue(): T? {
        if (isEmpty()) {
        println("Queue is empty.")
        return null
        }
        val dequeuedValue = front?.value
        front = front?.next
        if (front == null) {
        rear = null
        }
        size--
        return dequeuedValue
    }

    fun peek(): T? {
        return front?.value
    }

    fun isEmpty(): Boolean {
        return front == null
    }
    
    fun size(): Int {
        return size
    }
    
    override fun toString(): String {
        if (isEmpty()) return "[]"
        val result = StringBuilder("[")
        var current = front
        while (current != null) {
        result.append(current.value)
        if (current.next != null) {
        result.append(", ")
        }
        current = current.next
        }
        result.append("]")
        return result.toString()
    }
}


fun main (){
/*
EJERCICIO 1
Simulacion de sistema de banco por turnos
*/
println("\n\n ::::: EJERCICIO 1 :::::")
    val bancoQueue = Queue<Int>()
    for (i in 1..10){
        bancoQueue.enqueue(i)

    }
    println("Turnos de clientes: $bancoQueue")

    for(i in 1..8){
        println("Atendiendo al cliente:  ${bancoQueue.dequeue()}")
    }

    println("Clientes restantes: ${bancoQueue.size()}")

    /*
    EJERCICIO 2:
    Gestion de Tareas en cola.
    */
    println("\n\n ::::: EJERCICIO 2 :::::")
    val tareasQueue = Queue<String>()
    tareasQueue.enqueue("Preparar el desayuno")
    tareasQueue.enqueue("Comer")
    tareasQueue.enqueue("Ir a clases")
    tareasQueue.enqueue("Compras semanales")
    tareasQueue.enqueue("Hacer tarea de programacion")

    println("Tareas pendientes: $tareasQueue")
    while(!tareasQueue.isEmpty()){
        println("Realizando tarea: ${tareasQueue.dequeue()}")
    }


}

