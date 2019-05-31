package com.alexandreseneviratne.roomdemo.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.alexandreseneviratne.roomdemo.R

class AddContactDialogFragment: DialogFragment() {
    interface AddContactListener {
        fun onPositiveListener()
        fun onNegativeListener()
    }

    var listener: AddContactListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater

        builder.setTitle("Add contact")
            .setView(inflater?.inflate(R.layout.add_contact_item,null))
            .setNegativeButton("Cancel") { _, _ ->
                listener?.onNegativeListener()
            }
            .setPositiveButton("Add") {_, _ ->
                listener?.onPositiveListener()
            }

        return builder.create()
    }
}