package org.simplechatbot.bot.response;

import org.simplechatbot.bot.MyBot;

import java.util.HashMap;

public class ResponseMap extends HashMap<String, String> {

    //constructor
    public ResponseMap() {
        put("hello","Hello there!");
        put("hey","Sup!");
        put("how are you?","I am a bot, what do you think?");
        put("ok","Nice");
        put("nice","Oh good!");
    }

    //get response for message
    public String getMsgResponse(String message) {
        String response = "Unknown message!";
        for (String i : keySet()) {
            if (message.equals(i)) {
                response = get(i);
            }
        }
        return response;
    }

    //get response for command
    public String getCmdResponse(String message) {
        String response = "Unknown command!";
        switch (message) {
            case "/start":
                response = "Hello " + Operation.getUserFirstname(MyBot.currentUser) +
                            "!, I am a simple chat bot. \nYou can use some command or just chat something. I will response your message or command if I understand. " +
                            "\n\nThe command is listed below: " +
                            "\n\n/id return your ID" +
                            "\n/username return your username" +
                            "\n/firstname return your first name" +
                            "\n/lastname return yout last name";
                break;

            case "/id":
                Long uid = Operation.getUserID(MyBot.currentUser);
                response = uid.toString();
                break;

            case "/username":
                response = Operation.getUserUsername(MyBot.currentUser);
                break;

            case "/firstname":
                response = Operation.getUserFirstname(MyBot.currentUser);
                break;

            case "/lastname":
                response = Operation.getUserLastname(MyBot.currentUser);
                break;
        }
        return response;
    }
}
