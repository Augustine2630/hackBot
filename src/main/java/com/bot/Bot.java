package com.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.MessageEntity;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    List<String> targets = new ArrayList<>();
    SomeCollection someCollection = new SomeCollection();

    PhotoCollection photoCollection = new PhotoCollection();

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
    String userMessage;

    public void onUpdateReceived(Update update) {


        Model model = new Model();
        Message message = update.getMessage();
        String message_text = update.getMessage().getText();

        long chat_id = update.getMessage().getChatId();
//        SendMessage mess = new SendMessage().setChatId(chat_id).setText(message_text);
//        try {
//            execute(mess); // Sending our message object to user
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }

        if(message_text.equals("/start")){
            sendMsg(message, "выбери");
        }
        if (message != null && message.hasText()) {
            switch (message_text) {
                case "мотивация":
                    //sendMsg(message, "Сколько ты сегодня занимался? \n 1.Я ленивый тюлень, валял дурака\n 2. Открыл, заскучал, закрыл.\n 3. Позанимался, но цели не достиг\n 4. Сидел весь день, аж мозг вскипел\n");
                    if (message_text.equals("мотивация")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Мотивация");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("тюлень");
                        row.add("заскучал");
                        row.add("занимался");
                        row.add("вскипел");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case "тюлень":
                    if (message_text.equals("тюлень")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Мотивация");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("помощь");
                        row.add("назад");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                        try {
                            SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(photoCollection.getRandomMotivationImg())).setChatId(chat_id).setCaption(someCollection.getRandomMotivation());

                            sendPhoto(sendPhoto1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "заскучал":
                    if (message_text.equals("заскучал")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Мотивация");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("помощь");
                        row.add("назад");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        File file = new File("D:\\dis\\aboba.jpg");
                        try {
                            SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(photoCollection.getRandomBoringImg())).setChatId(chat_id).setCaption(someCollection.getRandomBoring());

                            sendPhoto(sendPhoto1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "позанимался":
                    if (message_text.equals("позанимался")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Мотивация");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("помощь");
                        row.add("назад");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        File file = new File("D:\\dis\\aboba.jpg");
                        try {
                            SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(photoCollection.getRandomStudingImg())).setChatId(chat_id).setCaption(someCollection.getRandomStudied());

                            sendPhoto(sendPhoto1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "вскипел":
                    if (message_text.equals("вскипел")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Мотивация");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("помощь");
                        row.add("назад");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        File file = new File("D:\\dis\\aboba.jpg");
                        try {
                            SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(photoCollection.getRandomBoiledImg())).setChatId(chat_id).setCaption(someCollection.getRandomBoiled());
                            sendPhoto(sendPhoto1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "цель":
                    if (message_text.equals("цель")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("цель");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("создать цель");
                        row.add("помощь");
                        row.add("достингуто");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        File file = new File("D:\\dis\\aboba.jpg");
                        try {
                            SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(file)).setChatId(chat_id).setCaption(someCollection.getRandomBoring());
                            sendPhoto(sendPhoto1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "поныть":
                    if (message_text.equals("поныть")) {
                    SendMessage mess = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("Чтобы достичь твоей цели, нужно что?");
                    // Create ReplyKeyboardMarkup object
                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    // Create the keyboard (list of keyboard rows)
                    List<KeyboardRow> keyboard = new ArrayList<>();
                    // Create a keyboard row
                    KeyboardRow row = new KeyboardRow();
                    // Set each button, you can also use KeyboardButton objects if you need something else than text
                    row.add("назад");
                    // Add the first row to the keyboard
                    keyboard.add(row);
                    // Create another keyboard row
                    row = new KeyboardRow();
                    keyboardMarkup.setKeyboard(keyboard);
                    // Add it to the message
                    mess.setReplyMarkup(keyboardMarkup);
//                        if (update.hasMessage() && update.getMessage().hasText()) {
//                            // Set variables
//                            message_text = update.getMessage().getText();
//                            targets.add(message_text);
//                        }
                    try {
                        sendMessage(mess); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    File file = new File("D:\\dis\\aboba.jpg");
                    try {
                        SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(file)).setChatId(chat_id).setCaption(someCollection.getRandomBoring());
                        sendPhoto(sendPhoto1);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                    break;

                case "помощь":
                    if (message_text.equals("помощь")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Чтобы достичь твоей цели, нужно что?");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("назад");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
//                        if (update.hasMessage() && update.getMessage().hasText()) {
//                            // Set variables
//                            message_text = update.getMessage().getText();
//                            targets.add(message_text);
//                        }
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        File file = new File("D:\\dis\\aboba.jpg");
                        try {
                            SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(file)).setChatId(chat_id).setCaption(someCollection.getRandomBoring());
                            sendPhoto(sendPhoto1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "записать сообщение":
                    if (update.hasMessage() && update.getMessage().hasText()) {
                        // Set variables
                        message_text = update.getMessage().getText();
                        targets.add(message_text);
                    }
                    break;
                case "назад":
                    if (message_text.equals("назад")) {
                        SendMessage mess = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Чтобы достичь твоей цели, нужно что?");
                        // Create ReplyKeyboardMarkup object
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        // Create the keyboard (list of keyboard rows)
                        List<KeyboardRow> keyboard = new ArrayList<>();
                        // Create a keyboard row
                        KeyboardRow row = new KeyboardRow();
                        // Set each button, you can also use KeyboardButton objects if you need something else than text
                        row.add("мотивация");
                        row.add("цель");
                        row.add("успехи");
                        row.add("поныть");
                        // Add the first row to the keyboard
                        keyboard.add(row);
                        // Create another keyboard row
                        row = new KeyboardRow();
                        keyboardMarkup.setKeyboard(keyboard);
                        // Add it to the message
                        mess.setReplyMarkup(keyboardMarkup);
//                        if (update.hasMessage() && update.getMessage().hasText()) {
//                            // Set variables
//                            message_text = update.getMessage().getText();
//                            targets.add(message_text);
//                        }
                        try {
                            sendMessage(mess); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        File file = new File("D:\\dis\\aboba.jpg");
                        try {
                            SendPhoto sendPhoto1 = new SendPhoto().setNewPhoto("photo", new FileInputStream(file)).setChatId(chat_id).setCaption(someCollection.getRandomBoring());
                            sendPhoto(sendPhoto1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                default:
                    System.out.println(targets.get(0));
                    System.out.println(targets.get(1));
                    System.out.println(targets.get(2));

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
        keyboardFirstRow.add(new KeyboardButton("поныть"));

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
