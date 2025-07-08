package com.example.comunicacaofragments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel; // Importe a classe ViewModel

public class SharedViewModel extends ViewModel { // Faça SharedViewModel herdar de ViewModel
    private final MutableLiveData<String> message = new MutableLiveData<>();

    public MutableLiveData<String> getMessage() {
        return message;
    }

    public void setMessage(String texto) {
        message.setValue(texto);
    }
}