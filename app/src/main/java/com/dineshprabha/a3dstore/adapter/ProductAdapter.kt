package com.dineshprabha.a3dstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.dineshprabha.a3dstore.databinding.ProductItemLayoutBinding
import com.dineshprabha.a3dstore.models.ProductItem

class ProductAdapter() : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var productList = ArrayList<ProductItem>()

    fun setProductList(productList: List<ProductItem>) {
        this.productList = productList as ArrayList<ProductItem>
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(val binding: ProductItemLayoutBinding) :
        ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Glide.with(holder.itemView).load(productList[position].image).into(holder.binding.imgProduct)
        var newPrice = productList[position].price * 3
        holder.binding.tvPrice.text = "Rs. ${newPrice }"
        holder.binding.productName.text = productList[position].title
    }
}