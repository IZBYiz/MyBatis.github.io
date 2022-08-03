package com.bjpowernode.dao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface StudentDao {
   /**
    * 一个简单的类型参数：
    *     简单类型：mybatis把Java的基础数据类型和String都叫简单类型
    * 在mapper文件中获取简单类型一个参数值，使用#{任意字符}
    * @param id
    * @return int
    */
   public Student selectStudentById(Integer id);
   /**
    * 多个参数：命名参数，在形参定义的前面加入@param("自定义参数名称")
    */
   List<Student> selectMulitParam(@Param("myname") String name,
                                  @Param("myage") Integer age);

   ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

     int countStudent();

     //定义方法返回值 Map
   Map<Object,Object> selectMapById(Integer stuid);


    /**
     * 使用resultMap定义映射关系
     */
    List<Student> selectAllStudents();
    //列名不一样的第一种方法
    List<MyStudent>  selectStudents();
    //列名不一样的第二种方法
    List<MyStudent> selectDiffColProperty();

    /**第一种模糊查询*/
    List<Student> selectLikeOne(String name);

    /**name就是李，在mapper中拼接 like "%"李"%" */
    List<Student> selectLikeTwo(String name);
}
