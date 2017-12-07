package com.developers.chukimmuoi.customviewgroup.view

import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.developers.chukimmuoi.customviewgroup.R
import java.util.*

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : CustomViewGroup
 * Created by chukimmuoi on 07/12/2017.
 */
class AttributedTallyCounter : View, TallyCounter {

    private val TAG = AttributedTallyCounter::class.java.simpleName

    private val MAX_COUNT = 9999
    private val MAX_COUNT_STRING = MAX_COUNT.toString()

    private var mCount: Int = 0
    private lateinit var mDisplayCount: String

    private val mBackgroundPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mLinePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mNumberPaint: TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)

    private val mBackgroundRect: RectF = RectF()

    private var mCornerRadius: Float = 0F

    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.TallyCounter)

        val backgroundColor = typeArray.getColor(R.styleable.TallyCounter_backgroundColor,
                ContextCompat.getColor(context, R.color.colorPrimary))
        mBackgroundPaint.color = backgroundColor

        val baselineColor = typeArray.getColor(R.styleable.TallyCounter_baselineColor,
                ContextCompat.getColor(context, R.color.colorAccent))
        val baselineWidth =
                typeArray.getDimensionPixelSize(R.styleable.TallyCounter_baselineWidth, 1)
        mLinePaint.color = baselineColor
        mLinePaint.strokeWidth = baselineWidth.toFloat()

        val textColor = typeArray.getColor(R.styleable.TallyCounter_android_textColor, Color.WHITE)
        val textSize = typeArray.getDimensionPixelSize(R.styleable.TallyCounter_android_textSize,
                Math.round(64F * resources.displayMetrics.scaledDensity)).toFloat() // scaleDensity: Dung cho font chu
        mNumberPaint.color = textColor
        mNumberPaint.textSize = Math.round(textSize).toFloat()
        mNumberPaint.typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL)

        val cornerRadius = typeArray.getDimensionPixelSize(R.styleable.TallyCounter_cornerRadius,
                Math.round(2F * resources.displayMetrics.density)).toFloat() // density: Dung cho size
        mCornerRadius = cornerRadius

        typeArray.recycle()

        setCount(0)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun reset() {
        setCount(0)
    }

    override fun increment() {
        setCount(mCount + 1)
    }

    override fun getCount(): Int {
        return mCount
    }

    override fun setCount(count: Int) {
        mCount = Math.min(count, MAX_COUNT)
        mDisplayCount = String.format(Locale.getDefault(), "%04d", mCount)

        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val fontMetrics = mNumberPaint.fontMetrics

        val maxTextWidth = mNumberPaint.measureText(MAX_COUNT_STRING)
        val maxTextHeight = fontMetrics.bottom - fontMetrics.top

        val desiredWidth = Math.round(maxTextWidth + paddingLeft + paddingRight)
        val desiredHeight = Math.round(maxTextHeight * 2F + paddingTop + paddingBottom)

        val measuredWidth = resolveSize(desiredWidth, widthMeasureSpec)
        val measuredHeight = resolveSize(desiredHeight, heightMeasureSpec)

        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val canvasWidth = canvas.width.toFloat()
        val canvasHeight = canvas.height.toFloat()

        val centerX = canvasWidth * 0.5F

        mBackgroundRect.set(0F, 0F, canvasWidth, canvasHeight)
        canvas.drawRoundRect(mBackgroundRect, mCornerRadius, mCornerRadius, mBackgroundPaint)

        val baselineY = Math.round(canvasHeight * 0.6F).toFloat()
        canvas.drawLine(0F, baselineY, canvasWidth, baselineY, mLinePaint)

        val textWidth = mNumberPaint.measureText(mDisplayCount)
        val textX = Math.round(centerX - textWidth * 0.5F).toFloat()
        canvas.drawText(mDisplayCount, textX, baselineY, mNumberPaint)
    }
}