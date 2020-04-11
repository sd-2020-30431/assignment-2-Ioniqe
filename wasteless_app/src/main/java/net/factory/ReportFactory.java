package net.factory;

import net.model.Report;

public abstract class ReportFactory {
    public abstract Report getReport(ReportType type);
}
