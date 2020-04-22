package net.controller;

import net.factory.ReportType;
import net.model.CreatedReport;
import net.model.Item;
import net.model.dto.ReportDTO;
import net.service.ReportService;
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
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/report/{username}/{reportType}/eatenCalories", method = RequestMethod.GET)
    public ResponseEntity<Integer> getEatenCalories(@PathVariable(name = "username") String username, @PathVariable(name = "reportType") String reportType) {
        CreatedReport createdReport = reportService.getReport(ReportType.valueOf(reportType), username);
        return new ResponseEntity<>(createdReport.getEatenCalories(), HttpStatus.OK);
    }

    @RequestMapping(value = "/report/{username}/{reportType}/wastedCalories", method = RequestMethod.GET)
    public ResponseEntity<Integer> getWastedCalories(@PathVariable(name = "username") String username, @PathVariable(name = "reportType") String reportType) {
        CreatedReport createdReport = reportService.getReport(ReportType.valueOf(reportType), username);
        return new ResponseEntity<>(createdReport.getWastedCalories(), HttpStatus.OK);
    }

    @RequestMapping(value = "/report/{username}/{reportType}/eatenFood", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getEatenFood(@PathVariable(name = "username") String username, @PathVariable(name = "reportType") String reportType) {
        CreatedReport createdReport = reportService.getReport(ReportType.valueOf(reportType), username);
        List<Item> eatenFood = createdReport.getEatenFood();
        return new ResponseEntity<>(eatenFood, HttpStatus.OK);
    }

    @RequestMapping(value = "/report/{username}/{reportType}/expiredFood", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getExpiredFood(@PathVariable(name = "username") String username, @PathVariable(name = "reportType") String reportType) {
        CreatedReport createdReport = reportService.getReport(ReportType.valueOf(reportType), username);
        List<Item> expiredFood = createdReport.getExpiredFood();
        return new ResponseEntity<>(expiredFood, HttpStatus.OK);
    }

}
