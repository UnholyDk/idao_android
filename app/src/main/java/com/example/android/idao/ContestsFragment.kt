package com.example.android.idao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.idao.databinding.FragmentContestsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Contests.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContestsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentContestsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_contests, container, false)

        binding.bottomNavigation3.selectedItemId = R.id.page_3

        val navController = findNavController()

        binding.bottomNavigation3.setOnNavigationItemSelectedListener { item->
            when(item.itemId) {
                R.id.page_1->{
                    navController.navigate(R.id.action_contestsFragment_to_newsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_2->{
                    navController.navigate(R.id.action_contestsFragment_to_teamsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_3->{
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_4->{
                    navController.navigate(R.id.action_contestsFragment_to_profileFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        return binding.root
    }
}