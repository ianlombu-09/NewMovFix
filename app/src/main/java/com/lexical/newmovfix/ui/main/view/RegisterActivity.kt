package com.lexical.newmovfix.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lexical.newmovfix.R
import com.lexical.newmovfix.ui.main.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private val registerViewModel: RegisterViewModel by lazy {
        ViewModelProviders.of(this).get(RegisterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_submit_register.setOnClickListener {
            registerViewModel.register(
                et_email_register.text.toString(),
                et_username_register.text.toString(),
                et_address_register.text.toString(),
                et_dob_register.text.toString(),
                et_password_register.text.toString()
            )
        }

        setObserver()
    }

    private fun setObserver() {
        registerViewModel.getRegisterUserResponse().observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
            }
        })

        registerViewModel.getErrorListener().observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Sorry, something is wrong", Toast.LENGTH_SHORT ).show()
            }
        })
    }
}