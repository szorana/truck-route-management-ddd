package com.example.routesmanagement.xport.client;

import com.example.routesmanagement.domain.valueObjects.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class GoodsClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public GoodsClient(@Value("${app.goods-catalog.url}") String serverUrl){
        this.serverUrl=serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri(){
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Goods> getAll(){
        try {
            return restTemplate.exchange(uri().path("/api/goods").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Goods>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }
}
