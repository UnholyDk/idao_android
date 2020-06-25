package com.example.android.idao

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.idao.adapters.TeamsAdapter
import com.example.android.idao.databinding.FragmentTeamsBinding
import com.example.android.idao.network.PersonProperty
import com.example.android.idao.network.Team

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

        binding.bottomNavigation2.setOnNavigationItemSelectedListener { item->
            when(item.itemId) {
                R.id.page_1->{
                    navController.navigate(R.id.action_teamsFragment_to_newsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_2->{
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_3->{
                    navController.navigate(R.id.action_teamsFragment_to_contestsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_4->{
                    navController.navigate(R.id.action_teamsFragment_to_profileFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        val niyaz_lead = PersonProperty(0, "Niyaz Khabibulin", "@unhollydk")
        val niyaz = PersonProperty(1, "Niyaz Khabibulin", "@unhollydk")
        val ivan_lead = PersonProperty(0, "Ivan Lebedev", "@Gudleyd")
        val a = Team("The dead will not hurt", listOf(niyaz_lead))
        val b = Team("Test team", listOf(niyaz_lead))
        val c = Team("ANTIHYPE", listOf(ivan_lead, niyaz))

        binding.listTeams.adapter = TeamsAdapter(listOf(a, b, c))

        binding.floatingActionButton.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_new_team, null)
            val editText  = dialogLayout.findViewById<EditText>(R.id.naem_tema)
            builder.setView(dialogLayout)
            builder.setPositiveButton("Next") { _, _ ->
                binding.listTeams.adapter = TeamsAdapter(listOf(Team(editText.text.toString(), listOf(niyaz_lead)), a, b, c))
            }
            builder.show()
        }
        return binding.root
    }
}