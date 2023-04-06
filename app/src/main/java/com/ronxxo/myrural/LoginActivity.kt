package com.ronxxo.myrural

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class LoginActivity : AppCompatActivity() {
    private lateinit var  image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        image=findViewById(R.id.imageView)
        image.alpha =0f
        image.animate().setDuration(2000).alpha(1f).withEndAction {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}