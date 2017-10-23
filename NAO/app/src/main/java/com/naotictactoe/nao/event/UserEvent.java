package com.naotictactoe.nao.event;

import com.naotictactoe.nao.model.User;

/**
 * Created by djorykrache on 23/10/2017.
 */

public class UserEvent {

    private User user;

    public UserEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
