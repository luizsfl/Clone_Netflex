package pedro.projeto.clonenetflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import pedro.projeto.clonenetflex.R
import pedro.projeto.clonenetflex.databinding.ActivityFormLoginBinding
import pedro.projeto.clonenetflex.databinding.ActivityListaFilmesBinding
import java.text.Normalizer

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding:ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)



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
}