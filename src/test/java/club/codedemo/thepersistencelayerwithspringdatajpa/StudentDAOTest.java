package club.codedemo.thepersistencelayerwithspringdatajpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentDAOTest {
    @Autowired
    StudentDAO studentDAO;
    private Student student;

    @BeforeAll
    void beforeAll() {
        student = new Student();
        student.setName("zhangsan");
        this.studentDAO.save(student);
    }

    @Test
    void findByName() {
        Assertions.assertEquals("zhangsan",
                this.studentDAO.getOne(student.getId()).getName());
    }

    @Test
    void retrieveByName() {
        Assertions.assertNotNull(this.studentDAO.retrieveByName("Zhangsan"));
        Assertions.assertNotNull(this.studentDAO.retrieveByName("zhangSan"));
    }

    /**
     * 由于Student实体中要求name字段不能为null
     * 所以保存一个name字段为null的默认学生实体时，将会发生DataIntegrityViolationException异常
     */
    @Test
    void givenStudentHaveNoName() {
        Student student = new Student();
        Assertions.assertThrows(DataIntegrityViolationException.class,
                () -> this.studentDAO.save(student));
    }
}