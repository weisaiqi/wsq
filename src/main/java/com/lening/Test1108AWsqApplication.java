package com.lening;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lening.mapper")
public class Test1108AWsqApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test1108AWsqApplication.class, args);
    }

}
