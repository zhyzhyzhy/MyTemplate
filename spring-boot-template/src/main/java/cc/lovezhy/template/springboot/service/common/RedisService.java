package cc.lovezhy.template.springboot.service.common;

import com.alibaba.fastjson.TypeReference;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    <T> T getFromCache(String key, TypeReference<T> typeReference);

    <T> T getFromCache(String key, Class<T> clazz);

    void removeFromCache(String key);

    void removeFromCacheAsync(String key);

    <T> void setToCache(String key, T value, long timeout, TimeUnit timeUnit);

    <T> void setToCache(String key, T value);

    <T> void setToCacheAsync(String key, T value, long timeout, TimeUnit timeUnit);

    <T> void setToCacheAsync(String key, T value);

    String getFromCache(String key);

    void setToCache(String key, String value, long timeout, TimeUnit timeUnit);

    void setToCacheAsync(String key, String value, long timeout, TimeUnit timeUnit);

    void setToCache(String key, String value);

    void setToCacheAsync(String key, String value);

    boolean setToCacheIfAbsent(String key, String value, long timeout, TimeUnit timeUnit);
}
