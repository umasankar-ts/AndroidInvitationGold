package com.example.invitation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Launcher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        runTimer();
    }

    private fun runTimer() {
        Handler().postDelayed(Runnable { moveToNextScreen(); },2000)
    }

    private fun moveToNextScreen() {
        startActivity(Intent(this,MainActivity::class.java))
        this.finish()
    }
}
