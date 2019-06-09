package com.example.invitation.view_utills

import android.graphics.Shader

import android.content.Context
import android.support.v4.content.ContextCompat
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.graphics.LinearGradient
import android.util.AttributeSet
import android.widget.TextView
import com.example.invitation.R


class GradientTextView : TextView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        //Setting the gradient if layout is changed
        if (changed) {
            paint.shader = LinearGradient(
                0f, 0f, width.toFloat(), height.toFloat(),
                ContextCompat.getColor(context, R.color.timer_textview_start_gradient_color),
                ContextCompat.getColor(context, R.color.timer_textview_end_gradient_color),
                Shader.TileMode.CLAMP
            )
        }
    }
}