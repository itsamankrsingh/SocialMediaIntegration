package com.itsamankrsingh.facebooksignin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.itsamankrsingh.facebooksignin.R
import kotlinx.android.synthetic.main.activity_google_login.*


class GoogleLoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_google_login)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        user.let {
            google_name_txt.text = user?.displayName
            google_email_txt.text = user?.email
            Glide.with(this).load(user?.photoUrl.toString()).into(google_profile_image)
        }

        google_sign_out_btn.setOnClickListener {
            auth.signOut()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }

    }
}