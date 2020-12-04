package com.example.iotapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.overview_fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview_fragment)

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef = database.getReference()
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val temp = dataSnapshot.child("Temperature").getValue().toString()
                val humi = dataSnapshot.child("Humidity").getValue().toString()
                val moisture = dataSnapshot.child("Soil Moisture").getValue().toString()
                temp_text.text = temp
                humi_text.text = humi
                moisture_text.text = moisture

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
       // temp_text.text = temp




    }
}