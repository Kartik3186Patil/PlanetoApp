package com.example.planetoapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(var planet:List<PlanetData>):RecyclerView.Adapter<Adapter.myViewHolder>() {
    class myViewHolder(view: View) :RecyclerView.ViewHolder(view){
         val planetTitle:TextView=view.findViewById(R.id.title)
         val planetImg:ImageView=view.findViewById(R.id.planet_img)
         val planetDistance:TextView=view.findViewById(R.id.distance)
         val planetGalaxy:TextView=view.findViewById(R.id.galaxy)
         val planetGravity:TextView=view.findViewById(R.id.gravity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage:Int?=null
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,PlanetDetails::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }

       holder.planetTitle.text=planet[position].title
       holder.planetGalaxy.text=planet[position].galaxy
       holder.planetGravity.text=planet[position].gravity+" m/ss"
       holder.planetDistance.text= "${planet[position].distance} m km"

        when(planet[position].title!!.toLowerCase()){
            "mars"->{
                dummyImage=R.drawable.mars
            }"neptune"->{
                dummyImage=R.drawable.neptune
            }"earth"->{
                dummyImage=R.drawable.earth
            }"jupiter"->{
                dummyImage=R.drawable.jupiter
            }"mercury"->{
                dummyImage=R.drawable.mercury
            }"moon"->{
                dummyImage=R.drawable.moon
            }"saturn"->{
                dummyImage=R.drawable.saturn
            }"sun"->{
                dummyImage=R.drawable.sun
            }"uranus"->{
                dummyImage=R.drawable.uranus
            }"venus"->{
                dummyImage=R.drawable.venus
            }

        }
        holder.planetImg.setImageResource(dummyImage!!)


    }
}
