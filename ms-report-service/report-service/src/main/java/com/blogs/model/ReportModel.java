package com.blogs.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportModel {

    private String reportName;
    private String reportType;
    private Map<String, Object> parameters;
    private String fileName;
    private byte[] content;
    
}
