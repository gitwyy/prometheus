package com.pay.aphrodite.core.service;

import java.util.List;
import java.util.Map;

public interface HqlExecuteService {

    List<Map<String, String>> select(String hql);

    void download(String hql, String localPath);
}
