package com.herbal.herbalfax.customer.homescreen.cardList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CardListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CardListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is card list fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}