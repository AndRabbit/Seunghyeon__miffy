package org.sopt.presentation.signup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.api.ServiceCreator
import org.sopt.data.request.RequestSignUpData
import org.sopt.data.response.ResponseSignUpData
import org.sopt.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("mylog", "SignUp_onCreate")

        btnSignUpOnClickEvent()
    }

    override fun onStart() {
        super.onStart()
        Log.d("mylog", "SignUp_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mylog", "SignUp_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mylog", "SignUp_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mylog", "SignUp_onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mylog", "SignUp_onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mylog", "SignUp_onDestroy")
    }

    private fun btnSignUpOnClickEvent() {
        val name = binding.etSignUpName.text
        val id = binding.etSignUpId.text
        val pw = binding.etSignUpPw.text
        val sex = if(binding.rgrpSignUpSex.checkedRadioButtonId == binding.rbtnSignUpMale.id) "1" else "0"
        val phone = binding.etSignUpPhone.text
        val birth = binding.etSignUpBirth.text
        binding.btnSignUpSignUp.setOnClickListener() {
            if (name.isNullOrBlank() || id.isNullOrBlank() || pw.isNullOrBlank() ||
                sex.isNullOrBlank() || phone.isNullOrBlank() || birth.isNullOrBlank()) {
                Toast.makeText(this, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                checkSignUpInfo()
            }
        }
    }
    private fun checkSignUpInfo(){
        // 회원가입 데이터 생성
        val requestSignUpData = RequestSignUpData(
            email = binding.etSignUpId.text.toString(),
            password = binding.etSignUpPw.text.toString(),
            sex = if(binding.rgrpSignUpSex.checkedRadioButtonId == binding.rbtnSignUpMale.id) "1" else "0",
            nickname = binding.etSignUpName.text.toString(),
            phone = binding.etSignUpPhone.text.toString(),
            birth = binding.etSignUpBirth.text.toString()
        )

        val call: Call<ResponseSignUpData> = ServiceCreator.signUpService.postSignup(requestSignUpData)

        call.enqueue(object: Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ){
                if(response.isSuccessful){
                    val data = response.body()?.data
                    Log.d("mylog", data?.nickname + ", " + response.body()?.message)
                    Toast.makeText(this@SignUpActivity, data?.nickname +"님 회원가입을 축하합니다.", Toast.LENGTH_SHORT).show()
                    returnSignInActivity()
                } else {
                    // 에러처리 어떻게 할지 생각해보기
                    Toast.makeText(this@SignUpActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.d("NetworkTest","error:$t")
            }
        })
    }
    private fun returnSignInActivity(){
        val intent = Intent()
        intent.putExtra("id", binding.etSignUpId.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}