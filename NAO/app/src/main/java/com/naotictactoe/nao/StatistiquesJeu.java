package com.naotictactoe.nao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Cyci on 17/10/2017.
 */

public class StatistiquesJeu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.statistiquesjeu_layout);
        ButterKnife.bind(this);
    }
}