package fr.iutnice.courieux.soundbox.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iutnice.courieux.soundbox.MainActivity
import fr.iutnice.courieux.soundbox.R
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment() {
    companion object {
        fun newInstance() = FragmentHome()
    }

    /**This method is automatically executed when activity is fully loaded*/
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_animal.setOnClickListener {
            (activity as MainActivity).replaceFragment(FragmentCategoryAnimal.newInstance())
        }
        button_ambiance.setOnClickListener {
            (activity as MainActivity).replaceFragment(FragmentCategoryAmbiance.newInstance())
        }
        button_jingle.setOnClickListener {
            (activity as MainActivity).replaceFragment(FragmentCategoryJingle.newInstance())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}