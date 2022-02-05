package pedro.projeto.clonenetflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import pedro.projeto.clonenetflex.R
import pedro.projeto.clonenetflex.databinding.ActivityFormLoginBinding
import pedro.projeto.clonenetflex.databinding.ActivityListaFilmesBinding
import pedro.projeto.clonenetflix.Adapter.FilmesAdapter
import pedro.projeto.clonenetflix.Modal.addFilmes
import pedro.projeto.clonenetflix.OnClick.OnItemClickListener
import pedro.projeto.clonenetflix.OnClick.addOnItemClickListener
import java.text.Normalizer

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding:ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycle_filmes = binding.recycleview
        recycle_filmes.adapter = FilmesAdapter(addFilmes())
        recycle_filmes.layoutManager = GridLayoutManager(applicationContext,3)

        recycle_filmes.addOnItemClickListener(object : OnItemClickListener{
            override fun onItemClicked(position: Int, view: View) {
                when{
                    position == 0 -> DetalhesFilme()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deslogar -> {
                FirebaseAuth.getInstance().signOut()
                IrParaLogin()
            }
        }
        return super.onOptionsItemSelected(item)
    }

   private fun IrParaLogin(){
        val intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
       finish()
   }

    private fun DetalhesFilme(){
        val intent = Intent(this,DetalhesFilme::class.java)
        startActivity(intent)

    }
}