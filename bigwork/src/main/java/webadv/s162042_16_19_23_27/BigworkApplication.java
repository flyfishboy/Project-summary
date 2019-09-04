package webadv.s162042_16_19_23_27;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("webadv.s162042_16_19_23_27_repository")
@MapperScan("webadv.s162042_16_19_23_27")
public class BigworkApplication {
	public static void main(String[] args) {
		SpringApplication.run(BigworkApplication.class, args);
	}

}
