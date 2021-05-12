package org.sopt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repositoryListFragment = RepositoryListFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fcv_home_repoInfo, repositoryListFragment)
        transaction.commit()

        Log.d("mylog", "Home_onCreate")

        btnHomeMoreOnClickEvent()
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

    private val userInfoActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){

    }

    private fun btnHomeMoreOnClickEvent(){
        binding.btnHomeMore.setOnClickListener(){
            val intent = Intent(this, UserInfoActivity::class.java)
            userInfoActivityLauncher.launch(intent)
        }
    }
}