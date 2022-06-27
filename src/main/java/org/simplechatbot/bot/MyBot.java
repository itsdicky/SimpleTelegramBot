package org.simplechatbot.bot;

import org.simplechatbot.bot.response.ResponseMap;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    public static User currentUser; //current user
    static ResponseMap responseMap = new ResponseMap(); //init response map

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            currentUser = update.getMessage().getFrom(); //get user

            String input = update.getMessage().getText().toLowerCase(); //get input message text
            String output = "";

            if (input.startsWith("/")) {
                output = responseMap.getCmdResponse(input); //get response from command
            } else {
                output = responseMap.getMsgResponse(input); //get response from message
            }

            //generate SendMessage
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(output);

            //execute
            try {
                execute(response);
            } catch(TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "bot_username";
    }

    @Override
    public String getBotToken() {
        return "bot_token";
    }
}
