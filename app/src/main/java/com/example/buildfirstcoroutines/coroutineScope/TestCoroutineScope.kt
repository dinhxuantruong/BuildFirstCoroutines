package com.example.buildfirstcoroutines.coroutineScope

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@OptIn(DelicateCoroutinesApi::class)
fun main() {


    /*runBlocking {
        val job  = launch {
            launch {
                delay(100)
                println("Coroutine 1 : Hello")
                delay(1000)
                println("Coroutine1 : Goodbye")
            }

            launch {
                delay(100)
                println("Coroutine 2 : Hello")
                delay(1000)
                println("Coroutine2 : Goodbye")
            }

            GlobalScope.launch {
                delay(100)
                println("Coroutine 3 : Hello")
                delay(2000)
                println("Coroutine3 : Goodbye")
            }
        }
        delay(500)
        job.cancel()
        delay(2500)
    }*/

    runBlocking {
        val job = launch {
            repeat(3){
                launch {
                    delay(100)
                    println("Coroutine $it")
                }
            }
            println("print from partent")
        }
        job.join()
        delay(200)
    }
}
class myCusstomeCoroutines() : CoroutineScope{
    override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main
}