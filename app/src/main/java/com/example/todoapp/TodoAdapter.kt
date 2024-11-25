package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTodoBinding
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(private val list: List<TodoModel>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // 1st func: In this, we use View Binding to inflate the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    // 2nd func: Binding the data to the view holder
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    // 3rd func: Returning the item count
    override fun getItemCount() = list.size

    // 4th func: Return the item ID (if you have a unique ID)
    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    // View Holder class that uses View Binding
    class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todoModel: TodoModel) {
            with(binding) {
                val colors = itemView.resources.getIntArray(R.array.random_color)
                val randomColor = colors[Random().nextInt(colors.size)]
                viewColorTag.setBackgroundColor(randomColor)

                // Set the text fields with data from todoModel
                txtShowTitle.text = todoModel.title
                txtShowTask.text = todoModel.description
                txtShowCategory.text = todoModel.category

                // Update the time and date using the provided methods
                updateTime(todoModel.time)
                updateDate(todoModel.date)
            }
        }

        private fun updateTime(time: Long) {
            val myFormat = "h:mm a"
            val sdf = SimpleDateFormat(myFormat)
            binding.txtShowTime.text = sdf.format(Date(time))
        }

        private fun updateDate(time: Long) {
            val myFormat = "EEE, d MMM yyyy"
            val sdf = SimpleDateFormat(myFormat)
            binding.txtShowDate.text = sdf.format(Date(time))
        }
    }
}
