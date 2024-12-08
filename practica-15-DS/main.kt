import kotlin.system.measureTimeMillis

//Algoritmos de ordenamiento
//buble sort
fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

//insertion sort
fun insertionSort(arr: IntArray) {
    val n = arr.size
    for (i in 1 until n) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

//selection sort
fun selectionSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n - 1) {
        var min = i
        for (j in i + 1 until n) {
            if (arr[j] < arr[min]) {
                min = j
            }
        }
        val temp = arr[min]
        arr[min] = arr[i]
        arr[i] = temp
    }
}

//quick sort
fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(arr, low, high)
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}
fun partition(arr: IntArray, low: Int, high:Int): Int{
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp
    return i + 1
}

//merge sort
fun mergeSort(arr: IntArray) {
    val n = arr.size
    if (n < 2) {
        return
    }
    val mid = n / 2
    val left = arr.copyOfRange(0, mid)
    val right = arr.copyOfRange(mid, n)
    mergeSort(left)
    mergeSort(right)
    merge(arr, left, right)

}

fun merge(arr: IntArray, left: IntArray, right: IntArray) {
    val nL = left.size
    val nR = right.size
    var i = 0
    var j = 0
    var k = 0
    while (i < nL && j < nR) {
        if (left[i] <= right[j]) {
            arr[k] = left[i]
            i++
        } else {
            arr[k] = right[j]
            j++
        }
        k++
    }
    while (i < nL) {
        arr[k] = left[i]
        i++
        k++
    }
    while (j < nR) {
        arr[k] = right[j]
        j++
        k++
    }
}

fun measureSortTime(algorythm: (IntArray) -> Unit, arr: IntArray):Long{
    return measureTimeMillis {
        algorythm(arr.copyOf())
    }
}
//probando los algoritmos 
fun main() {
    val smallesList = (1..1000).toList().shuffled().toIntArray()
    val largestList = (1..10000).toList().shuffled().toIntArray()
    
    println("Comparativa de tiempos en ejecucion")
    println("Bubble sort: ${measureSortTime(::bubbleSort, smallesList)} ms")
    println("Insertion sort: ${measureSortTime(::insertionSort, smallesList)} ms")
    println("Selection sort: ${measureSortTime(::selectionSort, smallesList)} ms")
    println("Quick sort: ${measureSortTime({arr -> quickSort(arr, 0, arr.size - 1)}, smallesList)} ms")
    println("Merge sort: ${measureSortTime(::mergeSort, smallesList)} ms")
    //largest
    println("Bubble sort: ${measureSortTime(::bubbleSort, largestList)} ms")
    println("Insertion sort: ${measureSortTime(::insertionSort, largestList)} ms")
    println("Selection sort: ${measureSortTime(::selectionSort, largestList)} ms")
    println("Quick sort: ${measureSortTime({arr-> quickSort(arr, 0, arr.size-1)}, largestList)} ms")
    println("Merge sort: ${measureSortTime(::mergeSort, largestList)} ms")
       
}