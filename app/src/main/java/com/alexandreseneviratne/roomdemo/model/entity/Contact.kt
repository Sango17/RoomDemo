package com.alexandreseneviratne.roomdemo.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Alexandre SENEVIRATNE on 5/31/2019.
 */

@Entity(tableName = "contacts")
class Contact(
    @PrimaryKey
    @ColumnInfo(name = "contact_id")
    val id: Long,

    @ColumnInfo(name = "contact_name")
    val name: String,

    @ColumnInfo(name = "contact_email")
    val email: String
)