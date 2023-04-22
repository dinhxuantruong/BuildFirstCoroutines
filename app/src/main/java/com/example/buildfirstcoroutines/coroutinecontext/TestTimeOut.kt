package com.example.buildfirstcoroutines.coroutinecontext

import kotlinx.coroutines.*

fun main() {
    // withTimeoutOrNull giới hạn thời gian thực thi crroutine  -> cancel nếu time out
    runBlocking {
        /*withTimeout(1800L){
            repeat(10){
                println("Time out")
                delay(500L)
            }
        }*/

       val result =  withTimeoutOrNull(1500L){
            repeat(2){
                println("Time out")
                delay(500L)
            }
           "Done"
        }
        println("Result = $result")
    }
}