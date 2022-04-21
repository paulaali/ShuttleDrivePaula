package com.ispace.shuttledrive.deals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ispace.shuttledrive.R
import com.ispace.shuttledrive.adapter.ShuttleAdapter
import com.ispace.shuttledrive.data.ShuttleData
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg1
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg2
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg3

class HotdealsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotdeals)

        recyclerView = findViewById(R.id.recViewh)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dealList = ArrayList<ShuttleData>()

        dealList.add(
            ShuttleData("Shuttle 01","From","To","Date","Fare: GHc 800.00",
                "Time: 10am",0,0,false,false,"Type: Non-AC",shuttleimg)
        )
        dealList.add(
            ShuttleData("Shuttle 02","From","To","Date","Fare: GHc 1000.00",
                "Time: 10am",0,0,false,false,"Type: AC",shuttleimg1)
        )
        dealList.add(
            ShuttleData("Shuttle 03","From","To","Date","Fare: GHc 900.00",
                "Time: 10am",0,0,false,false,"Type: Non-AC",shuttleimg2)
        )
        dealList.add(
            ShuttleData("Shuttle 04","From","To","Date","Fare: GHc 1100.00",
                "Time: 10am",0,0,false,false,"Type: AC",shuttleimg3)
        )

        val adapterh = ShuttleAdapter(this,dealList, object : ShuttleAdapter.HandleShuttleClick {
            override fun onShuttleClick(position: Int) {
                val shuttle = dealList[position]
                val name:String = shuttle.name
                val fromLoc: String = shuttle.fromLoc
                val toLoc: String = shuttle.toLoc
                val date :String = shuttle.date
                val time :String = shuttle.time
                val fare :String = shuttle.fare
                val type :String = shuttle.AC
                val shuttleImg: Int = shuttle.img


                val intent = Intent(this@HotdealsActivity, BookingActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("fromLoc",fromLoc)
                intent.putExtra("toLoc",toLoc)
                intent.putExtra("date",date)
                intent.putExtra("time",time)
                intent.putExtra("fare",fare)
                intent.putExtra("type",type)
                intent.putExtra("shuttleimg",shuttleImg)
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapterh
    }
}