package com.example.buildfirstcoroutines.firstcoroutines

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
//    runBlocking {
//        delay(1000L)
//        print("hello ")
//        delay(2000L)
//        print("world")
//    }

    val start = System.currentTimeMillis()
    runBlocking{
        repeat(1_000_000){
            println("Hello word")
        }
    }
    val end = System.currentTimeMillis()
    println("Time = ${end - start} ms")
}