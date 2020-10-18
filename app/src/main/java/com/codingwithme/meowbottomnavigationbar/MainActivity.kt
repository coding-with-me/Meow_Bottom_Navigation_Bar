package com.codingwithme.meowbottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0,R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_explore))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_chat))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_notification))
        bottomNavigation.add(MeowBottomNavigation.Model(4,R.drawable.ic_user))

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment.newInstance())
                }
                1 -> {
                    replaceFragment(ExploreFragment.newInstance())
                }
                2 -> {
                    replaceFragment(ChatFragment.newInstance())
                }
                3 -> {
                    replaceFragment(NotificationFragment.newInstance())
                }
                4 -> {
                    replaceFragment(UserFragment.newInstance())
                }
                else -> {
                    replaceFragment(HomeFragment.newInstance())
                }
            }
        }
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}