package pl.osmalek.bartek.shop

interface Calculator {
    var enable3for2Discount: Boolean
    var enablePercentDiscount: Boolean

    fun calculate(products: Map<String, Int>): Double
}