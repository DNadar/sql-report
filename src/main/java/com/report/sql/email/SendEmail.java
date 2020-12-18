package com.report.sql.email;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SendEmail {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Environment env;

    public void sendMail(XSSFWorkbook workbook, String sReportName, String sEmailID) throws MessagingException, IOException {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");;
        String timestamp = df.format(new Date());

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(env.getProperty("sql.report.from.emailid"));
        helper.setTo(InternetAddress.parse(sEmailID));
        helper.setSubject(new StringBuilder().append(sReportName).append(" - Generated On : ").append(timestamp).toString());
        helper.setText("Cheers,\nABC Team");


        byte[] excelFileAsBytes;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            excelFileAsBytes = bos.toByteArray();
        }
        ByteArrayResource resource = new ByteArrayResource(excelFileAsBytes);
        helper.addAttachment(new StringBuilder().append(sReportName).append("_").append(df.format(new Date())).append(".xlsx").toString(), resource);
        emailSender.send(message);
    }
}
