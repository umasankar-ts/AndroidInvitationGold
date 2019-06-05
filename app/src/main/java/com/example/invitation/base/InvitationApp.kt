package com.example.invitation.base

import android.app.Application
import com.example.invitation.Utils.font_utils.TypefaceUtil

class InvitationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Ubuntu-R.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
    }
}