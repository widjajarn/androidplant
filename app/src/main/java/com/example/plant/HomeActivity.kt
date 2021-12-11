package com.example.plant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    fun lihatFragment(id: Int) {
        if (id == 0) {
//            val bundle = Bundle()
//            bundle.putParcelableArrayList("arrMataKuliah", arrMataKuliah)
            println("cek pilih fragment 0")
            var frtambah = fHome()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myframe, frtambah)
            ft.commit()
        }
        else if (id == 1) {
            var frtambah = fSchedule()
//            frtambah.setArguments(bundle)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myframe, frtambah)
            ft.commit()
        }
        else if (id == 2) {
            var frtambah = fDiscovery()
//            frtambah.setArguments(bundle)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myframe, frtambah)
            ft.commit()
        }
        else if (id == 3) {
            var frtambah = fProfile()
//            frtambah.setArguments(bundle)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myframe, frtambah)
            ft.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lihatFragment(0)
//        var frLogin = fLogin()
//        val ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.myframe, frLogin)
//        ft.commit()

//        val mFragmentManager = supportFragmentManager
//        val mfHome = fHome()
//
//        mFragmentManager.findFragmentByTag(fHome::class.java.simpleName)
//        mFragmentManager
//            .beginTransaction()
//            .add(R.id.myframe, mfHome, fHome::class.java.simpleName)
//            .commit()

        var bottom_view = findViewById<BottomNavigationView>(R.id.botnav)
        bottom_view.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            if (item.itemId == R.id.navhome) {
                lihatFragment(0)
            }
            else if (item.itemId == R.id.navschedule) {
                lihatFragment(1)
            }
            else if (item.itemId == R.id.navdiscovery) {
                lihatFragment(2)
            }
            else if (item.itemId == R.id.navprofile) {
                lihatFragment(3)
            }
            true
        })
    }


}