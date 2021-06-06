package by.kleban.myapplication.homework11

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.kleban.myapplication.homework11.data.entities.CountryWithHoliday
import by.kleban.myapplication.homework11.mappers.CountryWithHolidayMapper
import by.kleban.myapplication.homework11.repository.CountryHolidayRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.time.LocalDateTime


class CountryHolidayViewModel : ViewModel() {

    private val repository = CountryHolidayRepository()
    private val mapper = CountryWithHolidayMapper()
    private val date = LocalDateTime.now()
    private val month = date.month.value
    private val day = date.dayOfMonth
    private val disposables = CompositeDisposable()

    private val _countryListLiveData = MutableLiveData<List<CountryWithHoliday>>()
    val countryListLiveData: LiveData<List<CountryWithHoliday>>
        get() = _countryListLiveData

    private val _updateCountryListLiveData = MutableLiveData<CountryWithHoliday>()
    val updateCountryListLiveData: LiveData<CountryWithHoliday>
        get() = _updateCountryListLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private val _isLoadingCountryLiveData = MutableLiveData(true)
    val isLoadingCountryLiveData: LiveData<Boolean>
        get() = _isLoadingCountryLiveData

    init {
        val disposable = repository.loadCountries()
            .subscribeOn(Schedulers.io())
            .flattenAsObservable { it }
            .map { mapper.map(it) }
            .sorted { o1, o2 -> o1.countryName.compareTo(o2.countryName) }
            .toList()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                _isLoadingCountryLiveData.value = false
                _countryListLiveData.value = it
            }
            .observeOn(Schedulers.io())
            .flattenAsObservable { it }
            .flatMap { countryWithHoliday ->
                repository.loadHoliday(countryWithHoliday.countryCode, month, day)
                    .map { it.first() }
                    .map {
                        countryWithHoliday.holidayName = it.holidayName
                        countryWithHoliday.date = it.date
                        countryWithHoliday
                    }.toObservable()
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _updateCountryListLiveData.value = it },
                {
                    _isLoadingCountryLiveData.value = false
                    _errorLiveData.value = it.message
                })
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}