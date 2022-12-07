package com.example.mytodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

     lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Tasktitle = findViewById<EditText>(R.id.etTaskTitle)
        val addtask = findViewById<Button>(R.id.btnAddTask)
        val deletfdone = findViewById<Button>(R.id.btnDeleteDoneTasks)
        val rvTodoTask = findViewById<RecyclerView>(R.id.rvTodoTask)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoTask.adapter = todoAdapter
        rvTodoTask.layoutManager = LinearLayoutManager(this)

        addtask.setOnClickListener {
            val todoTitle = Tasktitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                Tasktitle.text.clear()
            }
        }
        deletfdone.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}