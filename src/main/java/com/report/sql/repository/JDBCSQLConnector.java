package com.report.sql.repository;



import com.report.sql.configuration.SqlConfiguration;
import com.report.sql.model.ISqlReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Component
public class JDBCSQLConnector implements ISqlReportRequest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlConfiguration sqlQuery;

    @Override
    public List<Map<String, Object>> getOrderListReport() {
        return jdbcTemplate.queryForList(sqlQuery.getProperty("ORDER_LIST_SQL"));
    }

    @Override
    public List<Map<String, Object>> getInvoiceListReport() {
        return jdbcTemplate.queryForList(sqlQuery.getProperty("INVOICE_LIST_SQL"));
    }
}
