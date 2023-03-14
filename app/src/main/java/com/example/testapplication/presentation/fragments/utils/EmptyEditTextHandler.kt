package com.example.testapplication.presentation.fragments.utils

import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

object EmptyEditTextHandler {
    /**
     Making textViewError 'gone' and returns 'true' when editText.text isn't empty.
     Making textViewError 'visible' and returns 'false' when editText.text is empty.
     */
    fun handleEmptyText(editText: TextInputEditText, textViewError: TextView): Boolean {
        if (!TextUtils.isEmpty(editText.text)) {
            if (textViewError.visibility == View.VISIBLE)
                textViewError.visibility = View.GONE
            return true
        }
        textViewError.visibility = View.VISIBLE
        return false
    }
}