# sql-report
SQL reporting spring boot application, can be used to generate reports in Excel by querying RDBMS and email the Excel report as an attachment to the recipient. This project can be further enhanced to send automated reports to a good of recipents in a timely manner. 


Scope of this sample project
1. Connect to any RDBMS database like Oracle, MySQL etc. To connect to your favorite Database, add the required Database credentials in the resources/application.properties.
2. Execute the reporting SQL query. Add the required reporting SQL queries in resources/sql-query.properties using Key-value pair.
3. Update the ISqlReportRequest.java interface and ReportService.java to add any business level logic.
4. Update the Email SMTP credentials to trigger emails to the reciepent with the generated excel reports as an attachment.
5. That's it you are done. Start the spring boot report application.

One can trigger the report using post rest webservice exposed by the application using any rest client For Example: Postman
  - Host name: http://<hostname>:<port>/report
  - Method : POST
  - Request Body:
     {
      "emailID":"abc@xyz.com",
      "reportName" : "INVOICE_REPORT"
     }
    
