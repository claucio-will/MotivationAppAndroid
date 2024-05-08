package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.infra.Constantes
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()


    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSaveButton()
        }

    }

    private fun handleSaveButton() {
        val name = binding.editName.text.toString()
        if (name != "") {
            val intent = Intent(this, MainActivity::class.java)

            SecurityPreferences(this).storeString(Constantes.KEY.USER_NAME, name)

            //intent.putExtra("name", name)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }

    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(Constantes.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}