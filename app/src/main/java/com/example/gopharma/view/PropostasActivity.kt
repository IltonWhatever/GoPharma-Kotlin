package com.example.gopharma.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.gopharma.R
import com.example.gopharma.databinding.ActivityPropostasBinding
import com.example.gopharma.models.Cliente
import com.example.gopharma.util.Endpoints
import com.example.gopharma.util.ServerHTTP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PropostasActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding : ActivityPropostasBinding
    lateinit var clientes : ArrayList<Cliente>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPropostasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener(this)

        binding.listPropostas.setOnItemClickListener{parent, view, position, id->
            val intent = Intent(this@PropostasActivity, ClientDetails::class.java)
            intent.putExtra("idClient", "2")
            println("Passou Aqui 1")
            startActivity(intent)
            println("Passou Aqui 2")
        }

        listCliente()
    }

    override fun onClick(v:View) {

    }

    fun listCliente(){
        val retrofitClient = ServerHTTP.getRetrofitInstance("http://192.168.137.1:5000/")

        val endpoint = retrofitClient.create(Endpoints::class.java)

        val callback = endpoint.getCliente()

        // on below line we are executing our method.
        callback.enqueue(object : Callback<List<Cliente>> {
            override fun onResponse(call: Call<List<Cliente>>, response: Response<List<Cliente>>) {
                // this method is called when we get response from our api.
                //Toast.makeText(this@CadastroActivity, "Cliente Cadastrado com Sucesso", Toast.LENGTH_SHORT).show()
                clientes = ArrayList<Cliente>()
                response.body()?.forEach { clientes.add(it) }

                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, clientes)
                binding.listPropostas.adapter = adapter

            }


            override fun onFailure(call: Call<List<Cliente>>, t: Throwable) {
                // setting text to our text view when
                // we get error response from API.
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                // responseTV.setText("Error found is : " + t.message)
            }
        })
    }
}