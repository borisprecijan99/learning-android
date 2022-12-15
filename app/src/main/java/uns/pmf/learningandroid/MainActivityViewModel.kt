package uns.pmf.learningandroid

import androidx.lifecycle.ViewModel

class MainActivityViewModel(initialCounter: Int) : ViewModel() {
    private var counter: Int = 0

    init {
        counter = initialCounter
    }

    fun getCounter(): Int {
        return counter
    }

    fun increaseCounter(): Int {
        return ++counter
    }
}