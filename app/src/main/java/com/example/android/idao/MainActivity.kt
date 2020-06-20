/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.idao

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.idao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        Log.i("MainActivity", "setupActionBar called")

//        binding.NAVIGATION.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.page_1 -> {
//                    title = "News"
//                    loadFragment(NewsFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.page_2->{
//                    title = "Teams"
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.page_3->{
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.page_4->{
//                    loadFragment(ProfileFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//            }
//            false
//        }

        //val bottom = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        //val tmp = FragmentNewsBinding.
        //println(bottom)
        //bottom.setOnNavigationItemSelectedListener(nav)
    }

//    private fun loadFragment(fragment: Fragment) {
//        val tr = supportFragmentManager.beginTransaction()
//        tr.replace(R.id.CONTAINER, fragment)
//        tr.addToBackStack(null)
//        tr.commit()
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}
