package com.rohit.jetpackapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.rohit.jetpackapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var navController: NavController? = null
    var appBar: AppBarConfiguration? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController = findNavController(R.id.host)
        appBar = AppBarConfiguration(navController!!.graph)
        setupActionBarWithNavController(navController!!, appBar!!)

        binding?.bottomNavView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> navController!!.navigate(R.id.secondFragment)
            }
            return@setOnItemSelectedListener true
        }

    }



    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController!!.popBackStack()
    }
}