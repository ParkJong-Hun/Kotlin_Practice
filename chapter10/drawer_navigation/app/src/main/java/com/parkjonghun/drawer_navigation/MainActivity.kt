package com.parkjonghun.drawer_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.parkjonghun.drawer_navigation.databinding.ActivityMainBinding

//NavigationItemSelectedListenerを使うために継承
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)//Toolbar生成
        setSupportActionBar(toolbar)//この画面で上のToolbarを適用

        supportActionBar?.setDisplayHomeAsUpEnabled(true)//ホームボタン活性化
        supportActionBar?.setHomeAsUpIndicator(R.drawable.navi_menu)//ホームボタンイメージをnavi_menuにする
        supportActionBar?.setDisplayShowTitleEnabled(false)//TitleがToolbarに見えないように

        //DrawerをBinding
        drawerLayout = binding.drawerLayout

        //NavigationViewをBinding
        navigationView = binding.navView
        //Navigation DrawerのアイテムクリックリスナーをこのClassに書くって意味
        navigationView.setNavigationItemSelectedListener(this)
    }

    //ホームボタンクリックしたら
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> {
                //DrawerLayoutを開ける
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //NavigationItemをクリックしたら
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_item1 -> Toast.makeText(this, "アイテム１実行", Toast.LENGTH_SHORT).show()
            R.id.menu_item2 -> Toast.makeText(this, "アイテム2実行", Toast.LENGTH_SHORT).show()
            R.id.menu_item3 -> Toast.makeText(this, "アイテム3実行", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}