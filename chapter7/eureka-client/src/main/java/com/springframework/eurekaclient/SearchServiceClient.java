package com.springframework.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="${search.service.name}")
public interface SearchServiceClient {

    @RequestMapping(value = "/search/get", method = RequestMethod.POST)
    Flight[] search(SearchQuery query);
}
