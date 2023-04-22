package com.example.buildfirstcoroutines.coroutinecontext

import android.util.Log
import kotlinx.coroutines.*

/*
fun main() {
*/
/*    // Job sẽ nắm giữ lifecycle của coroutines
    val job: Job = GlobalScope.launch {
        delay(2000)
        println("hello kotlin")
    }

    val job2 : Job = GlobalScope.launch {
        //onJoin chờ đợi coroutines1 hoàn thành sau đó tiếp tục job ở coroutines hiện tại
        job.join()
        delay(1000)
        println("I'm coroutines")
    }

    Thread.sleep(4000)*//*


    //Cancel coroutines
    */
/* runBlocking {
        val job: Job=  launch(Dispatchers.Default) {
             repeat(1_000){
                 delay(500)
                 println("I'm sleeping $it")
             }
         }
         delay(1500)
         job.cancel()
         println("Coroutines - Cancel")
     }*//*


    runBlocking {
        val startTime = System.currentTimeMillis()
        val job: Job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // computation loop, just wastes CPU
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}*/

/*
fun main() {
    runBlocking {
        val job : Job = launch {
            try {
                repeat(1_000){
                    delay(100L)
                    println("Hello Kotlin")
                }
            }finally {
                println("print from finally")
            }
        }
        delay(800L)
        println("I wait stop coroutines")
        job.cancel()
    }
}
*/

fun main(){
    runBlocking {
        val job : Job = launch {
            try {
                repeat(1_000){
                    delay(100L)
                    println("Hello Kotlin")
                }
            }finally {
                println("print from finally")
                withContext(NonCancellable){
                    repeat(10){
                        delay(100)
                        println("No cancel")
                    }
                }
            }
        }
        delay(2000L)
        println("I wait stop coroutines")
        job.cancel()
    }
}