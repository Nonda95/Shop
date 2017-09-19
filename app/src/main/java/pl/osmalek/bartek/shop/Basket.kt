package pl.osmalek.bartek.shop

interface Basket {

    fun addToBasket(product: String)
    fun removeFromBasket(product: String)
    fun getProducts(): Map<String, Int>
    fun getProductAmount(product: String): Int
    fun getProductsWithPrices(prices: Map<String, Double>): List<Product>
}