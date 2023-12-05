package com.artimanton.vpnfree.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.artimanton.vpnfree.databinding.ServerLayoutBinding
import com.artimanton.vpnfree.models.Server
class ServerListAdapter : RecyclerView.Adapter<ServerListAdapter.MyViewHolder>() {
    private var serverList = ArrayList<Server>()


    inner class MyViewHolder(val binding: ServerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ServerLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return serverList.size
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val server = serverList[position]
        holder.apply {
            binding.countryName.text = server.serverCountry
            binding.serverIcon.setImageURI(server.flagUrl?.toUri())
        }

        @SuppressLint("NotifyDataSetChanged")
        fun cleanData() {
            serverList.clear()
            notifyDataSetChanged()
        }

        @SuppressLint("NotifyDataSetChanged")
        fun setData(newList: ArrayList<Server>) {
            serverList.addAll(newList)
            notifyDataSetChanged()
        }
    }
}