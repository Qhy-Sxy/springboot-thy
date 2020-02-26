package com.aaa.controller;

import com.aaa.entity.ClassDB;
import com.aaa.entity.ClassVO;
import com.aaa.entity.GradeDB;
import com.aaa.service.ClassService;
import com.aaa.service.GradeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/9/16 - 17:14
 */
@Controller
public class ClassController {
    @Autowired
    ClassService classService;
    @Autowired
    GradeService gradeService;
    @RequestMapping("findClassId/{id}")
    @ResponseBody
    public ClassVO findClassId(@PathVariable("id") Integer id)throws Exception {
        ClassVO classVO = classService.findClassId(id);
        return classVO;
    }
    //查询所有值
    @RequestMapping("findClassAll")
    @ResponseBody
    public  List<ClassVO> findClassAll()throws Exception {
        List<ClassVO> classes = classService.findAll();
        return  classes;
    }
    //接收传值
    @RequestMapping("insertClass")
    @ResponseBody
    public void insertClass(ClassVO classVO){
      //  String ClassName=classV.getClassname();
        System.out.println(classVO.getClassname()+classVO.getBegintime()+classVO.getEndtime()+classVO.getGradeid());
    }
    //查询
    @RequestMapping("findall")
    public String findall(Integer currentPage, Model model){
        if(currentPage==null){
            currentPage=1;
        }
        PageHelper.startPage(currentPage,5);
        List<ClassVO> classes = classService.findAll();
        PageInfo pageInfo = new PageInfo(classes);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
   //添加
   @RequestMapping("addclass")
   public String add(Model model){
       List<GradeDB> gs = gradeService.findall();
       model.addAttribute("gs",gs);
       return "add";
   }
    @RequestMapping("add_do")
    public String add_do(ClassVO classVO){
        classService.add(classVO);
        return "redirect:findall";
    }
    //删除
    @RequestMapping("delClass")
    public String delClass(Integer classid){
        classService.delClass(classid);
        return "redirect:findall";
    }
    //修改
    @RequestMapping("updClass")
    public String updClass(Integer classid, Model model){
        List<GradeDB> gs2 = gradeService.findall();
        ClassDB cla=classService.selectClass(classid);
        model.addAttribute("cla",cla);
        model.addAttribute("gs2",gs2);
        return "updateClass";
    }
    @RequestMapping("upd_do")
    public String upd_do(ClassDB classDB){
        classService.updateClass(classDB);
        return "redirect:findall";
    }
    @RequestMapping("delall")
    @ResponseBody
    public String delall(String ids){
        String[] str_ids=ids.split(",");
        List<Integer> int_ids = new ArrayList<>();
        for (int i = 0; i < str_ids.length; i++) {
            int_ids.add(Integer.parseInt(str_ids[i]));
        }
        classService.delall(int_ids);
        return "success";
    }
}
