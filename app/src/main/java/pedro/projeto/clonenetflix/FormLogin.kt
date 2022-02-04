package pedro.projeto.clonenetflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    }
}