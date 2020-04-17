package com.example.opencvproject2

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.opencvproject2.extensions.toBitmap
import com.example.opencvproject2.extensions.toGray
import kotlinx.android.synthetic.main.activity_main2.*
import org.opencv.android.InstallCallbackInterface
import org.opencv.android.LoaderCallbackInterface
import org.opencv.android.OpenCVLoader
import org.opencv.android.OpenCVLoader.initAsync
import org.opencv.core.Mat


class Main2Activity : AppCompatActivity() {

    companion object {
        const val TAG = "StarterApplication"
    }

    private val imageBitmap by lazy { (ContextCompat.getDrawable(this, R.drawable.lena) as BitmapDrawable).bitmap }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        image.setOnClickListener {
            applyGrayScale()
        }
    }

    private fun applyGrayScale() {
        Looper.getMainLooper()
        val mat = Mat()
        mat.toGray(imageBitmap)
        image.setImageBitmap(mat.toBitmap())
        mat.release()
    }
}
