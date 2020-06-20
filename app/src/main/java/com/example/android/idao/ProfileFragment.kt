package com.example.android.idao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.android.idao.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentProfileBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_profile, container, false)

        binding.bottomNavigation4.selectedItemId = R.id.page_4

        val navController = findNavController()

        binding.exit.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_titleFragment)
        }

        binding.bottomNavigation4.setOnNavigationItemSelectedListener { item->
            when(item.itemId) {
                R.id.page_1->{
                    navController.navigate(R.id.action_profileFragment_to_newsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_2->{
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_3->{
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_4->{
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
        return binding.root
    }
}