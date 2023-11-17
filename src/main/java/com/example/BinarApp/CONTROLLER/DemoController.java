package com.example.BinarApp.CONTROLLER;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/Api/BinarFud/Demo")
public class DemoController {

    @GetMapping(value= "/multi-thread")
    public ResponseEntity getMultiThread(){
        Thread threadExample = new Thread(()->{
            log.info("inside Thread : " + Thread.currentThread().getName());
        });
        return ResponseEntity.ok("ok");

    }

}
