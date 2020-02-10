package deverour;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("deverour.mapper")
public class SpringbootBillsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBillsApplication.class, args);
    }

}
