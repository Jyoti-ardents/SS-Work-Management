package ardents.workmanagementsystem.Activity

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ardents.workmanagementsystem.R
import ardents.workmanagementsystem.databinding.ActivityExpenseVerifyBinding
import ardents.workmanagementsystem.databinding.VerifydialogLayBinding

class ExpenseVerifyActivity : AppCompatActivity() {
    lateinit var binding:ActivityExpenseVerifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        binding=ActivityExpenseVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.btnVerify.setOnClickListener {
            showDialog()
        }
    }

    fun showDialog(){
        val builder=AlertDialog.Builder(this)
        val dialogBinding=VerifydialogLayBinding.inflate(layoutInflater)
//        val inflater=layoutInflater
//        val dialogLayout=inflater.inflate(R.layout.verifydialog_lay,null)
        builder.setView(dialogBinding.root)
        val alertDialog=builder.create()
        alertDialog.setCancelable(false)
        dialogBinding.txtReject.setOnClickListener {
            alertDialog.dismiss()
            binding.btnVerify.visibility= View.GONE
            binding.txtReject.visibility=View.VISIBLE
        }
        dialogBinding.txtApprove.setOnClickListener {
            alertDialog.dismiss()
            binding.btnVerify.visibility=View.GONE
            binding.txtApprove.visibility=View.VISIBLE
        }

        alertDialog.show()


    }
}