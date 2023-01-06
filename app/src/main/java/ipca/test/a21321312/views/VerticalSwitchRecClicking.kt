package ipca.test.a21321312.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class VerticalSwitchRecClicking : View{

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var isOn = false

    private var onStateChanged : ((Boolean) ->Unit)? = null
    fun setOnStateChanged(onStateChanged : (Boolean) ->Unit) {
        this.onStateChanged = onStateChanged
    }

    private val paint = Paint()
    private val blueRect = Rect()
    private val yellowRect = Rect()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        blueRect.set(0, 0, width, height)
        paint.color = Color.BLUE
        canvas?.drawRect(blueRect, paint)

        val margin = 20
        paint.color = Color.YELLOW
        if (isOn) {
            yellowRect.set(margin, margin, width - margin, (height/2)- margin)
            canvas?.drawRect(yellowRect, paint)
        }else{
            yellowRect.set(margin, (height/2)- margin, width - margin, height- margin)
            canvas?.drawRect(yellowRect, paint)
        }

        paint.color = Color.BLACK
        paint.textSize = 60f
        paint.textAlign = Paint.Align.CENTER
        canvas?.drawText("ON", width / 2f, 80f, paint)
        canvas?.drawText("OFF", width / 2f, height - 80f, paint)
    }

    private val sideSelected: Rect
        get() {
            return if (isOn) {
                Rect(0, 0, width, (height/2))
            } else {
                Rect(0, (height/2), width, height)
            }
        }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val x = event.getX().toInt()
            val y = event.getY().toInt()
            if (!sideSelected.contains(x, y)) {
                isOn = !isOn
                onStateChanged?.invoke(isOn)
                invalidate()
            }
        }
        return super.onTouchEvent(event)
    }
}