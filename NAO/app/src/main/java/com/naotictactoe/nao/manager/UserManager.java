package com.naotictactoe.nao.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.naotictactoe.nao.dao.UserDao;
import com.naotictactoe.nao.event.UserEvent;
import com.naotictactoe.nao.model.User;
import com.naotictactoe.nao.service.UserService;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by djorykrache on 23/10/2017.
 */

public class UserManager {

    UserService userService;
    UserDao userDao;

    public UserManager() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fierce-citadel-69068.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.userService = retrofit.create(UserService.class);
    }

    public void getUser() {
        userService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                User user = response.body().get(0);
                EventBus.getDefault().post(new UserEvent(user));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
