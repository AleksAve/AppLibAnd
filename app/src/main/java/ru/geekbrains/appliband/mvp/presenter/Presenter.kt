package ru.geekbrains.appliband.mvp.presenter

import ru.geekbrains.appliband.mvp.model.Model
import ru.geekbrains.appliband.mvp.view.MainView

class Presenter(private var view: MainView, private val model: Model = Model()) {

    /**
     * По переданному индексу обращается к кнопке.
     * Из модели получает значение для кнопки по переданному индексу (номер кнопки).
     * * * MainActivity наследует интерфейс MainView.
     * * * Переопределяет работу функции setButtonText из интерфейса MainView внутри MainActivity.
     * Через переопределенную функцию setButtonText выводится значение по индексу кнопки на экран.
     */
    fun counterOneClick() {
        view.setButtonOneText(model.next(0).toString())
    }

    fun counterTwoClick() {
        view.setButtonTwoText(model.next(1).toString())
    }

    fun counterThreeClick() {
        view.setButtonThreeText(model.next(2).toString())
    }
}