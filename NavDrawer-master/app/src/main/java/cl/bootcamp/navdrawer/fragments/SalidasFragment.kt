package cl.bootcamp.navdrawer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.bootcamp.navdrawer.R


/**
 * A simple [Fragment] subclass.
 * Use the [SalidasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SalidasFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_salidas, container, false)
    }


}