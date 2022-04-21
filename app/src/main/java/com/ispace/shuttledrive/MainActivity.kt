package com.ispace.shuttledrive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ispace.shuttledrive.auth.ProfileActivity
import com.ispace.shuttledrive.databinding.ActivityMainBinding
import com.ispace.shuttledrive.deals.CarsActivity
import com.ispace.shuttledrive.deals.HotdealsActivity
import com.ispace.shuttledrive.deals.ValsActivity
import com.ispace.shuttledrive.deals.XmasActivity

class MainActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)

        //drawer toggle
        toggle = ActionBarDrawerToggle(this,binding.drawerLay,toolbar,R.string.openDrawer,R.string.closeDrawer)
        binding.drawerLay.addDrawerListener(toggle)
        toggle.syncState()

        //handle deals clicks
        binding.bus.setOnClickListener{
            startActivity(Intent(this, HotdealsActivity::class.java))
        }
        binding.vals.setOnClickListener{
            startActivity(Intent(this,ValsActivity::class.java))
        }
        binding.carDeal.setOnClickListener{
            startActivity(Intent(this, CarsActivity::class.java))
        }
        binding.xmas.setOnClickListener{
            startActivity(Intent(this, XmasActivity::class.java))
        }

//switching activity with drawer
        binding.navView.setNavigationItemSelectedListener {
            it.isChecked = true

            when(it.itemId){

  //              R.id.home-> {val intent = Intent(this, MainActivity::class.java)
    //                startActivity(intent)}
                /*R.id.ticket-> {val intent = Intent(this, TicketActivity::class.java)
                    startActivity(intent)}
                R.id.about-> {val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)}
                R.id.cart-> {val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)}
                */
                R.id.profile-> {val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)}
            }

            true
        }
    }
}