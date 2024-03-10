package com.example.thefourfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.thefourfragments.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    // Step 1: Declare a lateinit var for view binding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Step 2: Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Step 3: Set the toolbar as the app bar
        setSupportActionBar(binding.toolbar)

        // Step 4: Initialize the navigation controller
        val navController = findNavController(R.id.nav_host_fragment)

        // Step 5: Specify the top-level destinations for the app
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_login,
                R.id.navigation_counter,
                R.id.navigation_calculator,
                R.id.navigation_profile
            )
        )

        // Step 6: Set up the action bar with the navigation controller and app bar configuration
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Step 7: Set up the bottom navigation view with the navigation controller
        binding.navView.setupWithNavController(navController)
    }

    // Step 8: Override the onSupportNavigateUp method to enable Up navigation
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
