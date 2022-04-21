package com.ispace.shuttledrive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ispace.shuttledrive.auth.LoginActivity
import com.ispace.shuttledrive.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    /*private lateinit var startBn: Button*/
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*startBn = findViewById(R.id.startBn)*/

        binding.button.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}