package ipca.test.a21321312.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import java.lang.Math.abs

class VerticalSwitchCirSliding : View , GestureDetector.OnGestureListener{


    private val swipeThreshold = 100
    private val swipeVelocityThreshold = 100
    private var isOn = false
    private var gestureDetector: GestureDetectorCompat = GestureDetectorCompat(context, this)


    private var onStateChanged : ((Boolean) ->Unit)? = null
    fun setOnStateChanged(onStateChanged : (Boolean) ->Unit) {
        this.onStateChanged = onStateChanged
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val paint = Paint()
    private val blueRectF = RectF()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val radius = (height/2).toFloat()
        blueRectF.set(0F, 0F, width.toFloat(), height.toFloat())
        paint.color = Color.BLUE
        canvas?.drawRoundRect(blueRectF, radius, radius,paint)

        val margin = 20F
        paint.color = Color.YELLOW
        if (isOn) {
            canvas?.drawCircle(
                (width / 2).toFloat(),  // coordenadas x e y do centro do círculo
                (height / 4).toFloat(),  // coordenadas x e y do centro do círculo
                (height / 4 - margin),  // raio do círculo
                paint  // objeto Paint
            )
        } else {
            canvas?.drawCircle(
                (width / 2).toFloat(),  // coordenadas x e y do centro do círculo
                (height * 3 / 4).toFloat(),  // coordenadas x e y do centro do círculo
                (height / 4 - margin),  // raio do círculo
                paint  // objeto Paint
            )
        }

        paint.color = Color.BLACK
        paint.textSize = 60f
        paint.textAlign = Paint.Align.CENTER
        canvas?.drawText("ON", width / 2f, 80f, paint)
        canvas?.drawText("OFF", width / 2f, height - 80f, paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (gestureDetector.onTouchEvent(event)) {
            true
        }
        else {
            super.onTouchEvent(event)
        }
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        return
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        return
    }


    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        try {
            val diffY = e2.y - e1.y
            val diffX = e2.x - e1.x
            if (abs(diffX) > abs(diffY)) {
                if (abs(diffX) > swipeThreshold && abs(velocityX) > swipeVelocityThreshold) {
                    if (diffX > 0) {
                        Toast.makeText(context, "Left to Right swipe gesture", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(context, "Right to Left swipe gesture", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                if (abs(diffY) > swipeThreshold && abs(velocityY) > swipeVelocityThreshold) {
                    isOn = diffY <= 0
                    onStateChanged?.invoke(isOn)
                    invalidate()
                }
            }
        }
        catch (exception: Exception) {
            exception.printStackTrace()
        }
        return true
    }
}