package com.example.plant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var loginuser : HashMap<String, String>
    }

    fun lihatFragment(id: Int) {
        if (id == 0) {
//            val bundle = Bundle()
//            bundle.putParcelableArrayList("arrMataKuliah", arrMataKuliah)
            var frtambah = fLogin()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myframe, frtambah)
            ft.commit()
        }
        else if (id == 1) {
            var frtambah = fRegister()
//            frtambah.setArguments(bundle)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myframe, frtambah)
            ft.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

//        var bottom_view = findViewById<BottomNavigationView>(R.id.botnav)
//        bottom_view.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            if (item.itemId == R.id.navlogin) {
//                lihatFragment(0)
//            }
//            else if (item.itemId == R.id.navregister) {
//                lihatFragment(1)
//            }
//            true
//        })
    }


}