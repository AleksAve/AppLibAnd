package ru.geekbrains.appliband

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.appliband.databinding.ActivityMainBinding

const val BUTTON_ONE = 0
const val BUTTON_TWO = 1
const val BUTTON_THREE = 2

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var vb: ActivityMainBinding
    private var vbMainBinding: ActivityMainBinding? = null
    private val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vbMainBinding = ActivityMainBinding.inflate(layoutInflater)
        vb = vbMainBinding as ActivityMainBinding
        setContentView(vb.root)
        initView()

        vb.btnCounter1.setOnClickListener(this)
        vb.btnCounter2.setOnClickListener(this)
        vb.btnCounter3.setOnClickListener(this)
    }

    private fun initView() {
        vb.btnCounter1.text = counters[BUTTON_ONE].toString()
        vb.btnCounter2.text = counters[BUTTON_TWO].toString()
        vb.btnCounter3.text = counters[BUTTON_THREE].toString()
    }

    override fun onClick(p0: View?) {
        when (p0) {
            vb.btnCounter1 -> vb.btnCounter1.text = countCounter(BUTTON_ONE)
            vb.btnCounter2 -> vb.btnCounter2.text = countCounter(BUTTON_TWO)
            vb.btnCounter3 -> vb.btnCounter3.text = countCounter(BUTTON_THREE)
            else -> Toast.makeText(
                this,
                getString(R.string.doNotDoIt),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun countCounter(number: Int): String {
        return (++counters[number]).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(getString(R.string.nameArr), counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val countersArr = savedInstanceState.getIntArray(getString(R.string.nameArr))
        countersArr?.toList()?.let {
            counters.clear()
            counters.addAll(it)
        }
        initView()
    }

    override fun onDestroy() {
        vbMainBinding = null
        super.onDestroy()
    }
}