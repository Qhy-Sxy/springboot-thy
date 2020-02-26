package com.aaa.service.impl;

import com.aaa.entity.GradeDB;
import com.aaa.mapper.GradeMapper;
import com.aaa.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/9/16 - 17:18
 */
@Service
@Transactional
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;
    @Override
    public List<GradeDB> findall() {
        return gradeMapper.findall();
    }
}
