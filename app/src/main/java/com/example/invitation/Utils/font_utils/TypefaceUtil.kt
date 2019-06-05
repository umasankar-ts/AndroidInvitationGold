package com.example.invitation.Utils.font_utils

import android.content.Context
import android.graphics.Typeface
import android.util.Log

import android.os.Build



object TypefaceUtil {

    /**
     * Using reflection to override default typeface
     * NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN
     * @param context to work with assets
     * @param defaultFontNameToOverride for example "monospace"
     * @param customFontFileNameInAssets file name of the font from assets
     */
    fun overrideFont(context: Context, defaultFontNameToOverride: String, customFontFileNameInAssets: String) {
        /*try {
            val customFontTypeface = Typeface.createFromAsset(context.assets, customFontFileNameInAssets)

            val defaultFontTypefaceField = Typeface::class.java.getDeclaredField(defaultFontNameToOverride)
            defaultFontTypefaceField.isAccessible = true
            defaultFontTypefaceField.set(null, customFontTypeface)
        } catch (e: Exception) {
            Log.e("Can not set custom font $customFontFileNameInAssets instead of $defaultFontNameToOverride")
        }*/


        val customFontTypeface = Typeface.createFromAsset(context.assets, customFontFileNameInAssets)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val newMap = HashMap<String, Typeface>()
            newMap["serif"] = customFontTypeface
            try {
                val staticField = Typeface::class.java
                    .getDeclaredField("sSystemFontMap")
                staticField.isAccessible = true
                staticField.set(null, newMap)
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        } else {
            try {
                val defaultFontTypefaceField = Typeface::class.java.getDeclaredField(defaultFontNameToOverride)
                defaultFontTypefaceField.isAccessible = true
                defaultFontTypefaceField.set(null, customFontTypeface)
            } catch (e: Exception) {
                Log.e(
                    TypefaceUtil::class.java.simpleName,
                    "Can not set custom font $customFontFileNameInAssets instead of $defaultFontNameToOverride"
                )
            }

        }

    }
}