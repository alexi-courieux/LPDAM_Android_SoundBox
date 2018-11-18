package fr.iutnice.courieux.soundbox.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import fr.iutnice.courieux.soundbox.R
import fr.iutnice.courieux.soundbox.R.color.colorCircle

class CustomView : View {
    constructor(context:Context):super(context)
    constructor(context:Context?,attrs: AttributeSet?):super(context,attrs){
        init()
    }

    private var mPaint = Paint()

    private fun init(){
        mPaint.color = ContextCompat.getColor(context, R.color.colorCircle)
    }

    override fun onDraw(canvas: Canvas?){
        super.onDraw(canvas)
        val width = getWidth()
        val height= getHeight()
        canvas?.drawCircle((width/2).toFloat(),(height/2).toFloat(),250F, mPaint)
    }
}