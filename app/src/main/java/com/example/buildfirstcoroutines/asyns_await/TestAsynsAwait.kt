package com.example.buildfirstcoroutines.asyns_await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() {

    runBlocking {
        /*    val time = measureTimeMillis {
                val a = launch { doSomeThingFunny() }
                val b = launch { doSomeThingFunny1() }
                println("${a + b}")
            }
            println("Time = $time")*/


        //syns
        val time = measureTimeMillis {
            val a: Deferred<Int> = async { doSomeThingFunny() }
            val b: Deferred<Int> = async { doSomeThingFunny1() }
            println(a.await() + b.await())
        }
        println("Time = $time")
    }
}


suspend fun doSomeThingFunny(): Int {
    delay(1000)
    return 10
}

suspend fun doSomeThingFunny1(): Int {
    delay(1000)
    return 20
}