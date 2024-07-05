package ardents.workmanagementsystem.Activity

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ardents.workmanagementsystem.R
import ardents.workmanagementsystem.databinding.ActivityDailyTaskBinding

class DailyTaskActivity : AppCompatActivity() {
    lateinit var binding:ActivityDailyTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        binding=ActivityDailyTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

        val task=resources.getStringArray(R.array.task)
        val taskAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,task)
        binding.autoCompleteTxtView.setAdapter(taskAdapter)

        binding.autoCompleteTxtView.setOnItemClickListener { adapterView, view, i, l ->
            val selectedTask=adapterView.getItemAtPosition(i).toString()
            if (selectedTask == "Other"){
                showOtherTaskDialog()
            }
        }
    }

    private fun showOtherTaskDialog() {
        // Create an alert dialog builder
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Other Task")

        // Set up the input
        val input = EditText(this)
        input.hint = "Enter task"
        builder.setView(input)

        // Set up the buttons
        builder.setPositiveButton("OK") { dialog, which ->
            val otherTask = input.text.toString()
            if (otherTask.isNotBlank()) {
                //Toast.makeText(this, "Entered: $otherTask", Toast.LENGTH_SHORT).show()
                // Set the text of the AutoCompleteTextView to the entered task
                binding.autoCompleteTxtView.setText(otherTask)
            } else {
                Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("Cancel") { dialog, which -> dialog.cancel() }

        builder.show()
    }
}