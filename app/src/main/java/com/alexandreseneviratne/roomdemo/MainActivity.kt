package com.alexandreseneviratne.roomdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Database
import androidx.room.Room
import com.alexandreseneviratne.roomdemo.adapter.ContactAdapter
import com.alexandreseneviratne.roomdemo.fragment.AddContactDialogFragment
import com.alexandreseneviratne.roomdemo.model.ContactAppDatabase
import com.alexandreseneviratne.roomdemo.model.entity.Contact

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_contact_item.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ContactAdapter
    private lateinit var contacts: MutableList<Contact>
    private lateinit var contactAppDatabase: ContactAppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        contactAppDatabase = Room.databaseBuilder(applicationContext, ContactAppDatabase::class.java, "ContactDB")
            .allowMainThreadQueries()
            .build()

        contacts = mutableListOf()
        contacts.addAll(contactAppDatabase.getContactDao().getContacts())

        adapter = ContactAdapter(contacts)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.itemAnimator = DefaultItemAnimator()
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
                createContact("Test", "Alex")
            }
            override fun onNegativeListener() {
                return
            }
        }
        dialogFragment.show(supportFragmentManager,"addContact")
    }

    private fun createContact(name: String, email: String) {
        val id: Long = contactAppDatabase.getContactDao().addContact(Contact(0, name, email))
        val contact: Contact = contactAppDatabase.getContactDao().getContact(id)
        contacts.add(0, contact)
        adapter.notifyDataSetChanged()
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
