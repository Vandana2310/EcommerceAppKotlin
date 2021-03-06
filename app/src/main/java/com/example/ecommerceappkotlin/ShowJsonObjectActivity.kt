package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_json_object.*

class ShowJsonObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_json_object)

        btnSubmit.setOnClickListener {
            val  productURL="http://192.168.43.61/Ecommerce/present_json.php?id="+edtProductId.text.toString()
            val requestQ:RequestQueue=Volley.newRequestQueue(this@ShowJsonObjectActivity)
            val jsonObjectRequest=JsonObjectRequest(Request.Method.GET,productURL,null,Response.Listener { response ->
                txtProductName.text=response.getString("name")
                txtPrice.text=response.getInt("price").toString()
            },Response.ErrorListener { error ->
                txtProductName.text=error.message
                txtPrice.text=error.message

            })
            requestQ.add(jsonObjectRequest)
        }
    }
}