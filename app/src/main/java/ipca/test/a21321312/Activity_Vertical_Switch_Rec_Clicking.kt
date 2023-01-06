package ipca.test.a21321312

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ipca.test.a21321312.views.VerticalSwitchRecClicking

class Activity_Vertical_Switch_Rec_Clicking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_switch_rectangular_clicking)

        val textView = findViewById<TextView>(R.id.textViewStatus)
        val switch = findViewById<VerticalSwitchRecClicking>(R.id.verticalSwitch)

        switch.setOnStateChanged {
            if (it){
                textView.text = "Ligado"
            }else{
                textView.text = "Desligado"
            }
        }
    }
}