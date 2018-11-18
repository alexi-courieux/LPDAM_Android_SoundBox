package fr.iutnice.courieux.soundbox.sound

import android.provider.MediaStore

enum class SoundCategory {
    ANIMAL, AMBIANCE, JINGLE
}

class Sound(var name: String, var category: SoundCategory, var audio: MediaStore.Audio) {
    fun play(){

    }
}