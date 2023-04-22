package com.example.buildfirstcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buildfirstcoroutines.coroutinecontext.TestDispatcher
import com.example.buildfirstcoroutines.coroutinecontext.TestWithContext
import com.example.buildfirstcoroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        TestDispatcher.runMyFirstCoroutines()
//        TestWithContext.testMyFirstWithContext()
//        TestWithContext.TestSecoundMyWithContext()
    }
}