package com.example.buildfirstcoroutines.coroutinecontext

import android.util.Log
import com.example.buildfirstcoroutines.MainActivity
import kotlinx.coroutines.*

object TestWithContext {

/*    @OptIn(DelicateCoroutinesApi::class)
    fun testMyFirstWithContext(){
        newSingleThreadContext("Thread 1").use { context1 ->
            Log.d(MainActivity::class.java.simpleName,"Context1 - Thread ${Thread.currentThread().name}")
            newSingleThreadContext("Thread 2").use { context2 ->
                Log.d(MainActivity::class.java.simpleName,"Context2 - Thread ${Thread.currentThread().name}")

                runBlocking(context1) {
                    Log.d(MainActivity::class.java.simpleName,"Working Context1 - Thread ${Thread.currentThread().name}")
                    withContext(context2){
                        Log.d(MainActivity::class.java.simpleName,"Working Context2 - Thread ${Thread.currentThread().name}")
                    }
                    Log.d(MainActivity::class.java.simpleName,"Back to Context1 - Thread ${Thread.currentThread().name}")
                }
            }
        }
    }*/

    fun TestSecoundMyWithContext(){
        GlobalScope.launch(Dispatchers.IO) {
            // Run long time task
            Log.d(MainActivity::class.java.simpleName,"Run long time task - Thread ${Thread.currentThread().name}")
            delay(2000)
            withContext(Dispatchers.Main){
            //Update UI
                Log.d(MainActivity::class.java.simpleName,"Update Thread UI- Thread ${Thread.currentThread().name}")
            }
        }
    }
}