package com.example.ecommerceappkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_get_all_jsonobjects.*

class GetAllJSONObjectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_all_jsonobjects)

        txtAllproducts.setOnClickListener {

            txtAllproducts.setBackgroundColor(Color.CYAN)
            txtAllproducts.setTextColor(Color.GREEN)
            val allProductsUrl:String="http://192.168.43.61/Ecommerce/present_json_array.php"
            var allProductsString:String=""
            val requestQueue :RequestQueue=Volley.newRequestQueue(this@GetAllJSONObjectsActivity)
            val jsonArrayRequest=JsonArrayRequest(Request.Method.GET,allProductsUrl,null,Response.Listener {
                    response ->
                 for(productIndex in 0.until(response.length()) ){
//                     allProductsString+=response.getJSONObject(productIndex).getString("name")+
//                     "-"+response.getJSONObject(productIndex).getInt("price")

    // another way to write the same above code

                     var productName=response.getJSONObject(productIndex).getString("name")
                     var productPrice=response.getJSONObject(productIndex).getString("price")
                     allProductsString+=productName+"-"+productPrice+"\n"
                 }
               txtAllproducts.text=allProductsString
            },Response.ErrorListener { error ->
                   txtAllproducts.text=error.message
            })
            requestQueue.add(jsonArrayRequest)
        }
    }
}