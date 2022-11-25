package com.example.travailafairarecyclerview

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() , MyAdapter.OnItemClickListener{

    private val GovList = mutableListOf(
        Governorate(R.drawable.ariana,  "Ariana"),
        Governorate(R.drawable.beja,  "Béja"),
        Governorate(R.drawable.benarous,  "Ben Arous"),
        Governorate(R.drawable.bizerte,  "Bizerte"),
        Governorate(R.drawable.gabes,  "Gabes"),
        Governorate(R.drawable.gafsa,  "Gafsa"),
        Governorate(R.drawable.jendouba,  "Jendouba"),
        Governorate(R.drawable.kairouan,  "Kairouan"),
        Governorate(R.drawable.kasserine,  "Kasserine"),
        Governorate(R.drawable.kebili,  "Kebili"),
        Governorate(R.drawable.kef,  "Kef"),
        Governorate(R.drawable.mahdia,  "Mahdia"),
        Governorate(R.drawable.manouba,  "Manouba"),
        Governorate(R.drawable.mednine,  "Mednine"),
        Governorate(R.drawable.monastir,  "Monastir"),
        Governorate(R.drawable.nabeul,  "Nabeul"),
        Governorate(R.drawable.sfax,  "Sfax"),
        Governorate(R.drawable.sidibouzid,  "Sidi Bouzid"),
        Governorate(R.drawable.siliana,  "Siliana"),
        Governorate(R.drawable.sousse,  "Sousse"),
        Governorate(R.drawable.tataouine,  "Tataouine"),
        Governorate(R.drawable.tozeur,  "Tozeur"),
        Governorate(R.drawable.tunis,  "Tunis"),
        Governorate(R.drawable.zaghouan,  "Zaghouan"),

    )


    lateinit var mRecyclerView : RecyclerView
    lateinit var myAdapter: MyAdapter
    lateinit var fab: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recyclerview)
        mRecyclerView.layoutManager = GridLayoutManager(this, 1)

        myAdapter = MyAdapter(GovList,this)
        mRecyclerView.adapter = myAdapter

        fab = findViewById(R.id.fab)

        fab.setOnClickListener{
            val sharedPreferences : SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val position : Int = sharedPreferences.getInt("pos", 0)
            delete(position)
        }

    }

     fun delete(position: Int) {
        GovList.removeAt(position)
        myAdapter.notifyDataSetChanged()
    }


    override fun OnItemClick(position: Int) {
        val pos = position
        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs" , Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.apply {
            putInt("pos" , pos)
        }.apply()
        // Toast.makeText(this, "Item " + pos + " clicked" , Toast.LENGTH_LONG).show()
    }



}