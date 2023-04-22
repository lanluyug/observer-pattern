package com.example.observer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanluyug
 */
@RestController
@RequestMapping("observer")
public class ObserverController {

    @Autowired
    private ObserverService observerService;

    @GetMapping("publish")
    public boolean publish(String msg){
        observerService.publish(msg);
        return true;
    }
}
