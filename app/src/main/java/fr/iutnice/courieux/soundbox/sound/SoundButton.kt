package fr.iutnice.courieux.soundbox.sound

import android.widget.Button
import fr.iutnice.courieux.soundbox.MainActivity

class SoundButton(val sound:Sound) : Button(MainActivity.instance) {
    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        sound.play()
    }
}