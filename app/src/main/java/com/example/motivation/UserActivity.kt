package com.example.motivation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSavedButton()
        }

    }

    private fun handleSavedButton() {
        val name = binding.editName.text.toString()
        if (name != "") {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }


    }
}