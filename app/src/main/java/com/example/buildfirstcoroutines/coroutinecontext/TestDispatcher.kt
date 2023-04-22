package com.example.buildfirstcoroutines.coroutinecontext

import android.util.Log
import com.example.buildfirstcoroutines.MainActivity
import kotlinx.coroutines.*

object TestDispatcher {

    @OptIn(DelicateCoroutinesApi::class)
    fun runMyFirstCoroutines(){
       /* GlobalScope.launch(Dispatchers.Default){
            Log.i(MainActivity::class.java.simpleName,"Dispatcher default run on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.IO){
            Log.i(MainActivity::class.java.simpleName,"Dispatcher IO run on ${Thread.currentThread().name}")
        }*/

        GlobalScope.launch(Dispatchers.Main){
            Log.i(MainActivity::class.java.simpleName,"Dispatcher Main run on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Unconfined){
            Log.i(MainActivity::class.java.simpleName," Before Dispatcher Unconfined run on ${Thread.currentThread().name}")
            delay(1000L)
            Log.i(MainActivity::class.java.simpleName,"Dispatcher Unconfined run on ${Thread.currentThread().name}")
        }

       /* GlobalScope.launch(newSingleThreadContext("My thread")){
            Log.i(MainActivity::class.java.simpleName,"Run on ${Thread.currentThread().name}")
        }*/
    }
}