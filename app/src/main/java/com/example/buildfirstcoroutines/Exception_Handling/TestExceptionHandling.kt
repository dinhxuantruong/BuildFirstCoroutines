package com.example.buildfirstcoroutines.Exception_Handling

import kotlinx.coroutines.*

/*
@OptIn(DelicateCoroutinesApi::class)
fun main() {

     runBlocking {
         fun handler() = CoroutineExceptionHandler { _, throwable ->
             println("Erro : $throwable")
         }

         val job = GlobalScope.launch(handler()) {
             println("Throw exception from lauch")
             throw NullPointerException()
         }
         job.join()


         val deferred = GlobalScope.async(handler()) {
             println("Throw exception from syns")
             throw IndexOutOfBoundsException()
         }

         try {
             deferred.await()
         }catch (e : IndexOutOfBoundsException){
             println(e.message)
         }
     }
}*/

/*
fun main(){
    runBlocking {
        val supervisorjob = SupervisorJob()
        with(CoroutineScope(coroutineContext + supervisorjob)){
            val firstChild = launch {
                println("Print from First Child")
                throw NullPointerException()
            }

            val secondChild = launch {
                firstChild.join()
                println("Print from Second Child. First child is Active : ${firstChild.isActive}")
                 try {
                     delay(100)
                 }finally {
                     println("Second Child Cancel")
                 }
            }
            firstChild.join()
            println("Cancelling supervisorjob")
            supervisorjob.cancel()
            secondChild.join()
        }
    }
}*/

 fun main() {
     runBlocking {
         supervisorScope {
             val firstChild = launch {
                 println("Print from First Child")
                 throw NullPointerException()
             }

             val secondChild = launch {
                 firstChild.join()
                 println("Print from Second Child. First child is Active : ${firstChild.isActive}")
                 try {
                     delay(100)
                 } finally {
                     println("Second Child Cancel")
                 }
             }
             firstChild.join()
             secondChild.join()
         }
     }
 }
