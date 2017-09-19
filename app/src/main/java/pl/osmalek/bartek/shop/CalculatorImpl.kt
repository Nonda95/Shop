package pl.osmalek.bartek.shop

class CalculatorImpl(private val prices: Map<String, Double>) : Calculator {
    override var enable3for2Discount = false
    override var enablePercentDiscount = false

    override fun calculate(products: Map<String, Int>): Double {
        var sum = products.map { (name, amount) -> prices[name]?.times(amount) ?: 0.0 }.sum()

        val times = countHowMany3for2Discount(products)
        if (times > 0) {
            sum = apply3for2Discount(sum, times)
        }
        if (shouldApplyPercentDiscount(sum)) {
            sum = applyPercentDiscount(sum)
        }

        return sum
    }

    private fun shouldApplyPercentDiscount(sum: Double): Boolean = enablePercentDiscount && sum > 50.0

    private fun applyPercentDiscount(sum: Double): Double = sum * 0.9

    private fun countHowMany3for2Discount(products: Map<String, Int>) = if (enable3for2Discount) (products["Bułka"] ?: 0) / 3 else 0

    private fun apply3for2Discount(sum: Double, times: Int) = prices["Bułka"]?.let { sum - times * it } ?: sum
}