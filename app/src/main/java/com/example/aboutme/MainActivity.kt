package com.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickName(it)
        }
    }

    @SuppressLint("ServiceCast")
    private fun addNickName(view: View) {
        val editView = findViewById<EditText>(R.id.nickname_edit)
        val showView = findViewById<TextView>(R.id.nickname_text)
        showView.text = editView.text
        editView.visibility = View.GONE
        view.visibility = View.GONE
        showView.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
