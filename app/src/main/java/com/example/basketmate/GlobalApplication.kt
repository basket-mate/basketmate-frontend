package com.example.basketmate

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.v2.auth.BuildConfig

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "f1915e9e679bb30e7ac1065c907e0886")
    }
}