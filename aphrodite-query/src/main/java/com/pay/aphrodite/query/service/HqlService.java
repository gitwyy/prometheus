package com.pay.aphrodite.query.service;

import java.util.List;
import java.util.Map;


public interface HqlService {
    public long insert(String hql);

    public List<Map<String,String>> get(String hql);

    public List<Map<String, String>> load(String hql, String localPath);
}
