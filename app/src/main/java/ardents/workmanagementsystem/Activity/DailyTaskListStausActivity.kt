package ardents.workmanagementsystem.Activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ardents.workmanagementsystem.R
import ardents.workmanagementsystem.databinding.ActivityDailyTaskListStausBinding

class DailyTaskListStausActivity : AppCompatActivity() {
    lateinit var binding: ActivityDailyTaskListStausBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDailyTaskListStausBinding.inflate(layoutInflater)
       // enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val workStatus=resources.getStringArray(R.array.work_status)
        val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,workStatus)
        binding.autoCompleteTxtView.setAdapter(arrayAdapter)

        binding.backBtn.setOnClickListener {
            finish()
        }

       // binding.txtInputLayout.boxStrokeColor=android.R.color.transparent
    }
}