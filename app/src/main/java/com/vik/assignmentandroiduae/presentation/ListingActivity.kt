package com.vik.assignmentandroiduae.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vik.assignmentandroiduae.databinding.ActivityListingBinding
import com.vik.detailsscreen.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListingBinding
    private val viewModel: ListingViewModel by viewModels()
    private val adapter = UniversityAdapter { university ->
        detailsLauncher.launch(Intent(this, DetailsActivity::class.java).apply {
            putExtra("name", university?.name)
            putExtra("country", university?.country)
            putExtra("state", university?.state)
            putExtra("webpage", university?.web_pages?.firstOrNull())
        })
    }

    private val detailsLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data?.getBooleanExtra("refresh", false) == true) {
                viewModel.fetchUniversities()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.universities.collect { universities ->
                adapter.submitList(universities)
            }
        }
    }

    private fun startDetailsActivity(universityId: String) {
        // Pass the university ID to the DetailsActivity
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("UNIVERSITY_ID", universityId)
        startActivity(intent)
    }
}
