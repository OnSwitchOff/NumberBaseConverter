package converter

fun main() {
    println("Enter number in decimal system:")
    val inp = readLine()!!.toInt()
    println("Enter target base:")
    val inp2 = readLine()!!.toInt()
    var res = ""
    when(inp2) {
        2 -> res = decimalToBin(inp)
        8 -> res = decimalToOct(inp)
        16 -> res = decimalToHEX(inp)
    }
    println("Conversion result: $res")
}

fun decimalToBin(v: Int): String {
    var inp = v;
    var result: String = ""
    while (inp > 0) {
        result = (inp % 2).toString() + result;
        inp /= 2;
    }
    if (inp > 0)
    result = inp.toString() + result;
    return result;
}

fun decimalToOct(v: Int): String {
    var inp = v;
    var result: String = ""
    while (inp > 0) {
        result = (inp % 8).toString() + result;
        inp /= 8;
    }
    if (inp > 0)
    result = inp.toString() + result;
    return result;
}

fun decimalToHEX(v: Int): String{
    var inp = v;
    var result: String = ""
    while (inp > 0) {
        val temp = inp % 16
        val dig = when (temp) {
                10 -> "A"
                11 -> "B"
                12 -> "C"
                13 -> "D"
                14 -> "E"
                15 -> "F"
                else -> temp.toString()
        }
        result = dig + result
        inp /= 16;
    }
    return result;
}