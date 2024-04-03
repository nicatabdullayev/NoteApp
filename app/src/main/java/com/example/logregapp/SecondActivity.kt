package com.example.logregapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.logregapp.databinding.ActivitySecondBinding
import com.example.core.ToolbarManager
import com.example.data.notesrepositroy.database.DatabaseManager

class SecondActivity : AppCompatActivity() , com.example.core.ToolbarManager {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(
            binding.bottomNavigationView,
            navController
        )


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.notesFragment , R.id.searchFragment,R.id.eventFragment
            )
//            navGraph = navController.graph

        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)

        DatabaseManager.initDatabase(this)

    }

    override fun setTitle(title: String) {
        binding.toolbar.title = title
    }
}