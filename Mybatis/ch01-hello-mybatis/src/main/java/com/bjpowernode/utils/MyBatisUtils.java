package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.in;


public class MyBatisUtils {
    private static SqlSessionFactory factory = null;
    private static SqlSessionFactoryBuilder builder=null;

    static {
            String config = "mybatis.xml";//需要和项目中的文件名一样
        try {
             InputStream in = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象，使用SqlSessionFactoryBuild
             builder=new SqlSessionFactoryBuilder();
             factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   //获取SqlSession的方法
    public static SqlSession getSqlSession(){
      SqlSession  sqlSession=null;
        if(factory!=null){
           sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
