package com.pravpydi.rrr.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    
    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    
    @PostMapping("/data")
    public Map<String, Object> postData(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("receivedData", data);
        response.put("message", "Data received successfully");
        return response;
    }
} 