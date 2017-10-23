package com.naotictactoe.nao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.naotictactoe.nao.R;
import com.naotictactoe.nao.event.UserEvent;
import com.naotictactoe.nao.manager.UserManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cyci on 17/10/2017.
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.gameButt) Button gameButton;
    @BindView(R.id.StatButt) Button statButton;
    @BindView(R.id.EtatRobot) Button etatRobotButton;
    UserManager userManager;

    private static final Logger LOGGER = Logger.getLogger("MainActivity");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.mainactivity_layout);
        ButterKnife.bind(this);

        statButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StatistiquesJeu.class);
                startActivity(i);
            }
        });
        etatRobotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EtatRobot.class);
                startActivity(i);
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UserEvent event) {
        statButton.setText(event.getUser().toString());
        LOGGER.info(event.getUser().toString());
    }


    @OnClick(R.id.gameButt)
    public void getUser(){
        userManager.getUser();
    }
}
