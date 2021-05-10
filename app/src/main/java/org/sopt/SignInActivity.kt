package org.sopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btLoginOnClickEvent()
        tvLoginSignUpOnclickEvent()
    }

    private var ID = ""
    private var PW = ""
    private var NAME = ""

    private val homeActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        // 데이터를 받아서 할 일이 들어가는 칸!
        // 과제에선 여기까지 만들기
    }

    private fun btLoginOnClickEvent(){
        binding.btLogin.setOnClickListener(){
            val id = binding.etLoginId.text
            val pw = binding.etLoginPw.text
            if(id.isNullOrBlank() || pw.isNullOrBlank()){
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", ID)
                intent.putExtra("name", NAME)
                homeActivityLauncher.launch(intent)
            }
        }
    }

    // signUpActivityLauncher를 만드는 것으로 시작
    // registerForActivityResult 메소드를 통해 만든다.
    private val signUpActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ){
        binding.etLoginId.setText(it.data?.getStringExtra("id"))
        ID = it.data?.getStringExtra("id").toString()
        PW = it.data?.getStringExtra("pw").toString()
        NAME = it.data?.getStringExtra("name").toString()
        // 데이터를 받아서 할 일이 들어가는 칸!
        // 과제에선 여기까지만 만들기
    }

    // signUp textview를 클릭하면 실행되는 함수
    private fun tvLoginSignUpOnclickEvent(){
        binding.tvLoginSignUp.setOnClickListener(){
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
            // ActivityLauncher를 launch할 때 intent를 전달
        }
    }
}