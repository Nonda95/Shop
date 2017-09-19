package pl.osmalek.bartek.shop

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ProductsAdapter(private val listener: ProductListener) : RecyclerView.Adapter<ProductVH>() {
    private var products = listOf<Product>()

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        holder.bind(products[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ProductVH(view)
    }

    override fun getItemCount() = products.size

    fun setData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
}