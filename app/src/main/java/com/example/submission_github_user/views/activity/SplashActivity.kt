package com.example.submission_github_user.views.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.submission_github_user.databinding.ActivitySplashBinding
import com.example.submission_github_user.views.ui.main.TabbedActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 500

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, TabbedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

        supportActionBar?.hide()

        val res = this.resources.getDrawable(this.resources.getIdentifier("ic_github_logo", "drawable", this.packageName))
        binding.logo.setImageDrawable(res)
    }

    override fun onDestroy() {
        super.onDestroy()

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
    }

}
