package com.dicoding.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // private var btnSetValue: Button? = null   <- agar error NPE
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView

    // OutOfBonds
    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tv_text)
        btnSetValue = findViewById(R.id.BtnSetValue)
        btnSetValue.setOnClickListener(this)
        // btnSetValue!!.setOnClickListener(this)   <- agar error NPE
        names.add("Nur M. Akbar")
        names.add("Mar")
        names.add("goro")
    }

    /*
    ERROR
    JAVA NULL POINTER EXCEPTION
    JAVA OUT OF MEMORY EXCEPTION
    JAVA INDEX OUT OF BOUND
     */

    override fun onClick(v: View) {
        /*  CONTOH NULL POINTER EXCEPTION
        if (v.id == R.id.BtnSetValue) {
            tvText.text = "19"
        }
         */
        if (v.id == R.id.BtnSetValue) {
            Log.d("MainActivity", names.toString())
            val name = StringBuilder()
            // for (i in 0..3)  <- Out Of Bonds karena lewat array yang cuma sampai index 2
            for (i in 0..2) {    // <- Out Of Bonds Fixed
                name.append(names[i]).append("\n")
            }
            tvText.text = name.toString()
        }
    }
}