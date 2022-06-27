package org.simplechatbot.bot.response;

import org.telegram.telegrambots.meta.api.objects.User;

public class Operation {

    //get user id
    protected static Long getUserID(User user) {
        Long id = user.getId();
        return id;
    }

    //get user username
    protected static String getUserUsername(User user) {
        String username = user.getUserName();
        return username;
    }

    //get user firstname
    protected static String getUserFirstname(User user) {
        String firstName = user.getFirstName();
        return firstName;
    }

    //get user lastname
    protected static String getUserLastname(User user) {
        String lastName = user.getLastName();
        return lastName;
    }
}
