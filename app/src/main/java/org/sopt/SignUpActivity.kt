package org.sopt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btSignUpOnClickEvent()
    }

    private fun btSignUpOnClickEvent(){
        val name = binding.etSignUpName.text
        val id = binding.etSignUpId.text
        val pw = binding.etSignUpPw.text
        binding.btSignUpSignUp.setOnClickListener() {
            if (name.isNullOrBlank() || id.isNullOrBlank() || pw.isNullOrBlank()) {
                Toast.makeText(this, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("id", id.toString())
                intent.putExtra("pw", pw.toString())
                intent.putExtra("name",name.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}