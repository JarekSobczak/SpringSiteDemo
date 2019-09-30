package com.ownProjects.springWebSite.Hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
class HelloServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    HelloService service;

    HelloServlet(HelloService service) {
        this.service = service;
    }

    @GetMapping("/api")
    String welcome() {
        return welcome(null, null);
    }

    @GetMapping(value = "/api", params = {"lang", "name"})
    String welcome(@RequestParam("lang") Integer langId, @RequestParam String name) {
        logger.info("Got request with parameter ");
        return service.prepareGreetings(name, langId);
    }
}
