package com.alexandreseneviratne.roomdemo.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexandreseneviratne.roomdemo.model.entity.Contact

/**
 * Created by Alexandre SENEVIRATNE on 5/31/2019.
 */
@Database(entities = [Contact::class], version = 1)
abstract class ContactAppDatabase: RoomDatabase() {
    abstract fun getContactDao(): ContactDAO
}