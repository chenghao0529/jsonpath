package com.chenghao.jsonpath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonpathApplicationTests {
    /**
     * {
     * 	"person": [{
     * 			"name": "chenghao",
     * 			"age": "18"
     *                }, {
     * 			"name": "kewenjia",
     * 			"age": 28
     *        }]
     * }
     */
    private String jsonStr="{\n" +
            "\t\"person\": [{\n" +
            "\t\t\t\"name\": \"chenghao\",\n" +
            "\t\t\t\"age\": \"18\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"name\": \"kewenjia\",\n" +
            "\t\t\t\"age\": 28\n" +
            "\t\t}\n" +
            "\n" +
            "\t]\n" +
            "}";

    @Test
    public void testJsonPath() {
        //获取所有的年纪
        Object ages = JsonPath.read(jsonStr, "$.person[*].age");
        System.out.println(ages);
        //获取chenghao的age
        Object age1 = JsonPath.read(jsonStr, "$.person[0].age");
        System.out.println(age1);
        //利用parse将自动尝试将结果转换为调用者预期的类型
        int age2 = JsonPath.parse(jsonStr).read("$.person[1].age");
        System.out.println(age2);
        //修改json指定的值
        DocumentContext documentContext = JsonPath.parse(jsonStr).set("$.person[1].age", 38);
        System.out.println(documentContext.jsonString());
    }
}
