package com.aaa.mapper;

import com.aaa.entity.GradeDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/9/16 - 17:15
 */
@Mapper
public interface GradeMapper {
    public List<GradeDB> findall();
}
