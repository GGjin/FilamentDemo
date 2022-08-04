package com.gg.filamentdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gg.filamentdemo.camera.CameraActivity
import com.gg.filamentdemo.databinding.ActivityMainBinding
import com.gg.filamentdemo.gltf.GltfActivity
import com.gg.filamentdemo.triangle.HelloTriangleActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.GltfActivity.setOnClickListener {
            startActivity(Intent(this, GltfActivity::class.java))
        }
        binding.HelloTriangleActivity.setOnClickListener {
            startActivity(Intent(this, HelloTriangleActivity::class.java))
        }
        binding.CameraActivity.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

    }

    /**
     * A native method that is implemented by the 'filamentdemo' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'filamentdemo' library on application startup.
        init {
            System.loadLibrary("filamentdemo")
        }
    }
}