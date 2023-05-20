package cl.bootcamp.navdrawer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import cl.bootcamp.navdrawer.databinding.ItemFlightLayoutBinding
import cl.bootcamp.navdrawer.interfaces.RecyclerFlight
import cl.bootcamp.navdrawer.models.Flight
import com.squareup.picasso.Picasso

class RecyclerFlightAdapter(
    private val listFlight: List<Flight>,
    private val flightListener: RecyclerFlight
    ) : RecyclerView.Adapter<RecyclerFlightAdapter.ViewHolderFlight>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFlight {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFlightLayoutBinding.inflate(inflater,parent,false)

        return ViewHolderFlight(binding)
    }

    // modo kotlin
    override fun getItemCount(): Int = listFlight.size

    override fun onBindViewHolder(holder: ViewHolderFlight, position: Int) {
        val flight = listFlight[position]
        holder.bind(flight)
    }

    // una clase dentro de otra
    inner class ViewHolderFlight(private val binding: ItemFlightLayoutBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bind(flight: Flight){
                binding.txtCity.text = flight.ciudad

                //acá entra Picasoo
                Picasso.get().load(flight.imagen).fit().into(binding.cityImage)
                binding.root.setOnClickListener{flightListener.onClick(flight,adapterPosition)}
                binding.btnDelete.setOnClickListener{flightListener.onDelete(flight,adapterPosition)}
            }
    }
}

