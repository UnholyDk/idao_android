package com.example.android.idao

import android.content.Intent
import android.net.Uri
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

        binding.vk.setOnClickListener {
            val browserIntent: Intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://vk.com/public173225079/"))
            startActivity(browserIntent)
        }

        binding.facebook.setOnClickListener {
            val browserIntent: Intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/IntDataAnalysisOlympiad/"))
            startActivity(browserIntent)
        }

        binding.email.setOnClickListener {
            val browserIntent: Intent = Intent(Intent.ACTION_SENDTO,
                    Uri.fromParts("mailto", "hello@idao.world", null))
            startActivity(Intent.createChooser(browserIntent, "Send email..."))
        }

        binding.aboutIdao.setOnClickListener {
            val browserIntent: Intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://idao.world/"))
            startActivity(browserIntent)
        }

        binding.bottomNavigation4.setOnNavigationItemSelectedListener { item->
            when(item.itemId) {
                R.id.page_1->{
                    navController.navigate(R.id.action_profileFragment_to_newsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_2->{
                    navController.navigate(R.id.action_profileFragment_to_teamsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_3->{
                    navController.navigate(R.id.action_profileFragment_to_contestsFragment)
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