package com.developers.chukimmuoi.customviewgroup.data

import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import com.developers.chukimmuoi.customviewgroup.R

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : CustomViewGroup
 * Created by chukimmuoi on 09/12/2017.
 */
enum class ListItem constructor(
        @param:IdRes val resId: Int,
        @param:DrawableRes val iconResId: Int,
        @param:StringRes val stringResId: Int,
        @param:StringRes val descResId: Int) {

    ITEM_01(R.id.list_item_01, R.drawable.ic_bubble_chart_white_48dp, R.string.list_item_01, R.string.list_item_01_desc),
    ITEM_02(R.id.list_item_02, R.drawable.ic_ac_unit_white_48dp, R.string.list_item_02, R.string.list_item_02_desc),
    ITEM_03(R.id.list_item_03, R.drawable.ic_spa_white_48dp, R.string.list_item_03, R.string.list_item_03_desc),
    ITEM_04(R.id.list_item_04, R.drawable.ic_whatshot_white_48dp, R.string.list_item_04, R.string.list_item_04_desc);

    companion object {
        private val LIST_ITEMS_ALL = arrayOf(ITEM_01, ITEM_02, ITEM_03, ITEM_04)

        val itemCount: Int
            get() = LIST_ITEMS_ALL.size

        fun getItem(position: Int): ListItem {
            return if (position >= 0 || position < itemCount) LIST_ITEMS_ALL[position] else ITEM_01
        }
    }
}


//enum class ListItem
//
//private constructor(
//        @param:IdRes val resId: Int,
//        @param:DrawableRes val iconResId: Int,
//        @param:StringRes val stringResId: Int,
//        @param:StringRes val descResId: Int) {
//    ITEM_01(R.id.list_item_01, R.drawable.ic_bubble_chart_white_48dp, R.string.list_item_01, R.string.list_item_01_desc),
//    ITEM_02(R.id.list_item_02, R.drawable.ic_ac_unit_white_48dp, R.string.list_item_02, R.string.list_item_02_desc),
//    ITEM_03(R.id.list_item_03, R.drawable.ic_spa_white_48dp, R.string.list_item_03, R.string.list_item_03_desc),
//    ITEM_04(R.id.list_item_04, R.drawable.ic_whatshot_white_48dp, R.string.list_item_04, R.string.list_item_04_desc);
//
//
//    companion object {
//
//        private val LIST_ITEMS_ALL = arrayOf(ITEM_01, ITEM_02, ITEM_03, ITEM_04)
//
//        val itemCount: Int
//            get() = LIST_ITEMS_ALL.size
//
//        fun getItem(position: Int): ListItem {
//            return if (position >= 0 || position < LIST_ITEMS_ALL.size) LIST_ITEMS_ALL[position]
//            else ITEM_01
//        }
//    }
//}
