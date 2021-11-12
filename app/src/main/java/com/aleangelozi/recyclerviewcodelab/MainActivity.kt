package com.aleangelozi.recyclerviewcodelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Follow Android Devs", false),
            Todo("Learn about Android Development", false),
            Todo("Learn about Machine Learning", false),
            Todo("Learn about CyberSecurity", false),
            Todo("Speak about what you've learned", false)
        )

        val adapter = TodoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.btnAddTodo)
        button.setOnClickListener {
            val title = findViewById<TextView>(R.id.etTodo).text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}