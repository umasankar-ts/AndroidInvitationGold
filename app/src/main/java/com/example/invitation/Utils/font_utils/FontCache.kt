package com.example.invitation.Utils.font_utils

import android.content.Context
import android.graphics.Typeface
import java.util.HashMap

object FontCache {

    private val fontCache = HashMap<String, Typeface>()

    /**
     * Return typeface font
     */
    fun getTypeface(fontname: String, context: Context): Typeface? {
        var typeface: Typeface? = fontCache[fontname]

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, fontname)
            } catch (e: Exception) {
                return null
            }

            fontCache[fontname] = typeface
        }

        return typeface
    }
}