package com.itxxx.dao;

import com.itxxx.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id = #{memberId}")
    Member findById(String memberId);
}
