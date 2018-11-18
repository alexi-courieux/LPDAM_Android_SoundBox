package fr.iutnice.courieux.soundbox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import fr.iutnice.courieux.soundbox.MainActivity
import fr.iutnice.courieux.soundbox.R
import fr.iutnice.courieux.soundbox.sound.Sound
import fr.iutnice.courieux.soundbox.sound.SoundList
import kotlinx.android.synthetic.main.sound_entry.view.*

//
//class SoundAdapter(var soundList: SoundList) : BaseAdapter() {
//    var context = MainActivity.instance
//
//}

class SoundAdapter : BaseAdapter {
    var soundList = ArrayList<Sound>()
    var context: Context = MainActivity.instance!!.applicationContext

    constructor(soundList: SoundList) : super() {
        this.soundList = soundList
    }

    override fun getCount(): Int {
        return soundList.size
    }

    override fun getItem(position: Int): Any {
        return soundList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val sound = this.soundList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var soundView = inflator.inflate(R.layout.sound_entry, null)
        soundView.soundButton.text = sound.name
        soundView.soundButton.setOnClickListener {
            sound.play()
        }

        return soundView
    }
}