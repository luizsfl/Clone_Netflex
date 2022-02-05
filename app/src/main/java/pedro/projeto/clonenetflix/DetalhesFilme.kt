package pedro.projeto.clonenetflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import pedro.projeto.clonenetflex.R
import pedro.projeto.clonenetflex.databinding.ActivityDetalhesFilmeBinding
import pedro.projeto.clonenetflix.Adapter.FilmesAdapter
import pedro.projeto.clonenetflix.Modal.addFilmes

class DetalhesFilme : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_filme)

        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        toolbar()

        val recycle_outros_filmes = binding.recycleOutrosFilmes

        recycle_outros_filmes.adapter = FilmesAdapter(addFilmes())
        recycle_outros_filmes.layoutManager = GridLayoutManager(applicationContext,3)

    }
    private fun toolbar(){
        val toolbar_detalhes = binding.toolbarDetalhes
        toolbar_detalhes.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
        toolbar_detalhes.setNavigationOnClickListener {
            val intent = Intent(this,ListaFilmes::class.java)
            startActivity(intent)
            finish()

        }
    }
}