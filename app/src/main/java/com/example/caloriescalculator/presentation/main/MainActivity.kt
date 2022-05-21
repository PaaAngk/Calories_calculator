package com.example.caloriescalculator.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.caloriescalculator.R
import com.example.caloriescalculator.app.App
import com.example.caloriescalculator.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
//    @Inject
//    lateinit var mViewModel: MainViewModel
    private val mBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CaloriesCalculator)
        setContentView(R.layout.activity_main)

        mBinding.navView.setupWithNavController(findNavController(R.id.fragment_nav))

        (application as App).appComponent.inject(this)
        //mViewModel.updatePokemonIds()
    }
}

