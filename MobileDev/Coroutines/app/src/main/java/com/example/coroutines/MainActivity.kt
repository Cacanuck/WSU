package com.example.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather Forecast")
            printForecast()
            printTemp()
    }
    }
    println("Execution Time: ${time / 1000.0} seconds")
}

suspend fun printTemp() {
    delay(1000)
    println("30\u00b0C")
}

suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}
