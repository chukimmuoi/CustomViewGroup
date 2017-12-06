package com.developers.chukimmuoi.customviewgroup.view

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : CustomViewGroup
 * Created by chukimmuoi on 05/12/2017.
 */
interface TallyCounter {

    fun reset()

    fun increment()

    fun getCount() : Int

    fun setCount(count: Int)
}