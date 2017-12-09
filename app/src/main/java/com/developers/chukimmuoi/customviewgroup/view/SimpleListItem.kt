package com.developers.chukimmuoi.customviewgroup.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_simple.view.*

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : CustomViewGroup
 * Created by chukimmuoi on 09/12/2017.
 */
class SimpleListItem : ViewGroup {

    private val TAG = SimpleListItem::class.java.simpleName

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    // TODO: 4 phuong phap de co duoc MarginLayoutParams hoac LayoutParams tuy chinh su dung trong custom ViewGroup.
    // TODO: Nếu bạn muốn sử dụng MarginLayoutParams trong các nhóm chế độ xem tuỳ chỉnh của mình hoặc nếu bạn muốn tạo các bảng bố cục mát mẻ của riêng mình, bạn cần thực hiện bốn phương pháp này.
    /**
     * Xác nhận nếu một tập hợp các tham số bố trí hợp lệ cho một con của ViewGroup này.
     *
     * [checkLayoutParams] một phương pháp xác nhận, nó sẽ kiểm tra xem một khoảng cách ViewGroup.LayoutParams cụ thể
     * có hợp lệ để sử dụng với ViewGroup đó hay không.
     *
     * Nếu tôi bị mắc kẹt một cách bố trí tương đối, params bố trí cụ thể, trong một bố cục tuyến tính,
     * [checkLayoutParams] sẽ nói, "đó không phải là những gì chúng tôi sử dụng xung quanh ở đây."
     * */
    override fun checkLayoutParams(p: LayoutParams?): Boolean {
        return p is ViewGroup.MarginLayoutParams
    }

    /**
     * Được gọi là khi ViewGroup nhận được chế độ xem không có tham số bố trí trên nó,
     * nó có thể có một số tham số bố trí mặc định.
     *
     * @return Một tập hợp các tham số bố trí mặc định khi đưa ra một con không có tham số bố trí.
     * */
    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }

    /**
     * Một params bố trí tạo ra mà phải mất một tập thuộc tính.
     *
     * AttributeSet là bạn của chúng ta từ lạm phát XML,
     * và nó đang tạo ra một tập hợp params bố trí dựa trên các thuộc tính được chỉ rõ trong XML.
     *
     * @return Một tập hợp các tham số bố trí được tạo ra từ các thuộc tính được thông qua trong XML.
     * */
    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    /**
     * Được gọi khi [checkLayoutParams] không thành công.
     *
     * Điều này được sử dụng khi một chế độ xem được thông số bố trí không tốt
     * (ví dụ: vượt qua một số tham số bố trí tương đối thành bố cục tuyến tính).
     *
     * Phương pháp này sẽ cho bạn cơ hội sử dụng thông số bố cục đó
     * (ví dụ: tham số đối tượng tham chiếu không hợp lệ) và kéo ra nội dung bạn có thể sử dụng.
     *
     * Bạn có thể kéo chiều rộng chiều cao và bất kỳ thuộc tính nào khác mà bạn có thể sử dụng
     * trong đối tượng thông số bố cục cụ thể của bạn và tạo một phiên bản mới hợp lệ
     * sử dụng một số thuộc tính đó khỏi thuộc tính xấu.
     *
     * @return Một tập hợp các tham số bố trí hợp lệ cho ViewGroup này sao cho phù hợp / hợp lệ
     * thuộc tính từ các thông số được cung cấp, không quá tốt.
     * */
    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return generateDefaultLayoutParams()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

//        measureChild()
//        measureChildren()
//        measureChildWithMargins()
//        getChildMeasureSpec()

        // Do icon.
        measureChildWithMargins(
                icon,
                widthMeasureSpec, 0,
                heightMeasureSpec, 0
        )

        // Xác định chiều rộng của biểu tượng được sử dụng bao nhiêu.
        var lp: MarginLayoutParams = icon.layoutParams as MarginLayoutParams
        val widthUsed = icon.measuredWidth + lp.leftMargin + lp.rightMargin

        val heightUsed = 0

        // Do title.
        measureChildWithMargins(
                title,
                widthMeasureSpec, widthUsed,
                heightMeasureSpec, heightUsed
        )

        // Do subtitle
        measureChildWithMargins(
                subtitle,
                widthMeasureSpec, widthUsed,
                heightMeasureSpec, title.measuredHeight
        )

        // Tính chiều rộng và chiều rộng đo được của chế độ xem này.

        // Tìm ra bao nhiêu không gian mà biểu tượng được sử dụng.
        val iconWidth  = icon.measuredWidth + lp.leftMargin + lp.rightMargin
        val iconHeight = icon.measuredHeight + lp.topMargin + lp.bottomMargin
        lp = title.layoutParams as MarginLayoutParams

        // Xác định tổng số không gian tiêu đề được sử dụng.
        val titleWidth = title.measuredWidth + lp.leftMargin + lp.rightMargin
        val titleHeight = title.measuredHeight + lp.topMargin + lp.bottomMargin
        lp = subtitle.layoutParams as MarginLayoutParams

        // Xác định bao nhiêu tổng số không gian phụ đề được sử dụng.
        val subtitleWidth = subtitle.measuredWidth + lp.leftMargin + lp.rightMargin
        val subtitleHeigth = subtitle.measuredHeight + lp.topMargin + lp.bottomMargin

        val width = paddingLeft + iconWidth + Math.max(titleWidth, subtitleWidth) + paddingRight
        val height = paddingTop + Math.max(iconHeight, titleHeight + subtitleHeigth) + paddingBottom

        setMeasuredDimension(
                View.resolveSize(width, widthMeasureSpec),
                View.resolveSize(height, heightMeasureSpec)
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        // Icon.
        var layoutParams = icon.layoutParams as MarginLayoutParams

        var x = paddingLeft + layoutParams.leftMargin
        var y = paddingTop + layoutParams.topMargin

        icon.layout(x, y, x + icon.measuredWidth, y + icon.measuredHeight)

        // Title.
        x += icon.measuredWidth + layoutParams.rightMargin

        layoutParams = title.layoutParams as MarginLayoutParams

        x += layoutParams.leftMargin

        y = paddingTop + layoutParams.topMargin

        title.layout(x, y, x + title.measuredWidth, y + title.measuredHeight)

        // Subtitle.
        y += title.measuredHeight + layoutParams.bottomMargin
        layoutParams = subtitle.layoutParams as MarginLayoutParams

        y += layoutParams.topMargin

        subtitle.layout(x, y, x + subtitle.measuredWidth, y + subtitle.measuredHeight)
    }
}