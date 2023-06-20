package com.example.myapplication.ui.fragments.pagerFragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ui.fragments.characterFragment.CharacterFragment
import com.example.myapplication.ui.fragments.episodeFragment.EpisodeFragment
import com.example.myapplication.ui.fragments.locationFragment.LocationFragment

/**
 * Author: Dzhaparov Bekmamat
 */
class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CharacterFragment()
            1 -> LocationFragment()
            2 -> EpisodeFragment()
            else -> CharacterFragment()
        }
    }
}