package com.muktadir.photolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.muktadir.photolist.R
import com.muktadir.photolist.ui.fragment.ExitFragment
import com.muktadir.photolist.ui.fragment.PhotoListFragment
import com.muktadir.photolist.ui.fragment.ProfileFragment

class Home : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadFragment(ProfileFragment())
        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.exit -> {
                    loadFragment(ExitFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.photos -> {
                    loadFragment(PhotoListFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}