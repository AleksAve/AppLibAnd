package ru.geekbrains.appliband.mvp.model

class Model {

    private val counters = mutableListOf(0, 0, 0)

    /**
     * Функция прибавляет +1 к существующему значению
     * @param index
     * @return nextValue
     */
    fun next(index: Int): Int {
        val nextValue = ++counters[index]
        counters[index] = nextValue
        return nextValue
    }
}