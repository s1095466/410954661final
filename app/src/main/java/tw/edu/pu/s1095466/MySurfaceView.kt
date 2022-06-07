package tw.edu.pu.s1095466

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import tw.edu.pu.s1095466final.R

class MySurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs) ,SurfaceHolder.Callback{
    lateinit var surfaceHolder: SurfaceHolder
    lateinit var BG: Bitmap


    init {
        surfaceHolder = getHolder()
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.background)
        surfaceHolder.addCallback(this)
    }


    override fun surfaceCreated(p0: SurfaceHolder) {
        var canvas: Canvas = surfaceHolder.lockCanvas()
        drawSomething(canvas)
        surfaceHolder.unlockCanvasAndPost(canvas)

    }

    var BGmoveX:Int = 0
    fun drawSomething(canvas:Canvas) {
        //canvas.drawBitmap(BG, 0f, 0f, null)
        //背景往左
        BGmoveX --
        var BGnewX:Int = BG.width + BGmoveX
        // 如果已捲動整張圖，則重新開始
        if (BGnewX <= 0) {
            BGmoveX = 0
            // only need one draw
            canvas.drawBitmap(BG, BGmoveX.toFloat(), 0f, null)
        } else {
            // need to draw original and wrap
            canvas.drawBitmap(BG, BGmoveX.toFloat(), 0f, null)
            canvas.drawBitmap(BG, BGnewX.toFloat(), 0f, null)
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }
}