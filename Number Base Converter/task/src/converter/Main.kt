package converter

import kotlin.math.pow

fun main() {

    while (true) {
        println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)")
        when (readLine()!!) {
            "/from" -> calcFrom()
            "/to" -> calcTo()
            "/exit" -> return;
        }
    }

}

fun calcTo() {
    println("Enter source number:")
    val inp = readLine()!!
    println("Enter source base:")
    val inp2 = readLine()!!.toInt()
    var res = 0
    when(inp2) {
        2 -> res = binToDecimal(inp)
        8 -> res = octToDecimal(inp)
        16 -> res = hexToDecimal(inp)
    }
    println("Conversion to decimal result: $res")
}

fun calcFrom() {
    println("Enter number in decimal system:")
    val inp = readLine()!!.toInt()
    println("Enter target base:")
    val inp2 = readLine()!!.toInt()
    var res = ""
    when(inp2) {
        2 -> res = decimalToBin(inp)
        8 -> res = decimalToOct(inp)
        16 -> res = decimalToHex(inp)
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

fun binToDecimal(v: String): Int {
    var result = 0;
    for (i in 0..v.lastIndex) {
        val temp = v[v.lastIndex - i].toString().toInt()
        result += temp * (2.0.pow(i.toDouble()).toInt())
    }
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

fun octToDecimal(v: String): Int {
    var result = 0;
    for (i in 0..v.lastIndex) {
        val temp = v[v.lastIndex - i].toString().toInt()
        result += temp * 8.0.pow(i.toDouble()).toInt();
    }
    return result;
}

fun decimalToHex(v: Int): String{
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

fun hexToDecimal(v: String): Int {
    var result = 0;
    for (i in 0..v.lastIndex) {
        val temp = when(v[v.lastIndex - i]) {
            'A','a' -> 10
            'B', 'b' -> 11
            'C', 'c' -> 12
            'D', 'd' -> 13
            'E' -> 14
            'F' -> 15
            else -> v[v.lastIndex - i].toString().toInt()
        }
        result += temp * 16.0.pow(i.toDouble()).toInt();
    }
    return result;
}