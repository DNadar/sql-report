package com.report.sql.constants;

public enum ReportConstants {

    ORDER_LIST_REPORT("Order List"),
    INVOICE_REPORT("Invoice Report");


    ReportConstants(String reportName) {
        this.reportName = reportName;
    }
    private String reportName;

    public String getReportName() {
        return reportName;
    }
}
