package com.developers.chukimmuoi.customviewgroup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnDrawn -> { Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show(); }
            else -> {  }
        }
    }
}
