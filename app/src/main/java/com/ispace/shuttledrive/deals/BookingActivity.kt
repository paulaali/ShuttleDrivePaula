package com.ispace.shuttledrive.deals

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ispace.shuttledrive.R
import com.ispace.shuttledrive.databinding.ActivityBookingBinding
import java.text.SimpleDateFormat
import java.util.*

class BookingActivity : AppCompatActivity() {
    private lateinit var tvJourneyDate: TextView
    private lateinit var binding:ActivityBookingBinding 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tvJourneyDate = findViewById(R.id.tv_journey_date)

        val intent = getIntent();
        val i_shuttleImg = intent.getIntExtra("shuttleimg",0)
        val i_name = intent.getStringExtra("name")
        val i_fare  = intent.getStringExtra("fare")
        val i_type = intent.getStringExtra("type")

        binding.name.text = i_name
        binding.fare.text = i_fare
        binding.type.text = i_type
        binding.shuttleImg.setImageResource(i_shuttleImg)

        val myCalendar = Calendar.getInstance()

        val datePickerJ = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateJourney(myCalendar)
        }

        //listener for date button
        binding.journeyDate.setOnClickListener{
            DatePickerDialog(this, datePickerJ, myCalendar.get(Calendar.YEAR), myCalendar.get(
                Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updateJourney(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvJourneyDate.setText(sdf.format(myCalendar.time))
    }
}