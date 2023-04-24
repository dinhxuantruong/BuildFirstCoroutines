package com.example.buildfirstcoroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    val list = listOf<Int>(4, 3, 5, 2)

    runBlocking {
        //transform

        /* list.asFlow().transform {
               emit(it*it)
           }.collect(){
               println("Value = $it")
           }*/
        //map
        /*  list.asFlow().map { it * 3 }.collect {
              println(it)
          }*/

        //take

//        list.asFlow().take(3).collect{
//            println(it)
//        }

        //filter

//        list.asFlow().filter { it %2 ==0 }.map { it * 2 }.collect{
//            println(it)
//        }

        //reduce

        /*  val sum = list.asFlow().reduce{ accumulator, value ->
              println("accumulator = $accumulator and value = $value")
              accumulator + value
          }
          println("Sum = $sum")*/

        //fold

        /*val sum = list.asFlow().fold(5){ accumulator, value ->
            println("accumulator = $accumulator and value = $value")
            accumulator + value
        }
        println("Sum = $sum")*/


        //Single and SingleOrNull -- SingleOrNull sẽ chỉ throw ra exception khi mà flow > 1 còn < 1 sẽ trả về null
        /*
        * Kiểm tra xem Flow có emit ra 1 giá trị hay không*/

        /*  try {
              (1..10).asFlow().single()
          }catch (e : IllegalArgumentException){
              println(e.message)
          }
  */
        /*  val a = listOf<Int>(8).asFlow().singleOrNull()
          println(a)*/

        //zip -- kết hợp 2 Flow lại với nhau
    /*    val num1 = (1..3).asFlow().onEach { delay(100) }
        val sts = listOf("one", "two", "three").asFlow().onEach { delay(400) }

        var star = System.currentTimeMillis()
        num1.zip(sts) { num, str ->
            "$num ----  $str"
        }.collect {
            println(it)
        }
        var end = System.currentTimeMillis()
        println("Time = ${end - star}")
        //combine

        println("==============================")

         star = System.currentTimeMillis()
        num1.combine(sts) { num, str ->
            "$num ----  $str"
        }.collect {
            println(it)
        }
         end = System.currentTimeMillis()
        println("Time = ${end - star}")*/

        //Flatmap-concat
   /*     val startime = System.currentTimeMillis()
        (1..3).asFlow().onEach { delay(100) }
            .flatMapConcat { requesFlow(it) }.collect{
                println("$it --- ${System.currentTimeMillis() -  startime}")
            }*/

        //Flatmap-mage
    /*    val startime = System.currentTimeMillis()
        (1..3).asFlow().onEach { delay(100) }
            .flatMapMerge { requesFlow(it) }.collect {
                println("$it --- ${System.currentTimeMillis() - startime}")
            }*/


        //flatMap-latest
        val startime = System.currentTimeMillis()
        (1..3).asFlow().onEach { delay(100) }
            .flatMapLatest { requesFlow(it) }.collect {
                println("$it --- ${System.currentTimeMillis() - startime}")
            }
    }
}

fun requesFlow(i : Int) : Flow<String> = flow {
    emit("$i : First")
    delay(500)
    emit("$i : Second")
}

