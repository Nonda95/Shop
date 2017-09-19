package pl.osmalek.bartek.shop

class MainPresenterImpl(private val basket: Basket, private val calculator: Calculator) : MainPresenter {
    private var view: MainView? = null

    override fun onViewCreated(view: MainView) {
        this.view = view
    }

    override fun onViewDestroyed() {
        view = null
    }

    override fun init() {
        view?.showProducts(getAvailableProducts())
    }

    private fun getAvailableProducts() = basket.getProductsWithPrices(Products.prices)

    override fun onSumClicked() {
        val sum = calculator.calculate(basket.getProducts())
        view?.showSum(sum)
    }

    override fun addProduct(product: String) {
        basket.addToBasket(product)
        view?.showProducts(getAvailableProducts())
    }

    override fun removeProduct(product: String) {
        basket.removeFromBasket(product)
        view?.showProducts(getAvailableProducts())
    }
}

