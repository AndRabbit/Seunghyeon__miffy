# Seunghyeon__miffy

## Level 1
> 1. 화면전환 후 데이터를 가져온 로직 정리
>> registerForActivityResult를 사용하기 위해 Launcher를 생성해줍니다!!<br>
```
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
```
>> SignUpActivity에서 나중에 다시 SignInActivity로 돌아올 때 get...Extra를 통하여 ID의 EditText 부분에 값을 전달하도록 했습니다.<br>
ID, PW, NAME은 SignUpActivity에서 받아온 값이며, 이 중에서 ID와 NAME은 HomeActivity로 넘어갈 때 putExtra를 통해 넘겨주게 됩니다.<br>
```
    // signUp textview를 클릭하면 실행되는 함수
    private fun tvLoginSignUpOnclickEvent(){
        binding.tvLoginSignUp.setOnClickListener(){
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
            // ActivityLauncher를 launch할 때 intent를 전달
        }
    }
```
>> SignUp TextView를 클릭하면 SignUpActivity로 전환되게 됩니다. signUpActivityLauncher를 launch할 때 intent를 전달하는 방식으로 동작합니다.<br><br>
SignUpActivity에서는 name, id, pw를 입력하고 signup 버튼을 클릭하면 다시 SignInActivity로 돌아가게 됩니다.<br>
```
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
```
>> signup 버튼을 누르면 EditText에 입력된 name, id, pw가 모두 채워져있을 경우 putExtra를 통하여 다시 SignInActivity로 보낼 준비를 합니다.<br>
putExtra가 끝나면, setResult 함수를 통해 RESULT_OK로 세팅하게 됩니다.<br>
putExtra로 보낸 값 중, id는 registerForActivityResult()의 binding.etLoginId.setText(it.data?.getStringExtra("id")) 코드에 의하여 SignInActivity의 id 부분에 바로 채워집니다.<br><br>
SignInActivity에서 HomeActivity로 넘어가는 과정에서는 homeActivityLauncher라는 것을 선언하여 사용했습니다.<br>
```
    private val homeActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        // 데이터를 받아서 할 일이 들어가는 칸!
        // 과제에선 여기까지 만들기
    }
```
>> HomeActivity에서 SignInActivity로 따로 보내줄 값이 없기 때문에 중괄호 안은 비워두었습니다.<br>
LOGIN 버튼을 클릭하면 HomeActivity로 넘어가게 됩니다.<br>
```
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
```
>> id와 비밀번호가 비어있지 않으면 HomeActivity로 전환되면서 putExtra로 id와 name을 넘겨주었습니다.<br>
>> HomeActivity에서는 get...Extra를 이용하여 id와 name을 받아와 화면에 보여줍니다.<br>
```
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHomeId.text = intent.getStringExtra("id")
        binding.tvHomeName.text = intent.getStringExtra("name")
    }
```

> 2. 생명주기를 호출하고 다른 액티비티를 호출하면 어떻게 되는지 로그 캡처<br>
>> ![image](https://user-images.githubusercontent.com/81508084/117708493-d81b0a80-b20a-11eb-9eb8-04f7d6e225c0.png)
> 3. 이번 과제를 통해 배운 내용 및 개발자로 성장한 내용
>> 1차 세미나 때 내용을 이렇게나 이해를 못 했었던 것이었는지 깨달을 수 있었다. registerForActivityResult를 이제 쓴다고는 하는데 이전에 개발 경험이 없어 startActivityForResult도 뭔지 모르는데 그냥 넘어갔어서 찝찝했는데, 
이번 기회에 확실하게 공부한 것 같아서 보람차다. 중간고사 시험기간에 그저 과제를 완성하는 것 자체에 너무 급급해 과제를 대충 했지만 여유가 생기고 다시 돌아보면서 조금이나마 더 안드로이드를 이해할 수 있어 좋았고, 
그 당시에는 제대로 이해하지 못했던 액티비티 간에 값을 넘겨주는 것들이나, binding 등 급급하게 넘어갔던 것들을 차분히 하나하나 이해할 시간을 가져서 한 층 더 성장한 것 같다.<br><br>

## Level 2
> 1. 변수 이름 체크하기
>> SignInActivity
>>> cl_login_id, cl_login_pw, cl_login_signUp: constraintLayout<br>
>>> tv_login_id, tv_login_pw, tv_login_noIDnoPW, tv_login_signUp: TextView<br>
>>> et_login_id, et_login_pw: EditText<br>
>>> btn_login: Button

>> SignUpActivity
>>> cl_signUp_name, cl_signUp_id, cl_signUp_pw: constraingLayout<br>
>>> tv_signUp_name, tv_signUp_id, tv_signUp_pw: TextView<br>
>>> et_signUp_name, et_signUp_id, et_signUp_pw: EditText<br>
>>> btn_signUp_signUP: Button

>> HomeActivity
>>> cl_home_profile: constraintLayout<br>
>>> tv_home_id, tv_home_name, tv_home_intro: TextView<br>
>>> imv_home_image: ImageView<br>
> 2. ConstraintLayout 마스터하기
>> chain 활용하였습니다.
```
        app:layout_constraintVertical_chainStyle="packed"
```
> 3. ScrollView 사용
>> HomeActivity에서 tv_home_intro를 ScrollView로 감싸주었습니다.
```
        <ScrollView
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:id="@+id/scv_home_intro"
            android:background="@color/white"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintBottom_toBottomOf="parent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:id="@+id/tv_home_intro"
                android:text="화이팅입니다\n화이팅입니다\n화이팅입니다"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintBottom_toBottomOf="parent"/>
```
>>
