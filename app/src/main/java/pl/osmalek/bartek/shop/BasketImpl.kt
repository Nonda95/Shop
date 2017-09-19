package pl.osmalek.bartek.shop

class BasketImpl : Basket {
    override fun getProductsWithPrices(prices: Map<String, Double>): List<Product> {
        return prices.map { (k, v) -> Product(k, v, products[k] ?: 0) }
    }

    private val products = mutableMapOf<String, Int>()

    override fun addToBasket(product: String) {
        products[product]?.let { products[product] = it + 1 } ?: products.put(product, 1)
    }

    override fun removeFromBasket(product: String) {
        products[product]?.takeIf { it > 1 }?.let { products[product] = it - 1 } ?: products.remove(product)
    }

    override fun getProducts() = products.toMap()

    override fun getProductAmount(product: String): Int = products[product] ?: 0
}