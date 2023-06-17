package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnFirst: Button
    private lateinit var btnSecond: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        btnFirst = findViewById(R.id.btnFragment1)
        btnSecond = findViewById(R.id.btnFragment2)



        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,firstFragment)  // it will automatically call the first fragment when app runs and displays on screen
            commit()
        }

        // yar yahan sochna wali bat ya ka jab ma na supportFragmentManager ko call kia to tab hi ma na usa flFragment ki id pass
        // kar di ha is waja sa ab jab app chala gi to sab sa pehla yahi firstFragment chala ga i mean firstFragment wali class


        btnFirst.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,firstFragment)  // it will automatically call the first fragment when app runs and displays on screen
                addToBackStack(null)        // if we don't do this then if we click back from fragment 2 instead of going back to fragment 1 then app will close
                commit()
            }
        }

        btnSecond.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,secondFragment)  // it will automatically call the first fragment when app runs and displays on screen
                addToBackStack(null)
                commit()
            }
        }


        //yad raha ka fragments do kism ka hota han aik static aur dosra dynamic
        // static bnana ka liya simple step ha XML ma ja ka aik fragment bnaye ga FrameLayout ko hata ka aur wahan   name=...fragment ka name pass karan ga
        // dynamic bnana ka liya above steps han
    }
}