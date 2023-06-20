package com.example.myapplication.ui.fragments.pagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PagerFragment : Fragment() {
    private lateinit var binding: FragmentPagerBinding
    private val adapter: PagerAdapter by lazy {
        PagerAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPagerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager2.adapter = adapter
        val list = listOf(
            "Characters",
            "Locations",
            "Episodes"
        )
        TabLayoutMediator(binding.tabLayoutPager, binding.viewPager2) { tab, post ->
            tab.text = list[post]
        }.attach()
    }

}