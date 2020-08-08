package club.codedemo.thepersistencelayerwithspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 测试EnableJpaRepositories注解时，请 注释/启用 11,12,13,14行后
 * 分别查看单元测试EnableJpaRepositoriesTest中获取bean的效果
 */
@SpringBootApplication
@EnableJpaRepositories(
		basePackages = {"club.codedemo.repository",
				"club.codedemo.thepersistencelayerwithspringdatajpa"}
)
public class ThePersistenceLayerWithSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThePersistenceLayerWithSpringDataJpaApplication.class, args);
	}

}
