package com.kingofraccoon.portalkvantorium

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.kingofraccoon.portalkvantorium.firestore.FireStore
import java.security.CodeSigner
import java.security.Permission

class MainActivityLoadPhoto : AppCompatActivity() {
    val per_code = 1001
    val image_pick_code = 1000
    lateinit var image: ImageView
    lateinit var editTextTitle : EditText
    lateinit var editTextText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_load_photo)
        val button : Button = findViewById(R.id.button)
        editTextTitle = findViewById(R.id.enter_title)
        editTextText = findViewById(R.id.enter_text)
        image = findViewById(R.id.image)
        button.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED){
                    requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.INTERNET), per_code)
                }
                else
                    pickImage()
            }
            else
                pickImage()
        }

    }

    fun pickImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.setType("image/*")
        startActivityForResult(intent, image_pick_code)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            per_code -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImage()
                }
                else{
                    Toast.makeText(this, "Perm", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == image_pick_code){
            image.setImageURI(data?.data)
            /*FireStore().writeEvent(
                Event(
                    editTextTitle.text.toString(),
                    editTextText.text.toString(),
                    "",
                    "",
                    ""
                )
            )*/
        }
    }
}