package ardents.workmanagementsystem.Activity

import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ardents.workmanagementsystem.R
import ardents.workmanagementsystem.databinding.ActivityPdfInsuranceBinding

class PdfInsuranceActivity : AppCompatActivity() {
    lateinit var binding:ActivityPdfInsuranceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        binding=ActivityPdfInsuranceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var pdfUrl = intent.getStringExtra("pdfurl")!!
        Log.d("pdfurll",pdfUrl)

        binding.webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
        }
        binding.webView.webViewClient = WebViewClient()

        // URL of the PDF file

        // Google Docs viewer URL
        val googleDocsUrl = "https://docs.google.com/viewer?url=$pdfUrl"
        binding.webView.loadUrl(pdfUrl)

        // Load the PDF using Google Docs viewer
    }
}