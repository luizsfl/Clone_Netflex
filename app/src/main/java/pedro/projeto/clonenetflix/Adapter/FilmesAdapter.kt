package pedro.projeto.clonenetflix.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pedro.projeto.clonenetflex.databinding.ActivityListaFilmesBinding
import pedro.projeto.clonenetflex.databinding.ListaFilmesBinding
import pedro.projeto.clonenetflix.Modal.Filmes

class FilmesAdapter(val filmes: MutableList<Filmes>): RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val binding = ListaFilmesBinding.inflate(LayoutInflater.from((parent.context)),parent,false)
        return FilmesViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        with(holder){
            with(filmes[position]){
                binding.capaFilme.setImageResource(capaFilme)
            }
        }
    }

    override fun getItemCount() = filmes.size

    inner class FilmesViewHolder(val binding: ListaFilmesBinding): RecyclerView.ViewHolder(binding.root){

    }

}