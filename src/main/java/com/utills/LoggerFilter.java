package com.utills;

import com.jayway.restassured.filter.Filter;
import com.jayway.restassured.filter.FilterContext;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.FilterableRequestSpecification;
import com.jayway.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class LoggerFilter implements Filter {

    private static Logger log = Logger.getLogger(LoggerFilter.class);

    private String headerNameKey;
    private String sessionNameKey;
    private String sessionIdKey;
    private String tokenNameKey;

    private String sessionName;
    private String sessionId;
    private String token;

    public LoggerFilter(String headerName,
                        String sesNameKey,
                        String sesIdKey,
                        String tokenKey) {
        headerNameKey = headerName;
        sessionNameKey = sesNameKey;
        sessionIdKey = sesIdKey;
        tokenNameKey = tokenKey;
    }

    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec, FilterContext ctx) {

        if (StringUtils.isNotBlank(sessionName) &&
                StringUtils.isNotBlank(sessionId) &&
                StringUtils.isNotBlank(token)) {

            Headers headers = requestSpec.getHeaders();
            if (!headers.hasHeaderWithName(headerNameKey)) {

                requestSpec.header(new Header(headerNameKey, token));
            }
            return ctx.next(requestSpec, responseSpec);

        } else {
            final Response response = ctx.next(requestSpec, responseSpec);
            String json = response.asString();
            JsonPath jsonPath = new JsonPath(json);

            sessionName = jsonPath.getString(sessionNameKey);
            sessionId = jsonPath.getString(sessionIdKey);
            token = jsonPath.getString(tokenNameKey);

            log.debug(String.format("Got sessionName: %s, sessionId: %s, token: %s",
                    StringUtils.abbreviate(sessionName, 10),
                    StringUtils.abbreviate(sessionId, 10),
                    StringUtils.abbreviate(token, 10)
            ));
            return response;
        }
    }
}
