package com.example.todoapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.lifecycle.lifecycleScope
import com.example.todoapp.databinding.ActivityTaskBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

const val DB_NAME = "todo.db"

class TaskActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var myCalendar: Calendar

    lateinit var dateSetListener: DatePickerDialog.OnDateSetListener
    lateinit var timeSetListener: TimePickerDialog.OnTimeSetListener

    var finalDate = 0L
    var finalTime = 0L

    private val labels = arrayListOf("Pessoal", "Trabalho", "Aula", "Shopping", "Exercício")

    private lateinit var binding: ActivityTaskBinding

    val db by lazy {
        AppDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listeners
        binding.dateEdt.setOnClickListener(this)
        binding.timeEdt.setOnClickListener(this)
        binding.saveBtn.setOnClickListener(this)

        setUpSpinner()
    }

    private fun setUpSpinner() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, labels)
        labels.sort()
        binding.spinnerCategory.adapter = adapter
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.dateEdt -> {
                setListener()
            }
            R.id.timeEdt -> {
                setTimeListener()
            }
            R.id.saveBtn -> {
                saveTodo()
            }
        }
    }

    private fun saveTodo() {
        val category = binding.spinnerCategory.selectedItem.toString()
        val title = binding.titleInpLay.editText?.text.toString()
        val description = binding.taskInpLay.editText?.text.toString()

        lifecycleScope.launch(Dispatchers.Main) {
            val id = withContext(Dispatchers.IO) {
                db.todoDao().insertTask(
                    TodoModel(
                        title,
                        description,
                        category,
                        finalDate,
                        finalTime
                    )
                )
            }
            finish()
        }
    }

    private fun setTimeListener() {
        myCalendar = Calendar.getInstance()

        timeSetListener =
            TimePickerDialog.OnTimeSetListener { _: TimePicker, hourOfDay: Int, min: Int ->
                myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                myCalendar.set(Calendar.MINUTE, min)
                updateTime()
            }

        val timePickerDialog = TimePickerDialog(
            this, timeSetListener, myCalendar.get(Calendar.HOUR_OF_DAY),
            myCalendar.get(Calendar.MINUTE), false
        )
        timePickerDialog.show()
    }

    private fun updateTime() {
        val myformat = "h:mm a"
        val sdf = SimpleDateFormat(myformat)
        finalTime = myCalendar.time.time
        binding.timeEdt.setText(sdf.format(myCalendar.time))
    }

    private fun setListener() {
        myCalendar = Calendar.getInstance()

        dateSetListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDate()
            }

        val datePickerDialog = DatePickerDialog(
            this, dateSetListener, myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate = System.currentTimeMillis()
        datePickerDialog.show()
    }

    private fun updateDate() {
        val myformat = "EEE, d MMM yyyy"
        val sdf = SimpleDateFormat(myformat)
        finalDate = myCalendar.time.time
        binding.dateEdt.setText(sdf.format(myCalendar.time))

        binding.timeInptLay.visibility = View.VISIBLE
    }
}
