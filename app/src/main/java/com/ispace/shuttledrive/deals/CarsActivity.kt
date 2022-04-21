package com.ispace.shuttledrive.deals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ispace.shuttledrive.R
import com.ispace.shuttledrive.adapter.ShuttleAdapter
import com.ispace.shuttledrive.data.ShuttleData
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg4
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg5
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg6
import com.ispace.shuttledrive.utils.ShuttleImg.shuttleimg7

class CarsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)

        recyclerView = findViewById(R.id.recViewc)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val carList = ArrayList<ShuttleData>()

        carList.add(
            ShuttleData("Shuttle 01","From","To","Date","Fare: GHc 800.00",
                "Time: 10am",0,0,false,false,"Type: Non-AC", shuttleimg4)
        )
        carList.add(
            ShuttleData("Shuttle 02","From","To","Date","Fare: GHc 1000.00",
                "Time: 10am",0,0,false,false,"Type: AC", shuttleimg5)
        )
        carList.add(
            ShuttleData("Shuttle 03","From","To","Date","Fare: GHc 900.00",
                "Time: 10am",0,0,false,false,"Type: Non-AC", shuttleimg6)
        )
        carList.add(
            ShuttleData("Shuttle 04","From","To","Date","Fare: GHc 1100.00",
                "Time: 10am",0,0,false,false,"Type: AC", shuttleimg7)
        )

        val adapterc = ShuttleAdapter(this,carList, object : ShuttleAdapter.HandleShuttleClick {
            override fun onShuttleClick(position: Int) {
                val shuttle = carList[position]
                val name:String = shuttle.name
                val fromLoc: String = shuttle.fromLoc
                val toLoc: String = shuttle.toLoc
                val date :String = shuttle.date
                val time :String = shuttle.time
                val fare :String = shuttle.fare
                val type :String = shuttle.AC
                val shuttleImg: Int = shuttle.img


                val intent = Intent(this@CarsActivity, BookingActivity::class.java)
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

        recyclerView.adapter = adapterc
    }
}