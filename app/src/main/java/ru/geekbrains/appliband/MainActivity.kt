package ru.geekbrains.appliband

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.appliband.databinding.ActivityMainBinding
import ru.geekbrains.appliband.mvp.presenter.Presenter
import ru.geekbrains.appliband.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private var _viewBinding: ActivityMainBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        presenter = Presenter(this)

        viewBinding.btnCounter1.setOnClickListener { presenter.counterOneClick() }
        viewBinding.btnCounter2.setOnClickListener { presenter.counterTwoClick() }
        viewBinding.btnCounter3.setOnClickListener { presenter.counterThreeClick() }
    }

    /**
     * MainActivity наследует интерфейс MainView.
     * Переопределяет работу функции setButtonText из интерфейса MainView внутри MainActivity.
     */
    override fun setButtonOneText(value: String) {
        viewBinding.btnCounter1.text = value
    }

    override fun setButtonTwoText(value: String) {
        viewBinding.btnCounter2.text = value
    }

    override fun setButtonThreeText(value: String) {
        viewBinding.btnCounter3.text = value
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}