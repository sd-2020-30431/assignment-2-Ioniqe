package net.factory;

public class ChooseFactory extends AbstractFactory{

    @Override
    public ReportFactory getFactory(ReportType type) {
        if(type.equals(ReportType.WEEKLY)){
            WeeklyReportFactory weeklyReportFactory = new WeeklyReportFactory();
            return weeklyReportFactory;
        }else if(type.equals(ReportType.MONTHLY)){
            MonthlyReportFactory monthlyReportFactory = new MonthlyReportFactory();
            return monthlyReportFactory;
        }
        return null;
    }
}
