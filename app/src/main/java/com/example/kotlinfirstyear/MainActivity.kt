package com.example.kotlinfirstyear

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {
    lateinit private var button: Button
    lateinit private var button2: Button
    lateinit private var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        imageView = findViewById(R.id.imageView)
        var mp = MediaPlayer.create(applicationContext, R.raw.dice)
        button.setOnClickListener{
            mp.start()
            imageView.setImageDrawable(resources.getDrawable(R.drawable.dice_random))
            Timer().schedule(1000){
                val random = (1..6).random()
//          First Method
                val st: String = "dice_${random}"
                val id = resources.getIdentifier(st, "drawable", packageName)
                imageView.setImageDrawable(resources.getDrawable(id))
                //Second Method

//        val drawable=when(random){
//                1->R.drawable.dice_1
//                2->R.drawable.dice_2
//                3->R.drawable.dice_3
//                4->R.drawable.dice_4
//                5->R.drawable.dice_5
//                6->R.drawable.dice_6
//                else->R.drawable.dice_random
//        }
//            imageView.setImageDrawable(resources.getDrawable(drawable))    //calls this function after delay
            }

        }
        button2.setOnClickListener() {
            mp.start()
            Timer().schedule(1000) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.dice_random))
            }
        }
    }
}