package com.example.demo.weather;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName: WeatherQry
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/6/5 14:20
 * @Version: V1.0
 */
public class WeatherQry {

    /**
    * @Description TODO
    * @Date 14:31 2020/6/23
    * @Param [url, paramMap]
    * @return java.lang.String
    **/
    public String getWeatherByPost(String url, Map<String, Object> paramMap){
      return "";
    }
}
