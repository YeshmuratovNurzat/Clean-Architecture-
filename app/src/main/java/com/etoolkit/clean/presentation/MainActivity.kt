package com.etoolkit.clean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.etoolkit.clean.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("My","Activity cleared")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.resultLiveData.observe(this,{text ->
            binding.getDataTextView.text = text
        })

        binding.getDataButton.setOnClickListener {
            viewModel.load()
        }

        binding.saveDataButton.setOnClickListener {
            val text = binding.editTextSaveData.text.toString()
            viewModel.save(text)
        }
    }
}
