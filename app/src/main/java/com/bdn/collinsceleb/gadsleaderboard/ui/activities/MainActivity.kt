package com.bdn.collinsceleb.gadsleaderboard.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.bdn.collinsceleb.gadsleaderboard.adapters.ViewPagerFragmentAdapter
import com.bdn.collinsceleb.gadsleaderboard.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        tabLayout = binding.tabs
        viewPager2 = binding.viewPager2
        viewPager2!!.adapter = ViewPagerFragmentAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout!!, viewPager2!!) { tab, position ->
            when (position) {
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"
            }
        }.attach()
    }
}