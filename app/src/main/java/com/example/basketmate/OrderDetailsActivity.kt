package com.example.basketmate

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class OrderDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.orderdetails_activity)

        val inflater = layoutInflater
        val view = inflater.inflate(R.layout.home_activity, null)

        val navigationView: NavigationView = view.findViewById(R.id.main_navigationView)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.main_bnv)

        val backButton: ImageButton = findViewById(R.id.back_btn)

        // bottom navigation 버튼 클릭시 drawer layout이 열고 닫히도록
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.bottom_navigation_notice -> {
                    item.isChecked = true
                    // 공지사항 메뉴 클릭 시 공지사항 페이지로 이동 & 이미지 on으로 변경
                    true
                }
                R.id.bottom_navigation_home -> {
                    item.isChecked = true
                    // 홈 메뉴 클릭 시 홈 페이지로 이동 & 이미지 on으로 변경
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bottom_navigation_user -> {
                    item.isChecked = true
                    // 사용자 메뉴 클릭 시 Drawer 열기
                    drawerLayout.openDrawer(GravityCompat.END)
                    true
                }
                else -> false
            }
        }

        // drawerlayout의 각 메뉴 아이템 클릭시 해당 페이지 연결
        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.order_details -> {
                    // orderdetails_activity로 이동
                    val intent = Intent(this, OrderDetailsActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers() // 드로어 닫기
                    true
                }
                R.id.delivery_address_management -> {
                    // delivery_activity로 이동
                    val intent = Intent(this, DeliveryActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.recipe_management -> {
                    // 현재 페이지이므로 이동 처리 x
                    drawerLayout.closeDrawers()
                    true
                }
                // 다른 메뉴 아이템에 대한 처리 추가 가능
                else -> false
            }

        }

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.menuRV)

        // 목데이터
        val items = mutableListOf<String>()
        items.add("완숙 토마토 1팩")
        items.add("국내산 가지 2개입")
        items.add("국내산 당근 1개입")
        items.add("햇감자 1kg")
        items.add("애호박 3개입")
        val rvAdapter = MenuRVAdapter(items)

        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        rvAdapter.notifyDataSetChanged()

        // 뒤로가기 (이전 액티비티로 이동)
        backButton.setOnClickListener {
            onBackPressed() // 이전 액티비티로 돌아가기
        }

    }
}