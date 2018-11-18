package fr.iutnice.courieux.soundbox.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iutnice.courieux.soundbox.MainActivity
import fr.iutnice.courieux.soundbox.R
import kotlinx.android.synthetic.main.fragment_category_jingle.*

class FragmentCategoryJingle : Fragment() {
    companion object {
        fun newInstance() = FragmentCategoryJingle()
    }

    /**This method is automatically executed when activity is fully loaded*/
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoryJingleImageButtonHome.setOnClickListener {
            (activity as MainActivity).replaceFragment(FragmentHome.newInstance())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_jingle, container, false)
    }
}