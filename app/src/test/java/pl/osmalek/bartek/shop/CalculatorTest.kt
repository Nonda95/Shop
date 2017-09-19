package pl.osmalek.bartek.shop

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

const val DELTA = 0.00001

class CalculatorTest {
    private lateinit var calculator: Calculator
    @Before
    fun setUp() {
        calculator = CalculatorImpl(Products.prices)
    }

    @Test
    fun notApplyPercentDiscountWhenSumLowerThan50() {
        calculator.enablePercentDiscount = true
        val products = mapOf(
                "Chleb" to 2,
                "Mleko" to 3
        )

        val sum = calculator.calculate(products)
        assertEquals(10.50, sum, DELTA)
    }

    @Test
    fun notApplyPercentDiscountWhenDisabled() {
        val products = mapOf(
                "Ser" to 3,
                "Mleko" to 3
        )

        val sum = calculator.calculate(products)
        assertEquals(54.0, sum, DELTA)
    }

    @Test
    fun applyPercentDiscountWhenSumGreaterThan50() {
        calculator.enablePercentDiscount = true
        val products = mapOf(
                "Ser" to 3,
                "Mleko" to 3
        )

        val sum = calculator.calculate(products)
        assertEquals(54 * 0.9, sum, DELTA)
    }

    @Test
    fun applyPercentDiscount() {
        calculator.enablePercentDiscount = true
        val products = mapOf(
                "Ser" to 3,
                "Mleko" to 3
        )

        val sum = calculator.calculate(products)
        assertEquals(54 * 0.9, sum, DELTA)
    }

    @Test
    fun notApplyPercentDiscountWhenSumEqual50() {
        calculator.enablePercentDiscount = true
        val products = mapOf(
                "Ser" to 3,
                "Mleko" to 1,
                "Bułka" to 2
        )

        val sum = calculator.calculate(products)
        assertEquals(50.0, sum, DELTA)
    }

    @Test
    fun applyAllDiscounts() {
        calculator.enablePercentDiscount = true
        calculator.enable3for2Discount = true
        val products = mapOf(
                "Ser" to 3,
                "Mleko" to 3,
                "Bułka" to 2
        )

        val sum = calculator.calculate(products)
        assertEquals(55 * 0.9, sum, DELTA)
    }

    @Test
    fun notApply3for2WhenDisabled() {
        val products = mapOf(
                "Bułka" to 3
        )

        val sum = calculator.calculate(products)
        assertEquals(1.5, sum, DELTA)
    }

    @Test
    fun notApply3for2When2Products() {
        calculator.enable3for2Discount = true
        val products = mapOf(
                "Bułka" to 2
        )

        val sum = calculator.calculate(products)
        assertEquals(1.0, sum, DELTA)
    }

    @Test
    fun apply3for2When2ProductsWhen3() {
        calculator.enable3for2Discount = true
        val products = mapOf(
                "Bułka" to 3
        )

        val sum = calculator.calculate(products)
        assertEquals(1.0, sum, DELTA)
    }

    @Test
    fun applyTwice3for2When2ProductsWhen6() {
        calculator.enable3for2Discount = true
        val products = mapOf(
                "Bułka" to 6
        )

        val sum = calculator.calculate(products)
        assertEquals(2.0, sum, DELTA)
    }

    @Test
    fun applyOnce3for2When2ProductsWhen4() {
        calculator.enable3for2Discount = true
        val products = mapOf(
                "Bułka" to 4
        )

        val sum = calculator.calculate(products)
        assertEquals(1.5, sum, DELTA)
    }

}