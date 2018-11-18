package fr.iutnice.courieux.soundbox.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iutnice.courieux.soundbox.MainActivity
import fr.iutnice.courieux.soundbox.R
import fr.iutnice.courieux.soundbox.adapter.SoundAdapter
import fr.iutnice.courieux.soundbox.sound.SoundCategory
import fr.iutnice.courieux.soundbox.sound.SoundList
import kotlinx.android.synthetic.main.fragment_category_animal.*

class FragmentCategoryAnimal : Fragment() {
    companion object {
        fun newInstance() = FragmentCategoryAnimal()
    }

    var soundList: SoundList = MainActivity.instance!!.soundList.getSoundsWithCategory(SoundCategory.ANIMAL)

    /**This method is automatically executed when activity is fully loaded*/
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoryAnimalImageButtonHome.setOnClickListener {
            (activity as MainActivity).replaceFragment(FragmentHome.newInstance())
        }
        gridViewAnimal.adapter = SoundAdapter(soundList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_animal, container, false)
    }
}