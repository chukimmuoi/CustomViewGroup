package com.developers.chukimmuoi.customviewgroup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_custom_view_group.*

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : CustomViewGroup
 * Created by chukimmuoi on 09/12/2017.
 */
class CustomViewGroupActivity : AppCompatActivity() {

    private val TAG = CustomViewGroupActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view_group)

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ListItemAdapter(this)
    }
}