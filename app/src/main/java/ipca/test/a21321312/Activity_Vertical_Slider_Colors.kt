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

class Activity_Vertical_Slider_Colors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_slider_colors)

        val verticalSliderRed = findViewById<VerticalSlider>(R.id.verticalSliderRed)
        val verticalSliderBlue = findViewById<VerticalSlider>(R.id.verticalSliderBlue)
        val verticalSliderGreen = findViewById<VerticalSlider>(R.id.verticalSliderGreen)

        var redLevel : Int = 100
        var blueLevel : Int = 100
        var greenLevel : Int = 100

        var transparency : Int = (redLevel + blueLevel + greenLevel) / 3

        val imageView = findViewById<ImageView>(R.id.imageView)

        verticalSliderRed.setOnValueChangeListener {value ->
            redLevel = value.toInt()
            transparency = (redLevel + blueLevel + greenLevel) / 3

            imageView.setColorFilter(
                Color.argb(
                    transparency,
                    redLevel,
                    greenLevel,
                    blueLevel
                ),
                PorterDuff.Mode.SRC_ATOP
            )
        }

        verticalSliderBlue.setOnValueChangeListener {value ->
            blueLevel = value.toInt()
            transparency = (redLevel + blueLevel + greenLevel) / 3

            imageView.setColorFilter(
                Color.argb(
                    100,
                    redLevel,
                    greenLevel,
                    blueLevel
                ),
                PorterDuff.Mode.SRC_ATOP
            )
        }

        verticalSliderGreen.setOnValueChangeListener {value ->
            greenLevel = value.toInt()
            transparency = (redLevel + blueLevel + greenLevel) / 3

            imageView.setColorFilter(
                Color.argb(
                    100,
                    redLevel,
                    greenLevel,
                    blueLevel
                ),
                PorterDuff.Mode.SRC_ATOP
            )
        }

    }
}