package pl.osmalek.bartek.shop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val presenter: MainPresenter = MainPresenterImpl(BasketImpl(), CalculatorImpl(Products.prices))
    private val productsAdapter = ProductsAdapter(object : ProductListener {
        override fun add(product: String) {
            presenter.addProduct(product)
        }

        override fun remove(product: String) {
            presenter.removeProduct(product)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewCreated(this)
        butSum.setOnClickListener {
            presenter.onSumClicked()
        }
        rvProducts.layoutManager = LinearLayoutManager(this)
        rvProducts.adapter = productsAdapter
        presenter.init()
    }

    override fun showSum(sum: Double) {
        tvSum.text = "Sum: $sum"
    }


    override fun showProducts(productsWithPrices: List<Product>) {
        productsAdapter.setData(productsWithPrices)
    }
}

