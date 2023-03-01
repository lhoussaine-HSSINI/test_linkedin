package faho.stage.mvc.controller;


import faho.stage.mvc.service.scrapy;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    scrapy   service;

    @GetMapping("/linkedin")
    public List home_linkedin() throws IOException {
//        service.getpage_inded();
//        return service.getpage();
        return service.getpage();
    }
    @GetMapping("/")
    public String home() throws IOException {
//        service.getpage_inded();
//        return service.getpage();
        return service.getpage_inded();
    }
}
