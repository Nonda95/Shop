package pl.osmalek.bartek.shop

interface ProductListener {
    fun add(product: String)
    fun remove(product: String)
}