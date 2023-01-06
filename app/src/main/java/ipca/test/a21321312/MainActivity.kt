package ipca.test.a21321312

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonSemaforo).setOnClickListener{
            startActivity(Intent(this@MainActivity, Activity_Semaphore::class.java))
        }

        findViewById<Button>(R.id.buttonSlider).setOnClickListener{
            startActivity(Intent(this@MainActivity, Activity_Vertical_Slider::class.java))
        }

        findViewById<Button>(R.id.buttonSwitchCir).setOnClickListener{
            startActivity(Intent(this@MainActivity, Activity_Vertical_Switch_Circle_Sliding::class.java))
        }

        findViewById<Button>(R.id.buttonSwitchRec).setOnClickListener{
            startActivity(Intent(this@MainActivity, Activity_Vertical_Switch_Rec_Sliding::class.java))
        }

        findViewById<Button>(R.id.buttonSwitchClick).setOnClickListener{
            startActivity(Intent(this@MainActivity, Activity_Vertical_Switch_Rec_Clicking::class.java))
        }

        findViewById<Button>(R.id.buttonBrightness).setOnClickListener{
            startActivity(Intent(this@MainActivity, Activity_Vertical_Slider_Brightness::class.java))
        }

        findViewById<Button>(R.id.buttonColors).setOnClickListener{
            startActivity(Intent(this@MainActivity, Activity_Vertical_Slider_Colors::class.java))
        }
    }
}