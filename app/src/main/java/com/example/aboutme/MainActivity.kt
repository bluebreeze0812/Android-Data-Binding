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
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    data class MyName(var name: String = "", var nickName: String = "")

    private val myName = MyName("Leo Wang")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    @SuppressLint("ServiceCast")
    private fun addNickName(view: View) {
        binding.apply {
            val editView = binding.nicknameEdit
            myName?.nickName = editView.text.toString()
            invalidateAll()
            val showView = binding.nicknameText
            showView.text = editView.text
            editView.visibility = View.GONE
            view.visibility = View.GONE
            showView.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
