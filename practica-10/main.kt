class Nodo (val pregunta: String, val respuesta: String?=null){
    var izquierdo: Nodo? = null
    var derecho: Nodo? = null
}

class ArbolBinarioPRG{
    var raiz : Nodo
    init{
        val mago = Nodo("", "Eres un mago")
        val arquero = Nodo("", "Eres un arquero")
        val guerrero = Nodo("", "Eres un guerrero")
        val asesino = Nodo ("", "Eres un asesino")

        val magia = Nodo("Prefieres usar magia")
        magia.izquierdo = mago
        magia.derecho = arquero

        val armas = Nodo("Prefieres usar armas?")
        armas.izquierdo = guerrero
        armas.derecho = asesino
        
        raiz = Nodo("Prefieres combate a distancia?")
        raiz.izquierdo = magia
        raiz.derecho = armas

    }
}

fun juego(nodo: Nodo?){
    if(nodo == null) return

    if(nodo.respuesta != null){
        println(nodo.respuesta)
        return
    }
    println(nodo.pregunta + " si/no")
    val respuesta = readLine()?.trim()?.lowercase()

    if(respuesta == " si"){
        juego(nodo.izquierdo)
    }else{
        juego(nodo.derecho) 
    }
}

fun main(){
    val jugador = ArbolBinarioPRG()
    println("Bienvenido al test de clases RPG")
    juego(jugador.raiz)
}