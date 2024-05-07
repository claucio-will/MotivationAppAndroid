package com.example.motivation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nameUser = intent.getStringExtra("name")
        binding.textHelloUser.text = "Olá $nameUser"
    }

    override fun onClick(view: View) {
       if (view.id == R.id.button_new_phrase){
           Toast.makeText(this, "Button", Toast.LENGTH_SHORT).show()
       }
    }
}