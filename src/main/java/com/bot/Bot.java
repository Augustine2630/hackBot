package com.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        DatabaseUtils databaseUtils = new DatabaseUtils();

        databaseUtils.connect();
    }


    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        sendMessage.setChatId(message.getChatId().toString());

        sendMessage.setReplyToMessageId(message.getMessageId());

        sendMessage.setText(text);
        try {

            setStartButtons(sendMessage);
            sendMessage(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



//    public void onUpdateReceived(Update update) {
//        Update update = new Update();
//        Message message = update.getMessage();
//        if (message != null && message.hasText()) {
//            switch (message.getText()) {
//                case "абоба":
//                    sendMsg(message, "Сколько ты сегодня занимался? \n 1.Я ленивый тюлень, валял дурака\n 2. Открыл, заскучал, закрыл.\n 3. Позанимался, но цели не достиг\n 4. Сидел весь день, аж мозг вскипел\n");
//                    break;
//            }
//        }
//    }

    public void onUpdateReceived(Update update){
        Model model = new Model();
        Message message = update.getMessage();
        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();
        SendMessage mess = new SendMessage().setChatId(chat_id).setText(message_text);
        try {
            execute(mess); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        if (message != null && message.hasText()) {
            switch (message_text) {
                case "мотивация":
                    sendMsg(message, "Сколько ты сегодня занимался? \n 1.Я ленивый тюлень, валял дурака\n 2. Открыл, заскучал, закрыл.\n 3. Позанимался, но цели не достиг\n 4. Сидел весь день, аж мозг вскипел\n");

                    break;
                case "цель":
                    sendMsg(message, "Что будем настраивать?");
                    break;
                case "успехи":
                    sendMsg(message, "Что будем настраивать?");
                    break;
                case "поныть хочеца":
                    sendMsg(message, "Что будем настраивать?");
                    break;
                default:
                    try {
                        sendMsg(message, Weather.getWeather(message.getText(), model));
                    } catch (IOException e) {
                        sendMsg(message, "Город не найден!");
                    }
            }
        }
    }



    public void setStartButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("мотивация"));
        keyboardFirstRow.add(new KeyboardButton("цель"));
        keyboardFirstRow.add(new KeyboardButton("успехи"));
        keyboardFirstRow.add(new KeyboardButton("поныть хочеца"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }


    public String getBotUsername() {
        return "testNetoBot";
    }

    public String getBotToken() {
        return "5166573762:AAFlmTqFKoiBzPxEwO2ew5l_T6EzHdYtGr0";
    }
}
