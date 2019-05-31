package com.alexandreseneviratne.roomdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexandreseneviratne.roomdemo.R
import com.alexandreseneviratne.roomdemo.model.entity.Contact

class ContactAdapter(private val contactList: MutableList<Contact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_contact, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactList[position]

        holder.name.text = contact.name
        holder.email.text = contact.email
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.contact_name)
        val email: TextView = itemView.findViewById(R.id.contact_email)
    }

}