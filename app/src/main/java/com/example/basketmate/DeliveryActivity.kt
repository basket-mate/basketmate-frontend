package com.example.basketmate

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class DeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.delivery_activity)

        val navigationView: NavigationView = findViewById(R.id.main_navigationView)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.main_bnv)

        val backButton: ImageButton = findViewById(R.id.back_btn)

        //bottom navigation 버튼 클릭시 drawer layout이 열고 닫히도록
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.bottom_navigation_notice -> {
                    // 공지사항 메뉴 클릭 시 공지사항 페이지로 이동 & 이미지 on으로 변경
                    true
                }
                R.id.bottom_navigation_home -> {
                    // 홈 메뉴 클릭 시 홈 페이지로 이동 & 이미지 on으로 변경
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bottom_navigation_user -> {
                    // 사용자 메뉴 클릭 시 Drawer 열기
                    drawerLayout.openDrawer(GravityCompat.END)
                    true
                }
                else -> false
            }
        }

        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.order_details -> {
                    item.isChecked = true
                    // orderdetails_activity로 이동
                    val intent = Intent(this, OrderDetailsActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers() // 드로어 닫기
                    true
                }
                R.id.delivery_address_management -> {
                    item.isChecked = true
                    // 현재 페이지이므로 이동 처리 x
                    drawerLayout.closeDrawers() // 드로어 닫기
                    true
                }
                R.id.recipe_management -> {
                    item.isChecked = true
                    // recipe_activity로 이동
                    val intent = Intent(this, RecipeActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers() // 드로어 닫기
                    true
                }
                // 다른 메뉴 아이템에 대한 처리 추가 가능
                else -> false
            }

        }
        // 뒤로가기 (이전 액티비티로 이동)
        backButton.setOnClickListener {
            onBackPressed() // 이전 액티비티로 돌아가기
        }
    }
}