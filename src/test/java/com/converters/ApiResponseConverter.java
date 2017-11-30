package com.converters;

import com.datamodels.services.ApiResponse;
import com.google.gson.Gson;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class ApiResponseConverter extends AbstractConverter<ApiResponse> {

    public ApiResponse convert(Map<String, Object> convertFrom) {
        ApiResponse apiResponse = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            apiResponse = gson.fromJson((String) convertFrom.get("response"), ApiResponse.class);
        }

        return apiResponse;
    }
}
