package com.example.gopharma.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gopharma.R
import com.example.gopharma.databinding.ActivityCadastroBinding
import com.example.gopharma.models.Cliente
import com.example.gopharma.util.Endpoints
import com.example.gopharma.util.ServerHTTP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding: ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.criarConta.setOnClickListener(this)
        binding.textCriarConta.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.criarConta){
            saveCliente()
        }
        if (view.id == R.id.textCriarConta){
            val intent = Intent(this, PropostasActivity::class.java)
            startActivity(intent)
        }
    }

    fun saveCliente(){
        val cliente = Cliente(null, binding.nome.text.toString(), binding.email.text.toString(),
            binding.telefone.text.toString(), binding.senha.text.toString())
        val retrofitClient = ServerHTTP
            .getRetrofitInstance("http://192.168.137.1:5000/")

        val endpoint = retrofitClient.create(Endpoints::class.java)

        val callback = endpoint.addCliente(cliente)

        // on below line we are executing our method.
        callback.enqueue(object : Callback<Cliente> {
            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                // this method is called when we get response from our api.
                Toast.makeText(this@CadastroActivity, "Cliente Cadastrado com Sucesso", Toast.LENGTH_SHORT)
                    .show()
                val responseFromAPI: Cliente? = response.body()

                binding.nome.setText(responseFromAPI?.id.toString())
            }


            override fun onFailure(call: Call<Cliente?>, t: Throwable) {
                // setting text to our text view when
                // we get error response from API.
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                // responseTV.setText("Error found is : " + t.message)
            }
        })




    }
}