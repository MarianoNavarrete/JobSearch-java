package com.Mariano.jobSearch.API;

import com.Mariano.jobSearch.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface APIJOBS {
    @RequestLine("GET /positions.json")
    public List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
}
