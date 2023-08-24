package com.example.gopharma.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gopharma.R
import com.example.gopharma.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.irCriarConta.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        if (view.id == R.id.irCriarConta){
            irCadastro()
        }
    }

    fun irCadastro(){
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}