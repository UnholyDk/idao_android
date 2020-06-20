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

        val contoller = findNavController()

        binding.exit.setOnClickListener {
            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.title_id, ProfileFragment())
            //fr?.replace(R.id.profileFragment, ProfileFragment())
            fr?.commit()
        }

        return binding.root
    }
}