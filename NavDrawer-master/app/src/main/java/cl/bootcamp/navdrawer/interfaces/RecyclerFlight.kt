package cl.bootcamp.navdrawer.interfaces

import cl.bootcamp.navdrawer.models.Flight

interface RecyclerFlight {

    fun onClick(flight: Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)

}