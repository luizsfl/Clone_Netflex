package pedro.projeto.clonenetflex

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pedro.projeto.clonenetflex.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarCadastro
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setBackgroundColor(getColor(R.color.white))
        }
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))




    }
}