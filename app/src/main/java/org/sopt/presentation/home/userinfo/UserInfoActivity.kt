package org.sopt.presentation.home.userinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.presentation.home.userinfo.following.FollowingListFragment
import org.sopt.R
import org.sopt.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val followingListFragment = FollowingListFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fcv_userInfo_fragment, followingListFragment)
        transaction.commit()

        Log.d("myLog","UserInfoActivity_onCreate")
    }
}