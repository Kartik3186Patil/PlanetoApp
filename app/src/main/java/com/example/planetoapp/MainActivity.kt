package com.example.planetoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
//    private var isSplashScreenDisplayed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
//        isSplashScreenDisplayed = true
        setContentView(R.layout.activity_main)


        val myRecycler=findViewById<RecyclerView>(R.id.my_recycler)
        myRecycler.adapter=Adapter(setData.SetPlanets())
        myRecycler.layoutManager=LinearLayoutManager(this)



    }

    override fun onBackPressed() {
        finishAffinity()
    }


}