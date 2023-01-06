package ipca.test.a21321312

import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doOnTextChanged
import ipca.test.a21321312.views.VerticalSlider

class Activity_Vertical_Slider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_slider)

        val verticalSliderLeft = findViewById<VerticalSlider>(R.id.verticalSliderBlue)
        val verticalSliderRight = findViewById<VerticalSlider>(R.id.verticalSlider2)
        val locker = findViewById<Switch>(R.id.locker)

        locker.setOnCheckedChangeListener { compoundButton, b ->
            if (locker.isChecked) {
                verticalSliderLeft.percent = verticalSliderRight.percent
                findViewById<TextView>(R.id.sliderValue2).text = "${verticalSliderRight.percent.toInt()} %"
                findViewById<TextView>(R.id.sliderValue).text = "${verticalSliderRight.percent.toInt()} %"
            }
        }

        verticalSliderLeft.setOnValueChangeListener {value ->
            if(!locker.isChecked) findViewById<TextView>(R.id.sliderValue).text = "${value.toInt()} %"
            if (locker.isChecked) {
                verticalSliderLeft.percent = verticalSliderRight.percent
                findViewById<TextView>(R.id.sliderValue).text = "${verticalSliderRight.percent.toInt()} %"
            }
        }

        findViewById<EditText>(R.id.editText).doOnTextChanged { text, start, before, count ->
            if (text?.isNotEmpty() == true  && locker.isChecked == false) {
                if (text?.isDigitsOnly() == true) {
                    val number = text.toString().toInt()
                    if(!locker.isChecked) findViewById<TextView>(R.id.sliderValue).text = "${number} %"
                    if (number >= 0 && number <= 100) {
                        verticalSliderLeft.percent = number.toFloat()
                    }
                }
            }
        }

        verticalSliderRight.setOnValueChangeListener {value ->
            if(!locker.isChecked) findViewById<TextView>(R.id.sliderValue2).text = "${value.toInt()} %"

            if (locker.isChecked) {
                verticalSliderRight.percent = verticalSliderLeft.percent
                findViewById<TextView>(R.id.sliderValue2).text = "${verticalSliderRight.percent.toInt()} %"
            }
        }

        findViewById<EditText>(R.id.editText2).doOnTextChanged { text, start, before, count ->
            if (text?.isNotEmpty() == true && locker.isChecked == false) {
                if (text?.isDigitsOnly() == true) {
                    val number = text.toString().toInt()
                    if(!locker.isChecked) findViewById<TextView>(R.id.sliderValue2).text = "${number} %"
                    if (number >= 0 && number <= 100) {
                        verticalSliderRight.percent = number.toFloat()
                    }
                }
            }
        }

    }
}