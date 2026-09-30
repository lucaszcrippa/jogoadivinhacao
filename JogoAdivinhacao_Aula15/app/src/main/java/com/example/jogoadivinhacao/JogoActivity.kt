package com.example.jogoadivinhacao

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs
import kotlin.random.Random

class JogoActivity : AppCompatActivity() {

    private var numeroSecreto = 0
    private var maximo = 0
    private var tentativas = 0
    private lateinit var nome: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        nome = intent.getStringExtra("nome") ?: "Jogador"
        maximo = intent.getIntExtra("maximo", 10)

        val txtBoasVindas = findViewById<TextView>(R.id.txtBoasVindas)
        val edtPalpite = findViewById<EditText>(R.id.edtPalpite)
        val btnChutar = findViewById<Button>(R.id.btnChutar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtTentativas = findViewById<TextView>(R.id.txtTentativas)
        val btnJogarNovamente = findViewById<Button>(R.id.btnJogarNovamente)

        numeroSecreto = Random.nextInt(1, maximo + 1)

        txtBoasVindas.text = "$nome, pensei em um número de 1 a $maximo!"

        btnChutar.setOnClickListener {
            val textoPalpite = edtPalpite.text.toString().trim()

            if (textoPalpite.isEmpty()) {
                edtPalpite.error = "Digite um palpite"
                edtPalpite.requestFocus()
                return@setOnClickListener
            }

            val palpite = textoPalpite.toIntOrNull()

            if (palpite == null) {
                edtPalpite.error = "Digite apenas números"
                edtPalpite.requestFocus()
                return@setOnClickListener
            }

            if (palpite < 1 || palpite > maximo) {
                edtPalpite.error = "Digite um número entre 1 e $maximo"
                edtPalpite.requestFocus()
                return@setOnClickListener
            }

            tentativas++

            if (palpite == numeroSecreto) {
                txtResultado.text = "$nome acertou em $tentativas tentativas!"
                txtResultado.setTextColor(getColor(android.R.color.holo_green_dark))

                btnChutar.isEnabled = false
                edtPalpite.isEnabled = false
                btnJogarNovamente.visibility = Button.VISIBLE

                Toast.makeText(this, "Parabéns! Você acertou!", Toast.LENGTH_SHORT).show()
            } else {
                val diferenca = abs(numeroSecreto - palpite)
                val limiteQuente = maximo * 0.10

                val temperatura = if (diferenca <= limiteQuente) {
                    "Quente!"
                } else {
                    "Frio!"
                }

                val direcao = if (numeroSecreto > palpite) {
                    "O número é MAIOR."
                } else {
                    "O número é MENOR."
                }

                txtResultado.text = "$temperatura\n$direcao"
                txtResultado.setTextColor(getColor(android.R.color.holo_orange_dark))
            }

            txtTentativas.text = "Tentativas: $tentativas"
            edtPalpite.text.clear()
            edtPalpite.requestFocus()
        }

        btnJogarNovamente.setOnClickListener {
            finish()
        }
    }
}
