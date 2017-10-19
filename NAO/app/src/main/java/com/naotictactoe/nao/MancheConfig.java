package com.naotictactoe.nao;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBar;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MancheConfig extends AppCompatActivity {
    /**
     * A preference value change listener that updates the preference's summary
     * to reflect its new value.
     */

    @BindView(R.id.goButt) Button gameButton;
    @BindView(R.id.ipRobot) EditText ipRobot;

    @BindView(R.id.radRond) RadioButton radRond;
    @BindView(R.id.radCroix) RadioButton radCroix;
    @BindView(R.id.radStart) RadioButton radPreums;
    @BindView(R.id.radFollow) RadioButton radLast;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mancheconfig_layout);
        ButterKnife.bind(this);

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MancheConfig.this,EndGame.class);
                startActivity(i);
            }
        });

        radRond.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radRond:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Ronds",Toast.LENGTH_SHORT);
                    break;
            case R.id.radCroix:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Croix",Toast.LENGTH_SHORT);
                    break;
            case R.id.radStart:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Premier",Toast.LENGTH_SHORT);
                break;
            case R.id.radFollow:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Après",Toast.LENGTH_SHORT);
                break;
        }


    }
}
