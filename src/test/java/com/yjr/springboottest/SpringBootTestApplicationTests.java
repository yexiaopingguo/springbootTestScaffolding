package com.yjr.springboottest;

import com.yjr.springboottest.entity.Student;
import io.lettuce.core.ScriptOutputType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Test
    public void testMongoConnection() {
        System.out.println("nb");
    }

}
