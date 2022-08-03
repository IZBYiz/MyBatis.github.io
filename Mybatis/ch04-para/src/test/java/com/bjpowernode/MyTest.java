package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void select(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);//动态绑定机制
        Student student = dao.selectStudentById(1002);
        System.out.println(student);
    }
    @Test
    public void  selectMulitParam(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectMulitParam("李四", 20);
        for (Student o :student) {
            System.out.println(o);
        }
       sqlSession.close();
    }
    @Test
    public void selectMultiObject(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        QueryParam pa=new QueryParam(); //创建对象
        pa.setParamName("张三");
        pa.setParamAge(28);
        List<Student> studentList=dao.selectMultiObject(pa);
        for (Student student :studentList) {
            System.out.println(student);
        }
    }
    @Test
    public void selectMultiPosition(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> students=dao.selectMultiPosition("张飞",20);
        for (Student student :students) {
            System.out.println(student);
        }

    }
    @Test
    public void selectMultiMap(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Map<String,Object> data=new HashMap<>();
        data.put("myname","张三");
        data.put("myage","20");
       List<Student> students=dao.selectMultiMap(data);
        for (Student student :students) {
            System.out.println(student);
        }

    }
}
