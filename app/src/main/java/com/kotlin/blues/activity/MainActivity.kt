package com.kotlin.blues.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.kotlin.blues.R
import com.kotlin.blues.base.BluesBaseActivity
import com.kotlin.blues.base.BluesBaseFragment
import com.kotlin.blues.maintab.MainTabFragment
import com.kotlin.blues.maintab.MiddleTabFragment
import com.kotlin.blues.maintab.MyTabFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BluesBaseActivity() {

    var bluesFragments = listOf<BluesBaseFragment>(MainTabFragment(), MiddleTabFragment(), MyTabFragment())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        blue_navigation.setOnNavigationItemSelectedListener(mBlueNavigationListener)
        initViewPage()
    }


    fun initViewPage() {
        viewpager.adapter = viewPagerAdapter(supportFragmentManager, bluesFragments)
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                blue_navigation.menu.getItem(position).setChecked(true)

            }
        })
    }


    //继承 FragmentPagerAdapter 创建适配器，利用主构造函数传值
    class viewPagerAdapter(fm: FragmentManager?, var list: List<BluesBaseFragment>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        override fun getCount(): Int {
            return list.size
        }
    }


    private val mBlueNavigationListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                viewpager.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                viewpager.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my -> {
                viewpager.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
