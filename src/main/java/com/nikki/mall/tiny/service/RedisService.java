package com.nikki.mall.tiny.service;

/**
 * Redis操作service
 * 对象和数字都已json形式进行存储
 */
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * get value
     */
    String get(String key);

    /**
     * setup timeout
     */
    boolean expire(String key, long expire);
    /**
     * delete
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta 自增步长
     * @return
     */
    long increment(String key, long delta);

}
