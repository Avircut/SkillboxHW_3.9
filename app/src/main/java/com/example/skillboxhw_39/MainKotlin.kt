package com.example.skillboxhw_39

import kotlin.math.absoluteValue

fun main() {
    println("Введите число N")
    val listWithNumbers=enterFewNumbers(enterTheNumber())
    positiveNumbers(listWithNumbers)
    evenNumbers(listWithNumbers)
    uniqueNumbers(listWithNumbers)
    val sum=GetASum(listWithNumbers)
    println("Сумма: $sum")
    val mapGCD= mutableMapOf<Int,Int>()
    listWithNumbers.forEach {
        val iterationGCD = GCD(it, sum)
        println("$it и $sum =$iterationGCD")
        mapGCD[it] = iterationGCD
    }
    mapGCD.forEach{
        number,gcd-> println("Число <$number>, Сумма <$sum>, НОД <$gcd>")
    }
}

fun enterTheNumber():Int{
    readLine()?.toIntOrNull()
        ?.let { N ->
            return N
        }
        ?: println("Вы ввели не число")
    return enterTheNumber()
}
fun enterFewNumbers(N:Int):List<Int>{
    var i=0;
    val listofNumbers= mutableListOf<Int>()
    println("Введите $N чисел")
    while(i<N){
        readLine()?.toIntOrNull()
            ?.let {
                listofNumbers.add(it)
                i++
            }
            ?: println("Вы ввели не число")
    }
    println("вы ввели список: $listofNumbers")
    return listofNumbers
}
fun positiveNumbers(list:List<Int>){
    var amount=0
    list.forEach{if(it>0) amount++}
    println("Количество положительных чисел: $amount")
}
fun evenNumbers(list:List<Int>){
    val filteredList=list.filter { (it%2)==0 }
    println("Список четных чисел: $filteredList")
}
fun uniqueNumbers(list:List<Int>){
    val set= list.toSet()
    println("Количество уникальных чисел: ${set.size}")
}
fun GetASum(list: List<Int>):Int = list.sum()
tailrec fun GCD(number:Int,sum:Int):Int{
    if(sum==0) return number.absoluteValue
    else return GCD(sum,number%sum)
}