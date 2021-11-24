package com.example.hw3_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw3_recyclerview.databinding.ActivityMainBinding

var user = 1
var countMessageFirstUser = 0
var countMessageSecondUser = 0

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter(){
        binding.apply {
            chatRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            chatRecyclerView.adapter = adapter

            sendButton.setOnClickListener {
                adapter.addMessage(Messages(user, editText.text.toString()))
                editText.setText("")

                if(user == 1)
                    countMessageFirstUser++
                else
                    countMessageSecondUser++
            }
        }
    }
}