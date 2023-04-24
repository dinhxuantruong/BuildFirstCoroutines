package com.example.buildfirstcoroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        foo(5).collect{
            println("i = $it")
        }

       /* foo(10).filter { it > 6 }.collect {
            println(it)
        }*/
    }
}

fun foo(x : Int) : Flow<Int> = flow {
    for (i in 1..x){
        delay(1000)
        emit(i)
    }
}