package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var myProductList=ArrayList<Eproducts>()

        myProductList.add(Eproducts(0,"iphone",100,R.drawable.iphone))
        myProductList.add(Eproducts(1,"imac",100,R.drawable.imac))
        myProductList.add(Eproducts(2,"macbook",100,R.drawable.macbookair))
        myProductList.add(Eproducts(3,"samsung",100,R.drawable.macbookpro))
        myProductList.add(Eproducts(4,"macpro",100,R.drawable.macpro))

        var rvAdapter=RecyclerViewAdapter(this@RecyclerViewActivity,myProductList)

        recyclerView.layoutManager=LinearLayoutManager(this@RecyclerViewActivity)
        recyclerView.adapter=rvAdapter

    }
}