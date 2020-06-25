package com.example.android.idao.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.idao.MainActivity
import com.example.android.idao.NewsAdapter
import com.example.android.idao.R
import com.example.android.idao.network.Team
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.fragment_profile.view.*

class TeamsAdapter(private var data: List<Team>): RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_teams, parent, false)
        return TeamsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.nameTeam.text = item.nameTeam

        if (item.members[0].id != 0)
            holder.leader1.visibility = View.GONE

        holder.name1.text = item.members[0].name
        holder.username1.text = item.members[0].username

        holder.member2.visibility = View.GONE
        holder.member3.visibility = View.GONE

        if (item.members.size > 1) {
            if (item.members[1].id != 0)
                holder.leader2.visibility = View.GONE

            holder.name2.text = item.members[1].name
            holder.username2.text = item.members[1].username
            holder.member2.visibility = View.VISIBLE
        }

        if (item.members.size > 2) {
            if (item.members[2].id != 0)
                holder.leader3.visibility = View.GONE

            holder.name3.text = item.members[2].name
            holder.username3.text = item.members[2].username
            holder.member3.visibility = View.VISIBLE
        }

        holder.delete.setOnClickListener {
            data = data.minusElement(data[position])
            notifyItemRemoved(position)
        }
        

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTeam: TextView = itemView.findViewById(R.id.nameTeam)

        val name1 : TextView = itemView.findViewById(R.id.member_name)
        val username1: TextView = itemView.findViewById(R.id.member_username)
        val leader1: TextView = itemView.findViewById(R.id.is_leader)

        val member2: MaterialCardView = itemView.findViewById(R.id.member2)
        val name2 : TextView = itemView.findViewById(R.id.member_name2)
        val username2: TextView = itemView.findViewById(R.id.member_username2)
        val leader2: TextView = itemView.findViewById(R.id.is_leader2)

        val member3: MaterialCardView = itemView.findViewById(R.id.member3)
        val name3 : TextView = itemView.findViewById(R.id.member_name3)
        val username3: TextView = itemView.findViewById(R.id.member_username3)
        val leader3: TextView = itemView.findViewById(R.id.is_leader3)

        val delete: MaterialButton = itemView.findViewById(R.id.DELETE)
        val edit: MaterialButton = itemView.findViewById(R.id.EDIT)
    }
}

