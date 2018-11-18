package fr.iutnice.courieux.soundbox.sound

import android.media.MediaPlayer
import fr.iutnice.courieux.soundbox.MainActivity

enum class SoundCategory {
    ANIMAL, AMBIANCE, JINGLE
}

class Sound(var name: String, var category: SoundCategory, audioFile: Int) {
    var mediaPlayer = MediaPlayer.create(MainActivity.instance, audioFile)
    fun play(){
        mediaPlayer.start()
    }
}