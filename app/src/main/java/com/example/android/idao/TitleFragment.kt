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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.android.idao.databinding.FragmentTitleBinding
import com.example.android.idao.network.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TitleFragment : Fragment() {

    fun postAuth(dataPerson: UserInfo, navContoller: NavController) {
        val viewModelJob = Job()
        var answer: DataForApi
        val coroutineScope = CoroutineScope((viewModelJob + Dispatchers.Main))
        coroutineScope.launch {
            val postAuthDeferred = IdaoApi.retrofitService.authorization(dataPerson)
            try {
                answer = postAuthDeferred.await()
                navContoller.navigate(R.id.action_titleFragment_to_newsFragment)
            } catch (t:Throwable) {
                Toast.makeText(context, "Wrong username or password\nFailure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false)

        val navContoller = findNavController()

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
                    postAuth(UserInfo(username, password), navContoller)
                }
            }
        }
        return binding.root
    }
}
