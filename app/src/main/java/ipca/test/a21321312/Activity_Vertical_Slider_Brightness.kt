package ipca.test.a21321312

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doOnTextChanged
import ipca.test.a21321312.views.VerticalSlider

class Activity_Vertical_Slider_Brightness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_slider_brightness)

        val verticalSlider = findViewById<VerticalSlider>(R.id.verticalSliderBlue)
        val imageView = findViewById<ImageView>(R.id.imageView)

        verticalSlider.setOnValueChangeListener {value ->
            findViewById<TextView>(R.id.sliderValue).text = "${value.toInt()} %"

            imageView.setColorFilter(
                Color.argb(
                    value.toInt(),
                    value.toInt(),
                    value.toInt(),
                    value.toInt()
                ),
                PorterDuff.Mode.SRC_ATOP
            )
        }

        findViewById<EditText>(R.id.editText).doOnTextChanged { text, start, before, count ->
            if (text?.isNotEmpty() == true) {
                if (text?.isDigitsOnly() == true) {
                    val number = text.toString().toInt()
                    findViewById<TextView>(R.id.sliderValue).text = "${number} %"
                    if (number >= 0 && number <= 100) {
                        verticalSlider.percent = number.toFloat()
                    }
                }
            }
        }

    }
}