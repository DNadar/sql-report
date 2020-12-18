package com.report.sql.model;

import java.util.List;
import java.util.Map;

public interface ISqlReportRequest {

    List<Map<String, Object>> getOrderListReport();
    List<Map<String, Object>> getInvoiceListReport();

}
