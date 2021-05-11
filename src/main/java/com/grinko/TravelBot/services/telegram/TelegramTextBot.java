package com.grinko.TravelBot.services.telegram;

import com.grinko.TravelBot.config.ConfigService;
import com.grinko.TravelBot.services.web.AdviceService;
import com.grinko.TravelBot.services.web.CityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramTextBot extends TelegramLongPollingBot {

    private final Logger log = Logger.getLogger(TelegramTextBot.class);
    @Autowired
    private ConfigService configService;
    @Autowired
    private AdviceService adviceService;
    @Autowired
    private CityService cityService;

    protected synchronized void sendMsg(String chatId, String msg) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(msg);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Send message error: " + e.toString());
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        String messageText = update.getMessage().getText();
        if (messageText == null) {
            log.warn("Message is NULL");
        } else {
            String responseMsg;
            if(!cityService.isExists(messageText))
                responseMsg = "City not found! Please try again.";
            else
                responseMsg = adviceService.getAdviceByCityName(messageText);
            sendMsg(update.getMessage().getChatId().toString(), responseMsg);
        }
    }

    @Override
    public String getBotUsername() {
        return configService.getBotName();
    }

    @Override
    public String getBotToken() {
        return configService.getBotToken();
    }
}
