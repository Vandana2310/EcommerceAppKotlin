package com.example.ecommerceappkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private  var sharedP:SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btnAdd.setOnClickListener {
//            sharedP= getSharedPreferences("addData", Context.MODE_PRIVATE)
//            var myEditor=sharedP?.edit()
//            myEditor?.putString("product_name",edtProductName.text.toString())
//            myEditor?.commit()
//            Toast.makeText(this@MainActivity,"this product is saved",Toast.LENGTH_SHORT).show()
//        }
//
//        btnGetProduct.setOnClickListener {
//            txtGetProduct.text=sharedP?.getString("product_name","nothing")
//        }

        btnGetData.setOnClickListener {
            val serverURL:String="http://192.168.43.61/PHPtest/test_file.php"
            var requestQueue:RequestQueue=Volley.newRequestQueue(this@MainActivity)
            var stringRequest=StringRequest(Request.Method.GET,serverURL,Response.Listener
            { response ->
                  txt.text=response
            },Response.ErrorListener { error ->
               txt.text=error.message
            })

            requestQueue.add(stringRequest)
        }

    }
}