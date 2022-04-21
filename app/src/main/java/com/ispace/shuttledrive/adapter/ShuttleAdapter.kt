package com.ispace.shuttledrive.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ispace.shuttledrive.R
import com.ispace.shuttledrive.data.ShuttleData

class ShuttleAdapter(
    private val context: Context,
    private val BookingList:ArrayList<ShuttleData>,
    private val handleShuttleClick: HandleShuttleClick
): RecyclerView.Adapter<ShuttleAdapter.ShuttleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShuttleViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.deals_list_item,parent,false)
        return ShuttleViewHolder(rootView)
    }
    interface HandleShuttleClick{
        fun onShuttleClick(position: Int)
    }

    override fun onBindViewHolder(holder: ShuttleViewHolder, position: Int) {
        val dataPosition = BookingList[position]

        holder.name.text = dataPosition.name
        holder.fare.text = dataPosition.fare
        holder.type.text = dataPosition.AC

        holder.learnersClick.setOnClickListener{
            handleShuttleClick.onShuttleClick(position)
        }

        Glide
            .with(context)
            .load(dataPosition.img)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imgUrl);
    }

    override fun getItemCount(): Int {
        return BookingList.size
    }

    class ShuttleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.listName)
        val imgUrl: ImageView = itemView.findViewById(R.id.shuttleItemImg)
        val fare: TextView = itemView.findViewById(R.id.listfare)
        val type: TextView = itemView.findViewById(R.id.listType)
        val learnersClick: CardView = itemView.findViewById(R.id.booking_item)
    }

}