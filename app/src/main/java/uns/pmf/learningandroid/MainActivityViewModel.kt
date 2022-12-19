package uns.pmf.learningandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(initialCounter: Int) : ViewModel() {
    private val _counter: MutableLiveData<Int> = MutableLiveData()
    val counter: LiveData<Int> get() = _counter

    init {
        _counter.value = initialCounter
    }

    fun increaseCounter(): Unit {
        _counter.value = _counter.value?.plus(1)
    }
}