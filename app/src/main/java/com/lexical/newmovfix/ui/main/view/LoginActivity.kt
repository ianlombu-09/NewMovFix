package com.lexical.newmovfix.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lexical.newmovfix.R
import com.lexical.newmovfix.ui.main.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener{
            loginViewModel.login(et_email.text.toString(), et_password.text.toString())
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btn_register.setOnClickListener {
            Toast.makeText(this, "Click Btn Register", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        setObserver()
    }

    private fun setObserver() {
        loginViewModel.getLoginUserResponse().observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            }
        })

        loginViewModel.getErrorListener().observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Sorry, something is wrong", Toast.LENGTH_SHORT ).show()
            }
        })
    }

    private fun login(email: String, password: String = "default"): String {
        return password
    }
}