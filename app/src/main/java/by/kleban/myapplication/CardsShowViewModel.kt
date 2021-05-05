package by.kleban.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CardsShowViewModel : ViewModel() {

    private val cardsList = CardList.createList()

    private val _listCardsLiveData = MutableLiveData(cardsList)

    val listCardsLiveData: LiveData<MutableList<Card>>
        get() = _listCardsLiveData


}