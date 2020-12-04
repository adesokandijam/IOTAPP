package com.example.iotapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.overview_fragment.*

class OverviewFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewFragment()
    }

    private lateinit var viewModel: OverviewViewModel

    private  var firebaseRepo =  FirebaseRepo()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val database = Firebase.database
        //val myRef = database.getReference("message")
        //myRef.setValue("Hello World!")

        return inflater.inflate(R.layout.overview_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)

        val tempObserver = Observer<String>
        {
            temp ->
            temp_text.text = temp.toString()
        }
        firebaseRepo.getTemp().observe(viewLifecycleOwner,tempObserver)
        val humiObserver = Observer<String>
        {
            humi ->
            humi_text.text = humi.toString()
        }
        firebaseRepo.getHumi().observe(viewLifecycleOwner,tempObserver)
        val moistureObserver = Observer<String>
        {
            moisture ->
            moisture_text.text = moisture.toString()
        }
        firebaseRepo.getMoisture().observe(viewLifecycleOwner,humiObserver)

        // TODO: Use the ViewModel
    }

}