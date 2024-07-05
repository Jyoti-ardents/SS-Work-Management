package ardents.workmanagementsystem.Activity

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ardents.workmanagementsystem.R
import ardents.workmanagementsystem.databinding.ActivityExpenseBinding
import kotlin.math.exp

class ExpenseActivity : AppCompatActivity() {
    private val PICK_FILE_REQUEST_CODE = 1
    lateinit var binding:ActivityExpenseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        binding=ActivityExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.imgChooseFile.setOnClickListener {
            pickFile()
        }


        val expense=resources.getStringArray(R.array.expense)
        val expenseAdapter=ArrayAdapter(this , android.R.layout.simple_list_item_1, expense)
        binding.autoCompleteTxtView.setAdapter(expenseAdapter)

    }
    private fun pickFile(){
        val intent=Intent(Intent.ACTION_GET_CONTENT)
        intent.type="*/*"
        startActivityForResult(intent,PICK_FILE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==PICK_FILE_REQUEST_CODE && resultCode== Activity.RESULT_OK){
            data?.data?.let {
                val fileName = getFileName(it)
                binding.uplaodBill.setText(fileName)
            }
        }
    }

    private fun getFileName(uri: Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
            cursor.use {
                if (it != null && it.moveToFirst()) {
                    val nameIndex= it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    if (nameIndex >= 0){
                        result= it.getString(nameIndex)
                    }
                    //result = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                }
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/')
            if (cut != null && cut != -1) {
                result = result?.substring(cut + 1)
            }
        }
        return result ?: "Unknown file"
    }
}