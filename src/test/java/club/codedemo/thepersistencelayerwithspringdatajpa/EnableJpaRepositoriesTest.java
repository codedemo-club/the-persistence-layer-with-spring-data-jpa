package club.codedemo.thepersistencelayerwithspringdatajpa;

import club.codedemo.repository.KlassDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnableJpaRepositoriesTest {
    @Autowired
    KlassDAO klassDAO;

    /**
     * 当在ThePersistenceLayerWithSpringDataJpaApplication中
     * 启用EnableJpaRepositories注解时，klassDAO不为null，注入成功
     * 未启用EnableJpaRepositories注解时，启动此单元测试将发生异常，注入失败
     */
    @Test
    void test() {
        System.out.println(klassDAO);
    }
}
