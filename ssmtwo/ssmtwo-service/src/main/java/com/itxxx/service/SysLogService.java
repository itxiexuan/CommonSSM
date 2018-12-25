package com.itxxx.service;

import com.itxxx.domain.SysLog;

import java.util.List;

public interface SysLogService {
    List<SysLog> findAll();

    void save(SysLog sysLog);
}
