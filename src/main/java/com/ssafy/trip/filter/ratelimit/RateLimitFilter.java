package com.ssafy.trip.filter.ratelimit;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.ssafy.trip.exception.TooManyRequestException;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class RateLimitFilter implements Filter {
    private static final int MAX_BUCKET_SIZE = 6;
    private LoadingCache<String, Bucket> bucketMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        bucketMap = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(1, TimeUnit.MINUTES)
                .build(
                        new CacheLoader<>() {
                            @Override
                            public Bucket load(String key) throws ExecutionException {
                                return bucketMap.getIfPresent(key);
                            }
                        });
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ip = getClientIpAddr(request);
        Bucket bucket = bucketMap.getIfPresent(ip);
        System.out.println("filter");

        //1. bucket==null이면 새롭게 count
        if (bucket == null) {
            bucketMap.put(ip, new Bucket(MAX_BUCKET_SIZE - 1, System.currentTimeMillis())); //10:02
            return;
        }

        //2. bucket!=null이면
        long currentTime = System.currentTimeMillis(); //10:09
        long lastAccessOfIp = bucket.getLastAccess(); //127.0.0.1
        long diff = (currentTime - lastAccessOfIp) / 6000; //7분
        long bucketCount = bucket.getCount(); //9

        //16 -> 10 빼기전에 미리 더해서 1분마다 더하는 수행을 한번에 하도록 변경한다 - lazy
        if (bucketCount + diff >= MAX_BUCKET_SIZE) bucketCount = MAX_BUCKET_SIZE;  //10개

        if (bucketCount == 0) {
            throw new TooManyRequestException();
        }

        bucket.setCount(bucketCount - 1); //9
        bucket.setLastAccess(currentTime);
        bucketMap.put(ip, bucket); //담는다.
    }


    private static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}