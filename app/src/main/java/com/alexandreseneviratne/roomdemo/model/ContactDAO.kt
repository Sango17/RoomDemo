package com.alexandreseneviratne.roomdemo.model

import androidx.room.*
import com.alexandreseneviratne.roomdemo.model.entity.Contact

/**
 * Created by Alexandre SENEVIRATNE on 5/31/2019.
 */
@Dao
interface ContactDAO {
    @Insert
    fun addContact(contact: Contact): Long

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getContacts(): List<Contact>

    @Query("SELECT * FROM contacts WHERE contact_id == :contactId")
    fun getContact(contactId: Long): Contact
}