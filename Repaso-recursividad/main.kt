// recursividad
fun findMax(numbers: List<Int>): Int{
    tailrec fun findMaxHelper(index: Int, currentMax: Int): Int{
        return if(index == numbers.size) {
            currentMax
        } else {
            val newMax = if(numbers[index] > currentMax) numbers[index] else currentMax
            findMaxHelper(index + 1, newMax)
        }
    }
    require(numbers.isNotEmpty()){"la lista no puede estar vacia"}
    return findMaxHelper(0, numbers[0])
}

fun main(args: Array<String>){
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(findMax(numbers))
}