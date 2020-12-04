package com.example.iotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.sign_up_fragment.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_fragment)

        auth = Firebase.auth
        rectangle_4.setOnClickListener {
            auth.createUserWithEmailAndPassword(e_mail_text.toString(), password_text.toString())
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                        //val user = auth.currentUser

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "UNSuccessful", Toast.LENGTH_SHORT).show()


                    }

                    // ...
                }
        }
    }
}