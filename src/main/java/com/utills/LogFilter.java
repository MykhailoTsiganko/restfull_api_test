package com.utills;

import com.jayway.restassured.filter.Filter;
import com.jayway.restassured.filter.FilterContext;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.FilterableRequestSpecification;
import com.jayway.restassured.specification.FilterableResponseSpecification;
import org.apache.log4j.Logger;

public class LogFilter implements Filter {
    public static Logger LOGGER = Logger.getLogger(LogFilter.class);

    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        LOGGER.info("================================================================================================");
        LOGGER.info("=========================================REQUEST================================================");
        LOGGER.info(String.format("WITH METHOD %-10s URI: %-50s", filterableRequestSpecification.getMethod(), filterableRequestSpecification.getURI()));
        LOGGER.info(String.format("WITH BODY %s",filterableRequestSpecification.getBody().toString()));
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        LOGGER.info("=========================================RESPONSE ==============================================");
        LOGGER.info(String.format("WITH STATUS CODE %d",response.getStatusCode()));
        LOGGER.info("WITH BODY");
        LOGGER.info(response.getBody().prettyPrint());
        LOGGER.info("================================================================================================");
        return response;
    }
}
