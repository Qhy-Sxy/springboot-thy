package com.aaa.service.impl;

import com.aaa.entity.ClassDB;
import com.aaa.entity.ClassVO;
import com.aaa.mapper.ClassMapper;
import com.aaa.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/9/16 - 17:09
 */
@Service
@Transactional
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;
    @Override
    public List<ClassVO> findAll() {
        return classMapper.findAll();
    }

    @Override
    public int add(ClassVO classVO) {
        return classMapper.add(classVO);
    }

    @Override
    public void delClass(Integer classid) {
        classMapper.delClass(classid);
    }

    @Override
    public ClassDB selectClass(Integer classid) {
        return classMapper.selectClass(classid);
    }

    @Override
    public void updateClass(ClassDB classDB) {
        classMapper.updateClass(classDB);
    }

    @Override
    public void delall(List<Integer> int_ids) {
        classMapper.delall(int_ids);
    }

    @Override
    public ClassVO findClassId(int i) {
        return classMapper.findClassId(i);
    }
}
