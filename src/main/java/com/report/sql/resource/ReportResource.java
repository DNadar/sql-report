package com.report.sql.resource;


import com.report.sql.controller.ReportService;
import com.report.sql.model.ReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class ReportResource {

    @Autowired
    ReportService service;

    @PostMapping("/report")
    public void getReport(@RequestBody ReportRequest reportRequest) throws IOException, MessagingException {
        service.requestReport(reportRequest);
    }
}
