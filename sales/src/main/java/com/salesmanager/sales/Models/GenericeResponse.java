package com.salesmanager.sales.Models;

import lombok.Data;

@Data
public class GenericeResponse {

    private Object response;
    private boolean status;
    private String errorCode;
    private String errorMessage;
}
