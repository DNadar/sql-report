package com.report.sql.controller;


import com.report.sql.constants.ReportConstants;
import com.report.sql.email.SendEmail;
import com.report.sql.filegenerator.ExcelFileGenerator;
import com.report.sql.model.ReportRequest;
import com.report.sql.repository.JDBCSQLConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerResponse;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
public class ReportService {

    @Autowired
    private JDBCSQLConnector connector;

    @Autowired
    private ExcelFileGenerator generator;

    @Autowired
    private SendEmail email;

    public void requestReport(ReportRequest reportRequest) throws IOException, MessagingException {

        if (reportRequest.getReportName().equals(ReportConstants.ORDER_LIST_REPORT.toString())){

            email.sendMail(
                    generator.generateExcelFile(connector.getOrderListReport(),
                            ReportConstants.ORDER_LIST_REPORT.getReportName()),
                    ReportConstants.ORDER_LIST_REPORT.getReportName(), reportRequest.getEmailID());

        }else if (reportRequest.getReportName().equals(ReportConstants.INVOICE_REPORT.toString())){
            email.sendMail(
                    generator.generateExcelFile(connector.getInvoiceListReport(),
                            ReportConstants.INVOICE_REPORT.getReportName()),
                    ReportConstants.INVOICE_REPORT.getReportName(), reportRequest.getEmailID());
        }
    }
}
