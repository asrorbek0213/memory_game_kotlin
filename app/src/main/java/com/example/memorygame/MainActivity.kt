
package com.example.memorygame

import android.annotation.SuppressLint
import android.os.Bundle
//import android.os.Bundle
//import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val listImageOchiqYopiq = arrayOf(false, false, false, false, false, false, false, false, false, false, false, false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    var animationDoing = false

    lateinit var image_1: ImageView
    lateinit var image_2: ImageView
    lateinit var image_3: ImageView
    lateinit var image_4: ImageView
    lateinit var image_5: ImageView
    lateinit var image_6: ImageView
    lateinit var image_7: ImageView
    lateinit var image_8: ImageView
    lateinit var image_9: ImageView
    lateinit var image_10: ImageView
    lateinit var image_11: ImageView
    lateinit var image_12: ImageView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_1 = findViewById(R.id.image_1)
        image_2 = findViewById(R.id.image_2)
        image_3 = findViewById(R.id.image_3)
        image_4 = findViewById(R.id.image_4)
        image_5 = findViewById(R.id.image_5)
        image_6 = findViewById(R.id.image_6)
        image_7 = findViewById(R.id.image_7)
        image_8 = findViewById(R.id.image_8)
        image_9 = findViewById(R.id.image_9)
        image_10 = findViewById(R.id.image_10)
        image_11 = findViewById(R.id.image_11)
        image_12 = findViewById(R.id.image_12)

        image_1.setOnClickListener {
            imageClick(image_1, R.drawable.rasm_2, 0)
        }

        image_2.setOnClickListener {
            imageClick(image_2, R.drawable.rasm_10, 1)
        }

        image_3.setOnClickListener {
            imageClick(image_3, R.drawable.rasm_4, 2)
        }

        image_4.setOnClickListener {
            imageClick(image_4, R.drawable.rasm_8, 3)
        }

        image_5.setOnClickListener {
            imageClick(image_5, R.drawable.rasm_12, 4)
        }

        image_6.setOnClickListener {
            imageClick(image_6, R.drawable.rasm_6, 5)
        }

        image_7.setOnClickListener {
            imageClick(image_7, R.drawable.rasm_8, 6)
        }

        image_8.setOnClickListener {
            imageClick(image_8, R.drawable.rasm_4, 7)
        }

        image_9.setOnClickListener {
            imageClick(image_9, R.drawable.rasm_10, 8)
        }

        image_10.setOnClickListener {
            imageClick(image_10, R.drawable.rasm_2, 9)
        }

        image_11.setOnClickListener {
            imageClick(image_11, R.drawable.rasm_12, 10)
        }

        image_12.setOnClickListener {
            imageClick(image_12, R.drawable.rasm_6, 11)
        }

    }

    fun imageClick(imageView: ImageView, rasm: Int, index: Int) {
        if (!animationDoing){
            if (listImageOchiqYopiq[index] == false) {
                animationOchilish(imageView, rasm, index)
            } else {
                animationYopilishi(imageView, rasm, index)
            }
        }
    }

    fun animationOchilish(imageView: ImageView, rasm: Int, index: Int) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                animationDoing = true
            }


            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(rasm)
                animation2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        listImageOchiqYopiq[index] = true
                        imageIndex[ochiqRasm] = index
                        rasmId[ochiqRasm] = rasm
                        ochiqRasm++

                        if(ochiqRasm == 2){
                            if (rasmId[0] == rasmId[1]){
                                imaegViewAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                ochiqRasm--
                                imaegViewAniqla(imageIndex[1]).visibility = View.INVISIBLE
                                ochiqRasm--
                            }else{
                                animationYopilishi(imaegViewAniqla(imageIndex[0]),-1, imageIndex[0])
                                animationYopilishi(imaegViewAniqla(imageIndex[1]),-1, imageIndex[1])
                            }
                        }
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })


    }

    fun animationYopilishi(imageView: ImageView, rasm: Int, index: Int?) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                animationDoing = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.rasm_1)
                animation2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        listImageOchiqYopiq[index!!] = false
        ochiqRasm--
    }

    fun imaegViewAniqla(index: Int?): ImageView {
        var imageView :ImageView? = null
        when(index){
            0 -> imageView = image_1
            1 -> imageView = image_2
            2 -> imageView = image_3
            3 -> imageView = image_4
            4 -> imageView = image_5
            5 -> imageView = image_6
            6 -> imageView = image_7
            7 -> imageView = image_8
            8 -> imageView = image_9
            9 -> imageView = image_10
            10 -> imageView = image_11
            11 -> imageView = image_12

        }
        return imageView!!
    }

}