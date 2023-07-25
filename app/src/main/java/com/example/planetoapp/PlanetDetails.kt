package com.example.planetoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent

class PlanetDetails : AppCompatActivity() {
    private lateinit var obj:PlanetData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)
        var plannetImg:Int?=null

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )


        obj=intent.getParcelableExtra("planet")!!
        plannetImg=intent.getIntExtra("planetImage",-1)
        setData(obj, plannetImg!!)

        val buttonInfo=findViewById<TextView>(R.id.button_info)
        buttonInfo.setOnClickListener{
            val intent= Intent(this,FinalActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setData(obj:PlanetData,planetImg:Int){

        val titleInfo:TextView=findViewById(R.id.title_info)
        val distanceInfo:TextView=findViewById(R.id.distance_info)
        val gravityInfo:TextView=findViewById(R.id.gravity_info)
        val overViewInfo:TextView=findViewById(R.id.overView_Info)
        val imageInfo:ImageView=findViewById(R.id.planetInfo)
        val galaxyInfo:TextView=findViewById(R.id.galaxy_info)
        val knowMore:TextView=findViewById(R.id.knowMore)
        knowMore.setOnClickListener{
            openApp()
        }


        titleInfo.text=obj.title
        distanceInfo.text=obj.distance+" m km"
        gravityInfo.text=obj.gravity+" m/ss"
        overViewInfo.text=obj.overView
        galaxyInfo.text=obj.galaxy
        imageInfo.setImageResource(planetImg)


    }

    private fun openApp() {
        val titleInfo:TextView=findViewById(R.id.title_info)
        val customTabsIntent= CustomTabsIntent.Builder().build()
//        customTabsIntent.launchUrl(this, Uri.parse(articleUrl))
        if(titleInfo.text=="Earth"){
            val url="https://solarsystem.nasa.gov/planets/mars/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }
        else if(titleInfo.text=="Mars"){
            val url="https://solarsystem.nasa.gov/planets/mars/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Jupiter"){
            val url="https://solarsystem.nasa.gov/planets/jupiter/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Mercury"){
            val url="https://solarsystem.nasa.gov/planets/mercury/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Moon"){
            val url="https://solarsystem.nasa.gov/planets/moon/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Neptune"){
            val url="https://solarsystem.nasa.gov/planets/neptune/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Saturn"){
            val url="https://solarsystem.nasa.gov/planets/saturn/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Sun"){
            val url="https://solarsystem.nasa.gov/planets/sun/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Venus"){
            val url="https://solarsystem.nasa.gov/planets/venus/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }else if(titleInfo.text=="Uranus"){
            val url="https://solarsystem.nasa.gov/planets/uranus/overview/"
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }


    }
}