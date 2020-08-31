package com.bdn.collinsceleb.gadsleaderboard.ui.fragments.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bdn.collinsceleb.gadsleaderboard.databinding.SkillFragmentBinding

class SkillFragment : Fragment() {

    companion object {
        fun newInstance() = SkillFragment()
    }

    private lateinit var viewModel: SkillViewModel
    private lateinit var binding: SkillFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SkillFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SkillViewModel::class.java)
        // TODO: Use the ViewModel
        binding.skillViewModel = viewModel
        binding.lifecycleOwner = this
    }

}