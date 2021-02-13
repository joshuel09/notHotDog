package com.michelle.josueru.nothogbeta

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.ArrayList


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList = ArrayList<Fragment>()
    private val FragmentListTitles = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return FragmentListTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return FragmentListTitles[position]
    }

    fun AddFragment(fragment: Fragment, Title: String) {
        fragmentList.add(fragment)
        FragmentListTitles.add(Title)
    }
}