package com.bjpowernode;

import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        //指定要执行的sql语句的标签，SQL映射文件中的namespace+","+标签的ID值
        String sqlId="com.bjpowernode.dao.StudentDao.selectStudents";
        //执行SQL语句，通过sqlId执行
         List<Student> studentList = sqlSession.selectList(sqlId);
        //输出结果
      //  studentList.forEach(stu -> System.out.println(stu));
        for(Student stu:studentList){
            System.out.println(stu);
        }
        //关闭
        sqlSession.close();
    }
}
