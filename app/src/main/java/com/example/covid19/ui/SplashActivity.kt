package com.example.covid19.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    /**
     * Setting delay time for splash screen before navigating to next screen.
     */
    private val splashTimeOut: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        /**
         * Using coroutines for delaying splash screen without blocking main thread.
         * If you will use more logic inside Splash please create ViewModel and flow MVVM pattern.
         */
        activityScope.launch {
            delay(splashTimeOut)
            startActivity(Intent(this@SplashActivity, CountryListActivity::class.java))
            finish()
        }
    }

}