package com.developers.chukimmuoi.customviewgroup.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import java.util.*

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : CustomViewGroup
 * Created by chukimmuoi on 05/12/2017.
 */
class TallyCounterView : View, TallyCounter {

    private val MAX_COUNT = 9999

    private var mCount: Int = 0
    private lateinit var mDisplayedCount: String

    private var mBackgroundPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mLinePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mNumberPaint: TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)

    private var mBackgroundRect: RectF = RectF()

    private var mCornerRadius: Float = 0.0F

    private var mPointPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        mBackgroundPaint.color = Color.RED

        mLinePaint.color = Color.YELLOW

        mNumberPaint.color = Color.WHITE
        mNumberPaint.textSize = Math.round(64F * resources.displayMetrics.scaledDensity).toFloat()

        mPointPaint.color = Color.GREEN
        mPointPaint.strokeWidth = 10F

        mCornerRadius = Math.round(2F * resources.displayMetrics.density).toFloat()

        setCount(0)
    }
    override fun reset() {
        setCount(0)
    }

    override fun increment() {
        setCount(mCount++)
    }

    override fun getCount(): Int {
        return mCount
    }

    override fun setCount(count: Int) {
        mCount = Math.min(count, MAX_COUNT)
        mDisplayedCount = String.format(Locale.getDefault(), "%04d", count)

        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val canvasWidth = canvas.width.toFloat()
        val canvasHeight = canvas.height.toFloat()


        val centerX = canvasWidth * 0.5F

        mBackgroundRect.set(0F, 0F, canvasWidth, canvasHeight)
        canvas.drawRoundRect(mBackgroundRect, mCornerRadius, mCornerRadius, mBackgroundPaint)

        // Ve 1 duong thang can biet toa do 2 diem:
        // diem bat dau (0F, baselineY),
        // diem ket thuc (canvasWidth, baselineY)
        val baselineY = Math.round(canvasHeight * 0.6F).toFloat() // Lam tron
        canvas.drawLine(0F, baselineY, canvasWidth, baselineY, mLinePaint)

        // Ve text voi toa do x la textX, y la baselineY (toa do goc duoi ben trai cua text)
        val textWidth = mNumberPaint.measureText(mDisplayedCount) // lay chieu rong cua text
        val textX = Math.round(centerX - textWidth * 0.5F).toFloat() // Lam tron
        canvas.drawText(mDisplayedCount, textX, baselineY, mNumberPaint)

        canvas.drawPoint(textX, baselineY, mPointPaint)
    }
}