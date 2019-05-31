package com.alexandreseneviratne.roomdemo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexandreseneviratne.roomdemo.adapter.ContactAdapter
import com.alexandreseneviratne.roomdemo.fragment.AddContactDialogFragment
import com.alexandreseneviratne.roomdemo.model.Contact

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ContactAdapter
    private lateinit var contacts: MutableList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        contacts = mutableListOf()
        contacts.add(0, Contact("Alex", "alex@gmail.com"))

        adapter = ContactAdapter(contacts)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        adapter.notifyDataSetChanged()

        fab.setOnClickListener {
            showAddContactDialog()
        }
    }

    private fun showAddContactDialog() {
        val dialogFragment = AddContactDialogFragment()
        dialogFragment.listener = object : AddContactDialogFragment.AddContactListener {
            override fun onPositiveListener() {
                Toast.makeText(applicationContext, "Add", Toast.LENGTH_SHORT).show()
            }
            override fun onNegativeListener() {
                return
            }
        }
        dialogFragment.show(supportFragmentManager,"addContact")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
