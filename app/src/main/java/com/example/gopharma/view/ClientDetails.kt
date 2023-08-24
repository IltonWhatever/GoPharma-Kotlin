package com.example.gopharma.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.gopharma.R
import com.example.gopharma.databinding.ActivityCadastroBinding
import com.example.gopharma.databinding.ActivityClientDetailsBinding
import com.example.gopharma.models.Cliente
import com.example.gopharma.util.Endpoints
import com.example.gopharma.util.ServerHTTP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientDetails : AppCompatActivity(), View.OnClickListener{
    lateinit var binding : ActivityClientDetailsBinding
    lateinit var idCliente: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idCliente = intent.getStringExtra("idClient").toString()

        binding.editButton.setOnClickListener(this)
        binding.deleteButton.setOnClickListener(this)

    }


    fun getCliente(idClient : String){
        val retrofitClient = ServerHTTP.getRetrofitInstance("http://192.168.137.1:5000/")

        val endpoint = retrofitClient.create(Endpoints::class.java)

        val callback = endpoint.getClienteID(idClient)

        // on below line we are executing our method.
        callback.enqueue(object : Callback<Cliente> {
            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                // this method is called when we get response from our api.
                Toast.makeText(this@ClientDetails, "Cliente Cadastrado com Sucesso", Toast.LENGTH_SHORT)
                    .show()
                val cliente: Cliente? = response.body()



                binding.detailnome.setText("ilton")
                binding.celular.setText(cliente?.celular.toString())
                binding.email.setText(cliente?.email.toString())
            }


            override fun onFailure(call: Call<Cliente?>, t: Throwable) {
                // setting text to our text view when
                // we get error response from API.
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                // responseTV.setText("Error found is : " + t.message)
            }
        })




    }

    override fun onClick(view: View) {
        TODO("Not yet implemented")
    }
}