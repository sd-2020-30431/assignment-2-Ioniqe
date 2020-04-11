package net.factory;

public abstract class AbstractFactory {
    abstract ReportFactory getFactory(ReportType type);
}
