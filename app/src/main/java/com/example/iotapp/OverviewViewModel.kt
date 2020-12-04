package com.example.iotapp

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class OverviewViewModel : ViewModel() {
    private var humidity:String ?= null
    private var moisture:String ?= null
    private var temp:String ?= null
    private var init : Init ?= null
    private val firebaseRepo by lazy { FirebaseRepo() }







}