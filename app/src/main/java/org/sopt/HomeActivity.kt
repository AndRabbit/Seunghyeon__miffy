package org.sopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHomeId.text = intent.getStringExtra("id")
        binding.tvHomeName.text = intent.getStringExtra("name")
    }
}