package ardents.workmanagementsystem

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ardents.workmanagementsystem.Activity.BaseActivity
import ardents.workmanagementsystem.Activity.CreateWorkActivity
import ardents.workmanagementsystem.Activity.DailyTaskActivity
import ardents.workmanagementsystem.Activity.ExpenseActivity
import ardents.workmanagementsystem.Activity.ExpenseVerifyActivity
import ardents.workmanagementsystem.Activity.InsuranceActivity
import ardents.workmanagementsystem.Activity.LoginActivity
import ardents.workmanagementsystem.Activity.ReportActivity
import ardents.workmanagementsystem.Activity.UpdateWorkActivity
import ardents.workmanagementsystem.databinding.ActivityMainBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.slider.Slider
import java.util.ArrayList

class MainActivity : BaseActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.cardReport.setOnClickListener {
            startActivity(Intent(applicationContext,ReportActivity::class.java))
        }
        binding.cardCreatework.setOnClickListener {
            startActivity(Intent(applicationContext,DailyTaskActivity::class.java))
        }
        binding.cardExpense.setOnClickListener {
            startActivity(Intent(applicationContext,ExpenseActivity::class.java))
        }
        binding.cardUpdatework.setOnClickListener {
            startActivity(Intent(applicationContext,UpdateWorkActivity::class.java))
        }
        binding.cardVerifyExpense.setOnClickListener {
            startActivity(Intent(applicationContext,ExpenseVerifyActivity::class.java))
        }
        binding.cardInsurance.setOnClickListener {
            startActivity(Intent(applicationContext,InsuranceActivity::class.java))
        }
        binding.imgLogout.setOnClickListener {
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }

//        binding.bottomNavigation.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.bottom_reports -> {
//                    val intent=Intent(applicationContext,ReportActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//
//                else -> {
//                    true
//                }
//            }
//        }

        val sliderList= ArrayList<SlideModel>()
        sliderList.add(SlideModel(R.drawable.s3,ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.s1,ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.s2,ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.s4,ScaleTypes.FIT))
        binding.imageSlider.setImageList(sliderList)




    }
}