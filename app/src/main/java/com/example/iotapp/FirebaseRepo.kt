package com.example.iotapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class FirebaseRepo (){
    var database =  FirebaseDatabase.getInstance()

    val myRef:DatabaseReference = database.getReference()
    private lateinit var tempValueEventListener: ValueEventListener
    private lateinit var humiValueEventListener: ValueEventListener
    private lateinit var moistureValueEventListener: ValueEventListener

    private var temp:MutableLiveData<String> = MutableLiveData()
    private var humi:MutableLiveData<String> = MutableLiveData()
    private var moisture:MutableLiveData<String> = MutableLiveData()


    private fun listenForTempChanges()
    {
        tempValueEventListener = object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val tempValue =snapshot.child("Temperature").getValue().toString()
                    temp.postValue(tempValue)
                }
            }
        }
    }
    private fun listenForHumiChanges()
    {
        humiValueEventListener = object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val tempValue =snapshot.child("Humidity").getValue().toString()
                    humi.postValue(tempValue)
                }
            }
        }
    }

    private fun listenForMoistureChanges()
    {
        tempValueEventListener = object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val tempValue =snapshot.child("Soil Moisture").getValue().toString()
                    moisture.postValue(tempValue)
                }
            }
        }
    }

    fun getTemp () : MutableLiveData<String>{
        return temp
    }
    fun getHumi(): MutableLiveData<String>{
        return humi
    }

    fun getMoisture(): MutableLiveData<String>{
        return moisture
    }


}