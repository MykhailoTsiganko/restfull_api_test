package com.converters;

import com.datamodels.services.Order;
import com.google.gson.Gson;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class OrderConverter extends AbstractConverter<Order> {

    public Order convert(Map<String, Object> convertFrom) {
        Order order = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            order = gson.fromJson((String) convertFrom.get("request"), Order.class);
        }

        return order;
    }
}
