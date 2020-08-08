package club.codedemo.thepersistencelayerwithspringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 操作学生表的DAO
 *
 * @author panjie
 */
public interface StudentDAO extends JpaRepository<Student, Long> {
    /**
     * 通过姓名查找某个学生
     *
     * @param name 学生姓名
     * @return
     */
    Student findByName(String name);

    /**
     * 通过用户名查找学生
     * 学生实体并无username字段，所以此方法在调用时将报一个异常
     * 若要测试此方法，仅需要去除方法前的注释，重新启动任意单元测试即可
     *
     * @param username 用户名
     * @return
     */
//    Student findByUsername(String username);

    /**
     * 不区分大小写的根据name查询某个学生
     * 比如通过Zhangsan可以查询出学生名为zhangsan、zhangSan等的学生
     *
     * @param name 学生姓名
     * @return
     */
    @Query("SELECT s FROM Student s WHERE LOWER(s.name) = LOWER(:name)")
    Student retrieveByName(@Param("name") String name);
}