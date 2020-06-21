package com.example.android.idao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.idao.databinding.FragmentNewsBinding
import kotlinx.android.synthetic.main.fragment_title.*


class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentNewsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_news, container, false)



        binding.bottomNavigation1.selectedItemId = R.id.page_1

        val navController = findNavController()

        binding.bottomNavigation1.setOnNavigationItemSelectedListener { item->
            when(item.itemId) {
                R.id.page_1->{
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_2->{
                    navController.navigate(R.id.action_newsFragment_to_teamsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_3->{
                    navController.navigate(R.id.action_newsFragment_to_contestsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_4->{
                    navController.navigate(R.id.action_newsFragment_to_profileFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        val tmp: List<News> = listOf(
                News("IDAO 2020", "``` [++HSE Faculty of Computer Science++](https://cs.hse.ru/en/) and Yandex launch registration for the 3rd International Data Analysis Olympiad ([++IDAO 2020++](https://idao.world/)). The platinum partner of IDAO 2020 is Qiwi. \n\nThe Olympiad includes two stages:\n\n**Online Stage:**\n\n- Traditional machine learning competition on Yandex.Contest platform. You will need to make new predictions and upload them to the automatic verification system.\n- Track 2: Come up with a solution for the same problem, keeping within a rigid framework of time and memory used.\n\n**Offline Stage (Final):**\n\n- The top 30 teams according to the Online Stage results will be invited to the on-site final, which will be held on April 2-5 in Yandex office, Moscow .\n- In the final 36 hours of the competition, participants will try not just to train the model, but to create a full-fledged prototype, which will be tested both in terms of accuracy and performance. \n\nAs part of IDAO Final, performances and master classes of world experts in machine learning and data analysis are also planned.\n\nIn 2019, 2187 participants from 78 countries took part in IDAO, and 79 participants from 7 countries met in the final in Moscow. \n\nWinners and prize-winners of IDAO 2020 will receive valuable prizes and gifts, as well as an advantage in entering Yandex School of Data Analysis and master's programmes at the HSE Faculty of Computer Science.\n```",
                        "2019-11-13", 1),
                News("Online Stage starts today! ", " Dear participants,\n\nWe are delighted to announce that IDAO 2020 starts on January 15, 2020.\n\nWhat is next? Now all teams are able to join contest via[ ++IDAO platform++](https://register.idao.world/#/auth). When inside the platform, click “Contest” button and choose “Join a contest” option to access the competition. All teams MUST join the contest until January 21, so within this time new teams are able to join. If a team has already joined the contest, it can not change team members.  \n\nAfter your team joins the competition, it will receive Yandex.Contest login and password via email. This email will also contain the link to the Online Task. Please notice that the Task will be open at 12-00 (UTC +3) on January 15, 2020.\n\nSome important notes:\n\n1.    This year all teams MUST consist of 2 or 3 members. If you struggle to find teammates, you can find them via our Telegram chat -[ ++https://t.me/IDAOworld++](https://t.me/IDAOworld) .\n\n2.    After January 21 there WON’T be possibilities to change teams or create new once.\n\n3.    If you face any problems or technical issues, please feel free to contact us: hello@idao.world\n\n4. Employees of companies that provide tasks for IDAO 2020 can only participate hors concours. In 2020 year these organizations are Russian Astronomical Science Center (ASC), the Laboratory of Methods for Big Data Analysis (LAMBDA, HSE University) and QIWI Russia.   \n",
                        "2020-01-14", 1)
        )
        val adapter = NewsAdapter(tmp)
        binding.listNews.adapter = adapter
        return binding.root
    }
}
