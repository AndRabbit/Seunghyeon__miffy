package org.sopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("mylog", "Home_onCreate")

        binding.tvHomeId.text = intent.getStringExtra("id")
        binding.tvHomeName.text = intent.getStringExtra("name")
    }

    override fun onStart() {
        super.onStart()
        Log.d("mylog", "Home_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mylog", "Home_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mylog", "Home_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mylog", "Home_onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mylog", "Home_onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mylog", "Home_onDestroy")
    }
}