package net.controller;

import net.model.Charity;
import net.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class CharityController {
    @Autowired
    private CharityService charityService;

    @RequestMapping(value = "/donateToCharity/{itemId}", method = RequestMethod.GET)///{itemId}
    public ResponseEntity<List<Charity>> viewCharities(@PathVariable(name = "itemId") int itemId) {
        List<Charity> listCharities = charityService.listAll();
        return new ResponseEntity<>(listCharities, HttpStatus.OK);
    }
}
