package com.example.invitation.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.invitation.R

class EndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        startAppCloseTimer();
    }

    private fun startAppCloseTimer() {

        val timer = object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                terminateApplication()
            }
        }
        timer.start()
    }

    private fun terminateApplication() {
        super.onBackPressed();
    }

    override fun onBackPressed() {

    }
}
