package com.backend.controller;

import com.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Lxy on 2023/6/23 19:16
 */
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/api/card/count")
    public Map<String, Object> getCount() {
        return cardService.getCardCount();
    }
}
