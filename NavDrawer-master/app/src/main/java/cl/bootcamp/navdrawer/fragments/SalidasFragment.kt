package cl.bootcamp.navdrawer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.bootcamp.navdrawer.R
import cl.bootcamp.navdrawer.adapters.RecyclerFlightAdapter
import cl.bootcamp.navdrawer.databinding.FragmentSalidasBinding
import cl.bootcamp.navdrawer.interfaces.RecyclerFlight
import cl.bootcamp.navdrawer.models.Flight
import cl.bootcamp.navdrawer.providers.FlightProvider
import java.text.FieldPosition


class SalidasFragment : Fragment() {


    private lateinit var binding: FragmentSalidasBinding
    private lateinit var recyclerFlight: RecyclerView
    private val layoutManager by lazy {LinearLayoutManager(context)}
    private val listOfCities by lazy {getFligthsFromProvider()}
    private lateinit var adapterFlight: RecyclerFlightAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.setTitle("Salidas disponibles")
        binding = FragmentSalidasBinding.inflate(inflater, container,false)
        recyclerFlight = binding.recyclerSalidas

        setRecyclerView()

        return binding.root
    }

    private fun setRecyclerView() {
        recyclerFlight.setHasFixedSize(true)
        recyclerFlight.itemAnimator = DefaultItemAnimator()
        recyclerFlight.layoutManager = layoutManager
        adapterFlight = (RecyclerFlightAdapter(listOfCities, object :RecyclerFlight{
            override fun onClick(flight: Flight, position: Int){
                Toast.makeText(activity, "Nos vamos a ${flight.ciudad}", Toast.LENGTH_LONG).show()
            }

            override fun onDelete(flight: Flight, position: Int) {
               listOfCities.removeAt(position)
                adapterFlight.notifyItemChanged(position)
            }
        }))

        adapterFlight.notifyDataSetChanged()
        recyclerFlight.adapter = adapterFlight
    }
    private fun getFligthsFromProvider(): MutableList<Flight>{
        var listFlights = FlightProvider.listCitiesForFlight
        return  listFlights
    }


}