package pl.osmalek.bartek.shop

interface MainView {
    fun showSum(sum: Double)
    fun showProducts(productsWithPrices: List<Product>)

}