package com.itxxx.dao;

import com.itxxx.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {
    @Select("select * from sysLog")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="visitTime",property="visitTime"),
            @Result(column="ip",property="ip"),
            @Result(column="url",property="url"),
            @Result(column="executionTime",property="executionTime"),
            @Result(column="method",property="method"),
            @Result(column="username",property="username")
    })
    List<SysLog> findAll();

    @Insert("insert into sysLog(visitTime,ip,url,executionTime,method,username) values(#{visitTime},#{ip},#{url},#{executionTime},#{method},#{username})")
    void save(SysLog sysLog);
}
