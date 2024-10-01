package com.example.basketmate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation as CompletedContinuation1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.mainlogin_activity)

        // 카카오톡으로 로그인
//        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
//            if (error != null) {
//                Log.e(TAG, "로그인 실패", error)
//            }
//            else if (token != null) {
//                Log.i(TAG, "로그인 성공 ${token.accessToken}")
//            }
//        }
        //로그인 버튼 클릭시 페이지 이동
        val kakao_button = findViewById<ImageButton>(R.id.kakaoButton)
        kakao_button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }


    }
}