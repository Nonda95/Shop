package pl.osmalek.bartek.shop

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BasketTest {
    private lateinit var basket: Basket

    @Before
    fun setUp() {
        basket = BasketImpl()
    }

    @Test
    fun isAddingWhenNewProduct() {
        prepareBasket("Chleb", 1)

        val products = basket.getProducts()
        assertEquals(1, products.size)
        assertEquals(1, products["Chleb"])
    }

    @Test
    fun isIncreasingAmountWhenAddedTwice() {
        prepareBasket("Chleb", 2)

        val products = basket.getProducts()
        assertEquals(1, products.size)
        assertEquals(2, products["Chleb"])
    }

    @Test
    fun isRemovingWholeProductWhenLastPiece() {
        prepareBasket("Chleb", 1)

        basket.removeFromBasket("Chleb")
        val products = basket.getProducts()

        assertEquals(0, products.size)
    }

    @Test
    fun isDecreasingWhenTwoPieces() {
        prepareBasket("Chleb", 2)

        basket.removeFromBasket("Chleb")
        val products = basket.getProducts()

        assertEquals(1, products.size)
        assertEquals(1, products["Chleb"])
    }



    private fun prepareBasket(name: String, amount: Int) {
        for (i in (1..amount)) {
            basket.addToBasket(name)
        }
    }

}