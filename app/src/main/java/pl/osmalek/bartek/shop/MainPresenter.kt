package pl.osmalek.bartek.shop

interface MainPresenter {

    fun onViewCreated(view: MainView)
    fun onViewDestroyed()
    fun onSumClicked()
    fun addProduct(product: String)
    fun removeProduct(product: String)
    fun init()
}
