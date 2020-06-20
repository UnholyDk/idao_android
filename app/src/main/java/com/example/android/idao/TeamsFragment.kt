package com.example.android.idao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.idao.databinding.FragmentTeamsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TeamsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeamsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTeamsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_teams, container, false)

        binding.bottomNavigation2.selectedItemId = R.id.page_2

        val navController = findNavController()
        return binding.root
    }
}