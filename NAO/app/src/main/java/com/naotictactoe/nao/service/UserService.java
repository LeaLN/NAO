package com.naotictactoe.nao.service;

import com.naotictactoe.nao.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by djorykrache on 23/10/2017.
 */

public interface UserService {
    @GET("user/all")
    Call<List<User>> getUsers();
}
