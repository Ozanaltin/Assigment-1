package com.example.assignment1

import Color
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TEXT_FROM_TV = "TEXT_FROM_TV"
    }

    private var leftColor = Color.CYAN
    private var rightColor = Color.RED
    private var score = 0
    private var correctColor = Color.RED.colorValue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("Select the correct color")
        updateScreen()

        val clickListener = View.OnClickListener { v ->
            val color = (v?.background as ColorDrawable).color
            if (color == correctColor) {
                toast("Correct!")
                score++
            } else {
                toast("Incorect")
                score--
            }
            updateScreen()
        }

        color_right.setOnClickListener(clickListener)
        color_left.setOnClickListener(clickListener)


        count_btn.setOnClickListener {
            startActivityForResult(Intent(this, CountActivity::class.java), 123)
        }

        count_msg_tv.text = savedInstanceState?.getString(TEXT_FROM_TV)

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val text = count_msg_tv.text.toString()
        if (text.isNotEmpty()) {
            outState?.putString(TEXT_FROM_TV, text)
        }
    }

    private fun updateScreen() {

        score_text.text = score.toString()

        leftColor = getRandomColor()
        rightColor = getRandomColor()
        while (rightColor == leftColor) rightColor = getRandomColor()

        color_left.setBackgroundColor(leftColor.colorValue)
        color_right.setBackgroundColor(rightColor.colorValue)

        if ((Math.random() * 2).toInt() == 1) {
            color_name.text = leftColor.colorName
            correctColor = leftColor.colorValue
        } else {
            color_name.text = rightColor.colorName
            correctColor = rightColor.colorValue
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            123 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val returnValue = data?.getStringExtra(DATA_STRING)
                    count_msg_tv.text = returnValue as String
                }
            }
        }
    }

}
