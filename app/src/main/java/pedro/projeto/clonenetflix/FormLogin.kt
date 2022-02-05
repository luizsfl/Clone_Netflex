package pedro.projeto.clonenetflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import pedro.projeto.clonenetflex.R
import pedro.projeto.clonenetflex.databinding.ActivityFormLoginBinding
import pedro.projeto.clonenetflex.databinding.ActivityMainBinding

class FormLogin : AppCompatActivity() {

    lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar!!.hide()

        binding.txtTelaCadastro.setOnClickListener{
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }

        binding.btEntrar.setOnClickListener {
            val email = binding.editLogin.text.toString()
            val senha = binding.editSenha.text.toString()
            var mernsagem_erro = binding.mensageErro
            if (email.isEmpty() || senha.isEmpty())
            {
                mernsagem_erro.setText("Prencha os campos de e-mail e senha")
            }else{
                AutenticarUsuário(email,senha,mernsagem_erro)
            }

        }


    }
    private fun AutenticarUsuário(email:String,senha:String,mernsagem_erro:TextView){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {
          if (it.isSuccessful){
              Toast.makeText(this,"Login efetuado com sucesso",Toast.LENGTH_SHORT).show()
              IrParaTelaFilmes()
          }else{
              mernsagem_erro.setText("Erro ao tentar logar"+it)
          }
        }
    }

    private fun IrParaTelaFilmes(){
        val intent = Intent(this,ListaFilmes::class.java)
        startActivity(intent)
       // finish()
    }
}