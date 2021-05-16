package org.sopt.presentation.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.api.ServiceCreator
import org.sopt.data.request.RequestSignInData
import org.sopt.data.response.ResponseSignInData
import org.sopt.presentation.signup.SignUpActivity
import org.sopt.databinding.ActivitySignInBinding
import org.sopt.presentation.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnLoginOnClickEvent()
        tvLoginSignUpOnclickEvent()
        Log.d("mylog", "SignIn_onCreate")
    }

    private var ID = ""
    private var PW = ""
    private var NAME = ""

    private val homeActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        // 데이터를 받아서 할 일이 들어가는 칸!
        // 과제에선 여기까지 만들기
    }

    private fun btnLoginOnClickEvent() {
        binding.btnLogin.setOnClickListener() {
            val id = binding.etLoginId.text
            val pw = binding.etLoginPw.text
            if (id.isNullOrBlank() || pw.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                checkLoginInfo()
            }
        }
    }

    // signUpActivityLauncher를 만드는 것으로 시작
    // registerForActivityResult 메소드를 통해 만든다.
    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        binding.etLoginId.setText(it.data?.getStringExtra("id"))
        ID = it.data?.getStringExtra("id").toString()
        PW = it.data?.getStringExtra("pw").toString()
        NAME = it.data?.getStringExtra("name").toString()
        // 데이터를 받아서 할 일이 들어가는 칸!
        // 과제에선 여기까지만 만들기
    }

    // signUp textview를 클릭하면 실행되는 함수
    private fun tvLoginSignUpOnclickEvent() {
        binding.tvLoginSignUp.setOnClickListener() {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
            // ActivityLauncher를 launch할 때 intent를 전달
        }
    }

    private fun checkLoginInfo(){
        // 서버로 보낼 로그인 데이터 생
        val requestSignInData = RequestSignInData(
            email = binding.etLoginId.text.toString(),
            password = binding.etLoginPw.text.toString()
        )

        // 현재 사용자의 정보를 받아올 것을 명시!
        // 서버 통신은 I/O 작업이므로 비동기적으로 받아올 Callback 내부 코드는 나중에
        // 데이터를 받아오고 실행된다.
        val call: Call<ResponseSignInData> = ServiceCreator.signInService.postSignin(requestSignInData)

        // enqueue 함수를 이용해 Call이 비동기 작업이후 동작할 Callback 을 등록할 수 있다.
        // 해당 함수 호출은 Callback을 등록만 하고
        // 실제 서버 통신을 요청이후 통신 결과가 나왔을 때 실행된다.
        // object 키워드로 Callback을 구현할 익명 클래스를 생성
        call.enqueue(object: Callback<ResponseSignInData>{
            // 네트워크 통신 Response 가 있는 경우 해당 함수를 retrofit이 호출
            override fun onResponse(
                call: Call<ResponseSignInData>,
                response: Response<ResponseSignInData>
            ) {
                // 네트워크 통신에 성공한 경우 status 코드가 200~300일 때! 실행
                if(response.isSuccessful){
                    // response body 자체가 nullable 데이터! 그런데 서버에서 오는 data 도 nullable!
                    val data = response.body()?.data
                    // 통신 성공시 유저 닉네임을 보여준다.
                    Toast.makeText(this@SignInActivity, data?.user_nickname + "님이 로그인하였습니다.", Toast.LENGTH_SHORT).show()
                    // 홈 화면으로 넘어간다.
                    ID = binding.etLoginId.text.toString()
                    NAME = data?.user_nickname.toString()
                    startHomeActivity()
                } else{
                    // 에러가 났다면?
                }
            }

            override fun onFailure(call: Call<ResponseSignInData>, t: Throwable) {
                Log.d("NetworkTest","error:$t")
            }
        })
    }

    private fun startHomeActivity(){
        val intent = Intent(this, HomeActivity::class.java)

        intent.putExtra("id", ID)
        intent.putExtra("name", NAME)
        homeActivityLauncher.launch(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("mylog", "SignIn_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mylog", "SignIn_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mylog", "SignIn_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mylog", "SignIn_onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mylog", "SignIn_onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mylog", "SignIn_onDestroy")
    }
}
