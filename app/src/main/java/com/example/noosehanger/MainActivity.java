package com.example.noosehanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {



    TextView tvOrdDerskalGættes;
    String ordDerSkalGættes;
    String ordVistString;
    char[] ordVistCharArray;
    ArrayList<String> ordListe;
    EditText etInput;
    TextView tvForsøgteBogstaver;
    String forsøgteBogstaver;
    final String FORSØGTE_BOGSTAVER = "Forsøgte bogstver: ";
    TextView tvLivTilbage;
    String livTilbage;

    void visBogstavIOrd(char c) {
        int index = ordDerSkalGættes.indexOf(c);

        while(index >= 0) {
            ordVistCharArray[index] = ordDerSkalGættes.charAt(index);
            index = ordDerSkalGættes.indexOf(c, index + 1);
        }

        ordVistString = String.valueOf(ordVistCharArray);
    }

    void visOrdSkærm() {
        String s = "";
        for(char character : ordVistCharArray) {
            s += character + " ";
        }

        tvOrdDerskalGættes.setText(s);
    }

    void startSpil() {

        Collections.shuffle(ordListe);
        ordDerSkalGættes = ordListe.get(0);
        ordListe.remove(0);

        ordVistCharArray = ordDerSkalGættes.toCharArray();

        for(int i = 0; i < ordVistCharArray.length; i++) {
            ordVistCharArray[i] = '_';
        }

        visBogstavIOrd(ordVistCharArray[0]);
        visBogstavIOrd(ordVistCharArray[ordVistCharArray.length+1]);
        ordVistString = String.valueOf(ordVistCharArray);

        visOrdSkærm();

        etInput.setText("");

        forsøgteBogstaver = " ";
        tvForsøgteBogstaver.setText(FORSØGTE_BOGSTAVER);

        livTilbage = " X X X X X ";
        tvLivTilbage.setText(livTilbage);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
