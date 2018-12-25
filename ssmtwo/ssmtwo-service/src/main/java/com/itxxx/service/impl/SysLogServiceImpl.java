package com.itxxx.service.impl;

import com.itxxx.dao.SysLogDao;
import com.itxxx.domain.SysLog;
import com.itxxx.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public List<SysLog> findAll() {
        List<SysLog> list = sysLogDao.findAll();
        return list;
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}
