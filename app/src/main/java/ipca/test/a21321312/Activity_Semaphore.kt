package ipca.test.a21321312

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ipca.test.a21321312.views.SemaphoreView

class Activity_Semaphore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.semaphore_activity)

        var buttonPassar = findViewById<Button>(R.id.buttonPassar)
        var semaphoreView = findViewById<SemaphoreView>(R.id.semaphoreView)

        buttonPassar.setOnClickListener {
            semaphoreView.goToRed()

        }

        semaphoreView.setOnSemaphoreStateChanged { state ->
            when(state){
                SemaphoreView.SemaphoreState.GREEN ->{
                    buttonPassar.isEnabled = true
                }
                SemaphoreView.SemaphoreState.YELLOW,
                SemaphoreView.SemaphoreState.RED -> {
                    buttonPassar.isEnabled = false
                }
            }
        }
    }
}