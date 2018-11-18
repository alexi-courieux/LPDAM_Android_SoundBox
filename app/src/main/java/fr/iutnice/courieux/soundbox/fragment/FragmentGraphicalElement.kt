package fr.iutnice.courieux.soundbox.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iutnice.courieux.soundbox.R
import kotlinx.android.synthetic.main.fragment_graphical_elem.*

class FragmentGraphicalElement : Fragment(){
    companion object {
        fun newInstance() = FragmentGraphicalElement()
    }

    /**This method is automatically executed when activity is fully loaded*/
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        numberPicker.minValue = 0
        numberPicker.maxValue= 90

        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener{ numberPicker , oldvalue , newValue -> textView_NumberPicker.text = getString(R.string.Value_number_picker) +" "+ numberPicker.value.toString()  }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_graphical_elem, container, false)
    }
}