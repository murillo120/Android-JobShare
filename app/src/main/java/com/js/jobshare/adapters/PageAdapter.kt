package com.js.jobshare.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.js.jobshare.fragments.FeedFragment
import com.js.jobshare.fragments.profile_user

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val tabs: Int = 2

    override fun getItem(position: Int): Fragment {

        when (position) {
            1 -> return profile_user()

            else -> return FeedFragment()
        }

    }

    override fun getCount(): Int {


        return tabs
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            1 -> return "Profile"
            else -> return "Feed"
        }
    }

}