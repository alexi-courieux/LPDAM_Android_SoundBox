package fr.iutnice.courieux.soundbox.sound

class SoundList : ArrayList<Sound>() {
    fun getSoundsWithCategory(category: SoundCategory): List<Sound> {
        var sounds = SoundList()
        for(sound in this){
            if(sound.category == category)
                sounds.add(sound)
        }
        return sounds
    }
}