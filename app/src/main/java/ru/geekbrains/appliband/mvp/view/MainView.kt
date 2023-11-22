package ru.geekbrains.appliband.mvp.view

interface MainView {

    /**
     * Пишет на выбранной кнопке новое значение
     */
    fun setButtonOneText(value: String)
    fun setButtonTwoText(value: String)
    fun setButtonThreeText(value: String)
}