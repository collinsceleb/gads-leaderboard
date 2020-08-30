package com.bdn.collinsceleb.gadsleaderboard.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bdn.collinsceleb.gadsleaderboard.ui.fragments.learning.LearningFragment
import com.bdn.collinsceleb.gadsleaderboard.ui.fragments.skill.SkillFragment


class ViewPagerFragmentAdapter(manager: FragmentManager?, lifecycle: Lifecycle) : FragmentStateAdapter(manager!!, lifecycle) {

   private val items = 2

    override fun getItemCount(): Int {
        return items
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = LearningFragment.newInstance()
            1 -> fragment = SkillFragment.newInstance()
        }
        return fragment!!
    }


}