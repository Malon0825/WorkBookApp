package com.example.workbookapp

import android.content.Context
import android.media.MediaPlayer

class VoiceHelper(private val context: Context) {

    private val correctSounds = listOf(
        MediaPlayer.create(context, R.raw.correct_one),
        MediaPlayer.create(context, R.raw.correct_two),
        MediaPlayer.create(context, R.raw.correct_three),
        MediaPlayer.create(context, R.raw.correct_four)
    )
    private val wrongSounds = listOf(
        MediaPlayer.create(context, R.raw.wrong_one),
        MediaPlayer.create(context, R.raw.wrong_two),
        MediaPlayer.create(context, R.raw.wrong_three),

        //Excluded by user request
        //MediaPlayer.create(context, R.raw.wrong_four)
    )

    fun playSound(correct: Boolean) {
        val soundList = if (correct) correctSounds else wrongSounds
        val randomIndex = (soundList.indices).random()
        soundList[randomIndex]?.start()
    }
}