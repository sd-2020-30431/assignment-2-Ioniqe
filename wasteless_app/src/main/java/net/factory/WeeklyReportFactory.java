package net.factory;

import net.model.Report;
import net.model.WeeklyReport;

public class WeeklyReportFactory extends ReportFactory {
    @Override
    public Report getReport(ReportType type) {
        WeeklyReport weeklyReport = new WeeklyReport();
        return weeklyReport;
    }
}
