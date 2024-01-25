package com.example.thefourfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.thefourfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflates(creates views from XML layout files.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // allows for binding on any fragments in project
        setContentView(binding.root)

        binding.apply {
            //Set the toolbar using the default method
            setSupportActionBar(toolbar)

            // Drawer & Navigation Controller
            val navController = findNavController(R.id.nav_host_fragment)
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_login,
                    R.id.navigation_counter,
                    R.id.navigation_calculator,
                    R.id.navigation_profile
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)

        }

        // Navigation Controller

    }
}