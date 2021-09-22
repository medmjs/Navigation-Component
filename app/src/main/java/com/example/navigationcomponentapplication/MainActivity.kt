package com.example.navigationcomponentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.navigationcomponentapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    lateinit var appBarConfiguration: AppBarConfiguration



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        ////////////////////////////////////////////////////////////////////////////////////    add ToolBar
        setSupportActionBar(binding.toolbar)

        var navHostFragment = supportFragmentManager.findFragmentById(R.id.main_host_fragment) as NavHostFragment

        navController = navHostFragment.findNavController()

        ////////////////////////////////////////////////////////////////////////////////////////////add nav_view_menu

        binding.navViewMenu.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.searchFragment),binding.drawerLayout)



        setupActionBarWithNavController(navController,appBarConfiguration)

        //**************************************************************************************** add bottom Nav menu

        binding.bottomNavMenu.setupWithNavController(navController)



    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp( appBarConfiguration) || super.onSupportNavigateUp()
    }


    //**************************************************************************************** add  menu

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.miterms){
            var action = NavGraphDirections.actionGlobalTermsFragment()
            navController.navigate(action)
            true
        }else{
            item.onNavDestinationSelected(navController) || super.onSupportNavigateUp()
        }

    }
    //****************************************************************************************


}