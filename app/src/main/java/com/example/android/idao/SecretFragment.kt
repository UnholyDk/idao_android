package com.example.android.idao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.android.idao.databinding.FragmentSecretBinding
import java.util.*

class SecretFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentSecretBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_secret, container, false)

        binding.rollButton.setOnClickListener {
            val drawableResource = when (Random().nextInt(6) + 1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            binding.diceImage.setImageResource(drawableResource)
        }
        return binding.root
    }
}