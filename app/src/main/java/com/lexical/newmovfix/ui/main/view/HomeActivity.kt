//package com.lexical.newmovfix.ui.main.view
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.navigation.NavController
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.fragment.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import com.lexical.newmovfix.R
//import com.lexical.newmovfix.databinding.ActivityHomeBinding
//
//class HomeActivity : AppCompatActivity() {
//
//    private lateinit var navController: NavController
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        val binding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
//        navController = navHostFragment.findNavController()
//
//        val appBarConfiguration = AppBarConfiguration.Builder(
//            R.id.menu_movie, R.id.menu_favorite
//        ).build()
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.apply {
//            navBottom.setupWithNavController(navController)
//        }
//    }
//}