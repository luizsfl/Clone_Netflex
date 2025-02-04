package pedro.projeto.clonenetflix

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import pedro.projeto.clonenetflex.R
import pedro.projeto.clonenetflex.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        Toolbar()

        binding.btCadastrar.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val mensagem_erro = binding.mensagemErro

            if (email.isEmpty()){
                mensagem_erro.text = "Informe o E-mail"
            }else if (senha.isEmpty()){
                mensagem_erro.text = "Informe a semja"
            }else{
                CadastrarUsuario()
            }
        }


    }

    private fun Toolbar(){
        val toolbar = binding.toolbarCadastro
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setBackgroundColor(getColor(R.color.white))
        }
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))

    }

    private fun CadastrarUsuario(){
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val mensagem_erro = binding.mensagemErro

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this,"Usuario cadastrado com sucesso!",Toast.LENGTH_SHORT).show()
                    binding.editEmail.setText("")
                    binding.editSenha.setText("")
                    binding.mensagemErro.setText("")
                }
            }.addOnFailureListener {

                var erro = it

                when{
                    erro is FirebaseAuthWeakPasswordException -> mensagem_erro.setText("Digite uma senha com no mínimo 6 caracteres")
                    erro is FirebaseAuthUserCollisionException -> mensagem_erro.setText("E-mail já cadastrado")
                    erro is FirebaseNetworkException -> mensagem_erro.setText("Sem conexão com a internet")
                    else -> mensagem_erro.setText("Erro ao cadastrar usuário"+it.toString())
                }

            }

    }
}