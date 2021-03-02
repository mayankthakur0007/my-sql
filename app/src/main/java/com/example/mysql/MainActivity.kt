package com.example.mysql

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mysql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this
        var db = DataBase(context)
        binding.btnInsert.setOnClickListener {
            if (binding.etvName.text.toString().isNotEmpty() &&
                    binding.etvAge.text.toString().isNotEmpty()) {
                var user = User(binding.etvName.text.toString(), binding.etvAge.text.toString().toInt())
                db.insertData(user)
            } else {
                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRead.setOnClickListener {
            var data = db.readData()
            binding.tvResult.text = ""
            for (i in 0 until data.size) {
                binding.tvResult.append(data.get(i).id.toString() + " " + data.get(i).name + " " + data.get(i).age + "\n")
            }
        }

        binding.btnUpdate.setOnClickListener {
            db.updateData()
            binding.btnRead.performClick()
        }

        binding.btnDelete.setOnClickListener {
            db.deleteData()
            binding.btnRead.performClick()
        }
    }
    }
