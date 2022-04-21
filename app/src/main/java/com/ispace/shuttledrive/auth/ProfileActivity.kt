package com.ispace.shuttledrive.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.firebase.auth.FirebaseAuth
import com.ispace.shuttledrive.MainActivity
import com.ispace.shuttledrive.R
import com.ispace.shuttledrive.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityProfileBinding
    //action bar
    private lateinit var actionBar: ActionBar
    //firebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure actionbar
        //configure ActionBar //enable back button
        /*actionBar = supportActionBar!!
        actionBar.title = "Profile"*/

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click logout
        binding.logoutBn.setOnClickListener{
            firebaseAuth.signOut()
            checkUser()
        }
        //handle click home
        binding.homeBn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun checkUser() {
        //check if user is logged in or not
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            //user is already logged in, get user info
            //get user
            val email = firebaseUser.email
            //set to text view
            binding.emailTv.text = email
        }
        else{
            //user is not logged in
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}