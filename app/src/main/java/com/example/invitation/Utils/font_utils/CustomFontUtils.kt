package com.example.invitation.Utils.font_utils

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import com.example.invitation.R

object CustomFontUtils {

    /**
     * Apply for custom fonts
     */
    fun applyCustomFont(customFontTextView: FontTextView, context: Context, attrs: AttributeSet?) {
        val attributeArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.FontTextView
        )

        var fontName = attributeArray.getString(R.styleable.FontTextView_fontName)
        if (TextUtils.isEmpty(fontName)) fontName = context.resources.getString(R.string.fa_regular)

        val customFont = selectTypeface(context, fontName)
        customFontTextView.typeface = customFont

        attributeArray.recycle()
    }


    /**
     * Select font typeface
     */
    private fun selectTypeface(context: Context, fontName: String): Typeface? {

        when (fontName) {
            context.resources.getString(R.string.fa_regular) -> {
                return FontCache.getTypeface(context.resources.getString(R.string.fa_regular), context)
            }
            context.resources.getString(R.string.fa_light) -> {
                return FontCache.getTypeface(context.resources.getString(R.string.fa_light), context)
            }
            context.resources.getString(R.string.fa_solid) -> {
                return FontCache.getTypeface(context.resources.getString(R.string.fa_solid), context)
            }
            context.resources.getString(R.string.fa_brand_regular) -> {
                return FontCache.getTypeface(context.resources.getString(R.string.fa_brand_regular), context)
            }
            else -> {
                return FontCache.getTypeface(context.resources.getString(R.string.fa_regular), context)
            }

        }
    }
}
