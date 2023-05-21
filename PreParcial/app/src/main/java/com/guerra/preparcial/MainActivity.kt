package com.guerra.preparcial

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guerra.preparcial.databinding.ActivityMainBinding
import com.guerra.preparcial.ui.dragonball.viewmodel.DragonViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dragonViewModel: DragonViewModel by viewModels {
        DragonViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)
    }
}