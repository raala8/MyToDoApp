package com.example.mytodoapp

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_todo.view.*

class TodoAdapter(private val todos: MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {



        return TodoViewHolder(

            LayoutInflater.from(parent.context).inflate(
                R.layout.task_todo,
                parent,
                false
            )
        )
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        todos.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val curTodo = todos[position]
        holder.itemView.apply {
            tvTaskToDo.text = curTodo.title
            cbFinish.isChecked = curTodo.isChecked
            toggleStrikeThrough(tvTaskToDo, curTodo.isChecked)
            cbFinish.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvTaskToDo, isChecked)
                curTodo.isChecked = !curTodo.isChecked
                
                
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}







val Tasktodo = itemView.findViewById<TextView>(R.id.tvTaskToDo)
val Fin = itemView.findViewById<CheckBox>(R.id.cbFinish)








