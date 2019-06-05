package com.example.invitation.Utils.font_utils

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.example.invitation.Utils.font_utils.CustomFontUtils

class FontTextView: TextView {

    constructor(context: Context): super(context) {


        CustomFontUtils.applyCustomFont(this, context, null)
    }

    constructor(context: Context, attrs: AttributeSet): super(context,attrs){


        CustomFontUtils.applyCustomFont(this, context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int): super(context, attrs, defStyle) {


        CustomFontUtils.applyCustomFont(this, context, attrs)
    }

    /*constructor(context: Context) : super(context){

    }

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs){

    }

    constructor(context: Context,  attrs: AttributeSet , defStyleAttr : Int) : super(context, attrs, defStyleAttr){


    }*/

}