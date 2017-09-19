package pl.osmalek.bartek.shop

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item.view.*

class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(product: Product, listener: ProductListener) {
        with(itemView) {
            tvName.text = "${product.name} (${product.price})"
            tvAmount.text = product.amount.toString()
            butDec.setOnClickListener {
                listener.remove(product.name)
            }
            butInc.setOnClickListener {
                listener.add(product.name)
            }
        }
    }
}