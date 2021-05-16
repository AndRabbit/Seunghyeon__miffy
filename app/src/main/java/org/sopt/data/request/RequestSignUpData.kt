package org.sopt.data.request

data class RequestSignUpData(
    val email: String,
    val password: String,
    val sex: String,
    val nickname: String,
    val phone: String,
    val birth: String,
)

// "email" : "test1",
//    "password" : "1111",
//    "sex" : "0",
//    "nickname" : "sopt_test",
//    "phone" : "010-1010-2020",
//    "birth" : "1996-02-24"