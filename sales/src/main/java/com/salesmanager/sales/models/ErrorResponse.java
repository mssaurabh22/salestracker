package com.salesmanager.sales.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class ErrorResponse {

    final String errorMsg;
    final String errorCode;
    Map<String, String> additionalProp;
}
