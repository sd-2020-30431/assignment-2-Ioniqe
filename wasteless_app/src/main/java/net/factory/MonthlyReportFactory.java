package net.factory;

import net.model.MonthlyReport;
import net.model.Report;

public class MonthlyReportFactory extends ReportFactory {
    @Override
    public Report getReport(ReportType type) {
        MonthlyReport monthlyReport = new MonthlyReport();
        return monthlyReport;
    }
}
