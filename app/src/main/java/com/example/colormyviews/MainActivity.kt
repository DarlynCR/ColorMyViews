package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setListeners()

    }

    private fun makeColored(view : View){

        when(view.id){
            binding.tvBoxOne.id -> view.setBackgroundColor(Color.DKGRAY)
            binding.tvBoxTwo.id -> view.setBackgroundColor(Color.GRAY)
            binding.tvBoxThree.id -> view.setBackgroundColor(Color.BLUE)
            binding.tvBoxFour.id -> view.setBackgroundColor(Color.MAGENTA)
            binding.tvBoxFive.id -> view.setBackgroundColor(Color.BLUE)
            binding.btnRed.id -> binding.tvBoxThree.setBackgroundResource(R.color.my_red)
            binding.btnYellow.id -> binding.tvBoxFour.setBackgroundResource(R.color.my_yellow)
            binding.btnGreen.id -> binding.tvBoxFive.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }

    }

    private fun setListeners(){

        val boxOneText = binding.tvBoxOne
        val boxTwoText = binding.tvBoxTwo
        val boxThreeText = binding.tvBoxThree
        val boxFourText = binding.tvBoxFour
        val boxFiveText = binding.tvBoxFive

        //botones
        val redButton = binding.btnRed
        val greenButton = binding.btnGreen
        val yellowButton = binding.btnYellow

        val rootConstraintLayout = binding.clConstraintLayout

        //Se agregan las vistas clickeables
        val clickableViews : List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText,
            boxFiveText, rootConstraintLayout, redButton, greenButton, yellowButton)

        //Se configura el listener para cada view
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}