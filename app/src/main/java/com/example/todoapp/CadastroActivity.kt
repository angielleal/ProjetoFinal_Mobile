package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CadastroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro) // Certifique-se de usar o layout correto

        // Inicializar o Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Conectar os elementos do layout
        val loginTitle = findViewById<TextView>(R.id.loginTitle)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val backToLoginButton = findViewById<Button>(R.id.backToLoginButton)
        val cepInput = findViewById<EditText>(R.id.inputCep) // Novo campo para o CEP
        val fetchCepButton = findViewById<Button>(R.id.buttonBuscarCep) // Botão para buscar o CEP

        // Exemplo de ajuste do título dinamicamente (opcional)
        loginTitle.text = "Cadastre-se"

        // Configurar clique do botão de registro
        registerButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(
                                this,
                                "Erro ao cadastrar: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
        backToLoginButton.setOnClickListener {
            // Criar uma Intent para voltar para a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Fechar a RegisterActivity para que não volte para ela ao pressionar o botão "Voltar"
        }
        // Configurar clique do botão de busca de CEP
        fetchCepButton.setOnClickListener {
            val cep = cepInput.text.toString().trim()

            if (cep.isNotEmpty()) {
                fetchCepData(cep)
            } else {
                Toast.makeText(this, "Preencha o campo de CEP", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun fetchCepData(cep: String) {
        val call = RetrofitClient.instance.getAddress(cep)

        call.enqueue(object : Callback<CepResponse> {
            override fun onResponse(call: Call<CepResponse>, response: Response<CepResponse>) {
                if (response.isSuccessful) {
                    val cepResponse = response.body()
                    if (cepResponse != null) {
                        Toast.makeText(
                            this@CadastroActivity,
                            "Logradouro: ${cepResponse.logradouro}, Bairro: ${cepResponse.bairro}, Cidade: ${cepResponse.localidade}",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(this@CadastroActivity, "CEP não encontrado!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@CadastroActivity, "Erro na API", Toast.LENGTH_SHORT).show()
                }
            }


            override fun onFailure(call: Call<CepResponse>, t: Throwable) {
                Toast.makeText(this@CadastroActivity, "Falha na conexão: ${t.message}", Toast.LENGTH_SHORT).show()
            }
            })
        }
}
