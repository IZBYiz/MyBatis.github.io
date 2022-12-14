package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取student数据
        //1、定义mybatis主配置文件，从类路径的根开始(target/clasess)
        String config="mybatis.xml";
        //读取这个config表示文件
        InputStream in= Resources.getResourceAsStream(config);
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession=factory.openSession();
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
