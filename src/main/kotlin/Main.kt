import java.util.*
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.roundToInt

fun main() = visualize(collatzConjecture(Scanner(System.`in`).nextInt()))

fun visualize(list: List<Int>, width: Int = 100) {
    val max = list.max()
    val string = StringBuilder()
    for (i in list) {
        val ratio = i.toFloat() / max
        string.append(
            "${
                when ((ratio * 10).roundToInt()) {
                    in 7..10 -> FONT_RED
                    in 5..6 -> FONT_YELLOW
                    else -> FONT_GREEN
                }
            }${
                "|".repeat(ceil(ratio * width).toInt())
            } $i (${run {
                val f: Float = 3.0f
                (ratio * 100 * 10f.pow(f)).roundToInt().toDouble() / 10f.pow(f)
            }}%)\n"
        )
    }
    print(string.toString())
}

fun collatzConjecture(num: Int): List<Int> {
    if (num <= 0) throw IllegalArgumentException("num must be greater then 0")
    var number = num
    val list = mutableListOf<Int>()
    list.add(number)
    while (number != 1) {
        if (number % 2 == 1) {
            number = number * 3 + 1
            list.add(number)
        }
        number /= 2
        list.add(number)
    }
    return list
}