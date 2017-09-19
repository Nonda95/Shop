package pl.osmalek.bartek.shop

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainPresenterTest {
    @Mock
    lateinit var calculator: Calculator
    @Mock
    lateinit var basket: Basket
    @Mock
    lateinit var view: MainView

    @InjectMocks
    lateinit var presenter: MainPresenterImpl


    private val product = "Chleb"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter.onViewCreated(view)
    }

    @Test
    fun onSumClicked() {
        whenever(calculator.calculate(any())).thenReturn(1.0)

        presenter.onSumClicked()
        verify(view).showSum(eq(1.0))
    }

    @Test
    fun addProduct() {
        presenter.addProduct(product)
        verify(basket).addToBasket(eq(product))
    }

    @Test
    fun removeProduct() {
        presenter.removeProduct(product)
        verify(basket).removeFromBasket(eq(product))
    }

}