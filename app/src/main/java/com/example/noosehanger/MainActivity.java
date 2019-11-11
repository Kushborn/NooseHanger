package com.example.noosehanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
        visBogstavIOrd(ordVistCharArray[ordVistCharArray.length-1]);
        ordVistString = String.valueOf(ordVistCharArray);

        visOrdSkærm();

        etInput.setText("");

        forsøgteBogstaver = " ";
        tvForsøgteBogstaver.setText(FORSØGTE_BOGSTAVER);

        livTilbage = " X X X X X";
        tvLivTilbage.setText(livTilbage);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ordListe = new ArrayList<>();
        tvOrdDerskalGættes = findViewById(R.id.tvOrdatBliveGættet);
        etInput = findViewById(R.id.etInput);
        tvForsøgteBogstaver = findViewById(R.id.tvForsøgteBogstaver);
        tvLivTilbage = findViewById(R.id.tvLivTilbage);


        InputStream mInputStream = null;
        Scanner in = null;
        String o = "";

        try {
            mInputStream = getAssets().open("wordlist.txt");
            in = new Scanner(mInputStream);
            while (in.hasNext()) {
                o = in.next();
                ordListe.add(o);
            }
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getClass().getSimpleName() + ": " + e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            if(in != null) {
                in.close();
            } try {
                if(mInputStream != null) {
                    mInputStream.close();
                }
            } catch (IOException e) {
                Toast.makeText(MainActivity.this, e.getClass().getSimpleName()+": "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

        startSpil();

        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    checkOmBogstavErIOrd(s.charAt(0));
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

    }

    void checkOmBogstavErIOrd(char b) {
        if(ordDerSkalGættes.indexOf(b) >= 0) {
            if(ordVistString.indexOf(b) < 0) {
                visBogstavIOrd(b);
                visOrdSkærm();

                if(!ordVistString.contains("_")) {
                    //ny aktivitet
                    tvLivTilbage.setText("Du vandt");
                }
            }
        }

        else {
            nedsætOgVisLivTilbage();

            if(livTilbage.isEmpty()) {
                //NY aktivititet
                tvLivTilbage.setText("Du tabte");
                tvOrdDerskalGættes.setText(ordDerSkalGættes);
            }
        }

        if(forsøgteBogstaver.indexOf(b) < 0) {
            forsøgteBogstaver += b + ", ";
            String besked = FORSØGTE_BOGSTAVER + forsøgteBogstaver;
            tvForsøgteBogstaver.setText(besked);
        }
    }

    void nedsætOgVisLivTilbage() {
        if(!livTilbage.isEmpty()) {
            livTilbage = livTilbage.substring(0, livTilbage.length() - 2);
            tvLivTilbage.setText(livTilbage);
        }
    }

    public void genstartSpil(View v) {
        startSpil();
    }


}
