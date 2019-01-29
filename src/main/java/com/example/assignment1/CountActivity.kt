package com.example.assignment1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_count.*

class CountActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        say_hello_btn.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(DATA_STRING, "Hello \n${text_count.text}")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        count_btn.setOnClickListener {
            count++
            text_count.text = "$count"
        }


    }

}
