package com.example.ecommerceappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var context: Context,var arrayList:ArrayList<Eproducts>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var  productView =LayoutInflater.from(context).inflate(R.layout.rv_row,parent,false)
        return ProductViewHolder(productView)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ProductViewHolder).intialiseUIComponents(arrayList[position].id,arrayList[position].name,arrayList[position].price
            ,arrayList[position].picture)


    }

    override fun getItemCount(): Int {

        return  arrayList.size
    }

    inner  class ProductViewHolder(myView: View):RecyclerView.ViewHolder(myView){
        var productIdTextView =myView.findViewById<TextView>(R.id.row_productId)
        var productNameTextview=myView.findViewById<TextView>(R.id.row_productName)
        var productPriceTextview=myView.findViewById<TextView>(R.id.row_productPrice)
        var productImageimageView=myView.findViewById<ImageView>(R.id.rv_row_productImage)

        fun intialiseUIComponents(pid:Int,pname:String,pPrice:Int,pPic:Int){
            productIdTextView.text=pid.toString()
            productNameTextview.text=pname
            productPriceTextview.text=pPrice.toString()
            productImageimageView.setImageResource(pPic)
        }




    }
}