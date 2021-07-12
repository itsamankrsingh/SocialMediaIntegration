package com.itsamankrsingh.facebooksignin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.itsamankrsingh.facebooksignin.R
import kotlinx.android.synthetic.main.activity_facebook_login.*

class FacebookLoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_login)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        user.let {
            name_txt.text = user?.displayName
            email_txt.text = user?.email
            Glide.with(this).load(user?.photoUrl).into(facebook_profile_image)
        }
        sign_out_btn.setOnClickListener {
            auth.signOut()
            LoginManager.getInstance().logOut()
            finish()
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}