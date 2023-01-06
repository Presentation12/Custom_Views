package ipca.test.a21321312

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ipca.test.a21321312.views.VerticalSwitchRecSliding

class Activity_Vertical_Switch_Rec_Sliding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_switch_rectangular_sliding)

        val textView = findViewById<TextView>(R.id.textViewStatus)
        val switch = findViewById<VerticalSwitchRecSliding>(R.id.verticalSwitch)

        switch.setOnStateChanged {
            if (it){
                textView.text = "Ligado"
            }else{
                textView.text = "Desligado"
            }
        }
    }
}