# Seunghyeon__miffy

## Level 1
> 1. 로그인, 회원가입 통신 구현하기!
>>회원가입 gif<br>
>> ![signUp](https://user-images.githubusercontent.com/81508084/118399048-3118f180-b696-11eb-9a95-764bd9ae6cdb.gif)
>><br>로그인 gif<br>
>>![signIn](https://user-images.githubusercontent.com/81508084/118399095-6b828e80-b696-11eb-9773-649588d58b0d.gif)
>><br><br>

>>로그인, 회원가입 통신 구현한 방법<br>
>>>로그인/회원가입 API를 활용하였습니다.<br>
>>>서버에 post하는 함수를 아래와 같이 구현하였습니다.<br>
```
    @POST("/login/signin")
    fun postSignin(
        @Body body: RequestSignInData
    ): Call<ResponseSignInData>
    
    @POST("/login/signup")
    fun postSignup(
        @Body body: RequestSignUpData
    ): Call<ResponseSignUpData>
```
>>>SignIn, SignUp에 해당하는 request, response data class를 구현하였고, 총 4개를 구현하였습니다.<br>
>>>RequestSignInData, ResponseSignInData / RequestSignUpData, ResponseSignUpData<br>

>>Postman 테스트 사진<br>
>>>회원가입 테스트<br>
>>>![image](https://user-images.githubusercontent.com/81508084/118399306-8570a100-b697-11eb-8a29-5a145393c437.png)
>>>로그인 테스트<br>
>>>![image](https://user-images.githubusercontent.com/81508084/118399328-a1744280-b697-11eb-9277-8e31b8946189.png)
