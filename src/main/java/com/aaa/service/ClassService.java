package com.aaa.service;

import com.aaa.entity.ClassDB;
import com.aaa.entity.ClassVO;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/9/16 - 17:08
 */
public interface ClassService {
    public List<ClassVO> findAll();

    public int add(ClassVO classVO);

    public void delClass(Integer classid);

    ClassDB selectClass(Integer classid);

    void updateClass(ClassDB classDB);

    void delall(List<Integer> int_ids);

    ClassVO findClassId(int i);
}
