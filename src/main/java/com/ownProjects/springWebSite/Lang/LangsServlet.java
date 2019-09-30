package com.ownProjects.springWebSite.Lang;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
 class LangsServlet {

    private final Logger logger = LoggerFactory.getLogger(LangsServlet.class);

    private LangService service;

    LangsServlet(LangService service) {
        this.service = service;
    }

    @RequestMapping("/langs")
    ResponseEntity<List<LangDTO>>findAllLangs(){
        logger.info("Got request with parameter ");
        return ResponseEntity.ok(service.findAll());
    }
}
