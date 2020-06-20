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

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.android.idao.databinding.FragmentTitleBinding
import com.example.android.idao.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TitleFragment : Fragment() {

    private var answer: DataForApi? = null

    private fun postAuth(dataPerson: UserInfo) {
        IdaoApi.retrofitService.authorization(dataPerson).enqueue( object: Callback<DataForApi> {
            override fun onFailure(call: Call<DataForApi>, t: Throwable) {
                Toast.makeText(context, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<DataForApi>, response: Response<DataForApi>) {
                println("Access")
                answer = response.body()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false)

        binding.register.setOnClickListener {
            val browserIntent: Intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://register.idao.world/"))
            startActivity(browserIntent)
        }

        binding.yellowStar.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_secretFragment)
        )

        binding.logIn.setOnClickListener { view->
            val username = binding.login.text.toString()
            val password = binding.password.text.toString()
            when {
                username.isEmpty() -> {
                    Toast.makeText(context, "Entered your username", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(context, "Entered your password", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    postAuth(UserInfo(username, password))
                    if (answer == null) {
                        Toast.makeText(context, "Wrong username or password", Toast.LENGTH_SHORT).show()
                    } else {
                        //Toast.makeText(context, answer!!.accessToken, Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_newsFragment)
                    }
                    //Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_newsFragment)
                }
            }
        }
        return binding.root
    }
}
