package com.igotit.retroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toolbar : ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!
        navigationView.setOnNavigationItemSelectedListener ( menuSelected )
    }

    private val menuSelected = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.navigation_home -> {
                toolbar.title = "Home"
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.naviation_car->{
                toolbar.title = "Car"
                val carFragment = CarFragment.newInstance()
                openFragment(carFragment)
                Toast.makeText(this,"CAR",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Plan ->{
                toolbar.title = "Aircraft"
                val planeFragment = PlaneFragment.newInstance()
                openFragment(planeFragment)
                Toast.makeText(this,"Plane",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_bus -> {
                Toast.makeText(this,"Bus",Toast.LENGTH_SHORT).show()
                toolbar.title = "Bus"
                val busFragment = BusFragment.newInstance()
                openFragment(busFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_truck -> {
                Toast.makeText(this,"Truck",Toast.LENGTH_SHORT).show()
                toolbar.title = "Truck"
                val truckFragment = TruckFragment.newInstance()
                openFragment(truckFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}
