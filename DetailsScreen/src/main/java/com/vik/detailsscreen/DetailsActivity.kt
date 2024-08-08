package com.vik.detailsscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vik.detailsscreen.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val university: String? = intent.getStringExtra("name")
        val country: String? = intent.getStringExtra("country")
        val state: String? = intent.getStringExtra("state")
        val webpage: String? = intent.getStringExtra("webpage")
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        university?.let {
            binding.universityName.text = university
        }
        country?.let {
            binding.country.text = country
        }
        state?.let {
            binding.state.text = state
        }
        webpage?.let {
            binding.webPages.text = webpage
        }

        binding.refresh.setOnClickListener {
            setResult(RESULT_OK, Intent().apply {
                putExtra("refresh", true)
            })
            finish()
        }
    }
}