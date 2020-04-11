package net.controller;

import net.factory.ReportType;
import net.model.CreatedReport;
import net.model.Item;
import net.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping("/report")
    public String viewReportPage(Model model, @RequestParam(name = "username") String username, @RequestParam(name = "action") String reportType) {
        CreatedReport createdReport = reportService.getReport(ReportType.valueOf(reportType), username);

        List<Item> eatenFood = createdReport.getEatenFood();
        List<Item> expiredFood = createdReport.getExpiredFood();

        model.addAttribute("eatenCalories", createdReport.getEatenCalories());
        model.addAttribute("wastedCalories", createdReport.getWastedCalories());
        model.addAttribute("eatenFood", eatenFood);
        model.addAttribute("expiredFood", expiredFood);

        String reportT = reportType + " ";
        model.addAttribute("reportType", reportT);

        String period;
        if(reportType.equals("WEEKLY")){
            period = " week:";
        }else{
            period = " month:";
        }

        model.addAttribute("period", period);
        return "report_page";
    }
}
