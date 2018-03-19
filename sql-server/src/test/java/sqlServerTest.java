import com.hisense.sql.sqlApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.hisense.sql.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.HashMap;
import java.util.Map;
//import springfox.documentation.spring.web.json.Json;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = sqlApplication.class
        ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class sqlServerTest {
    @Autowired
    public TestRestTemplate restTemplate;
//    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void contextLoads() {
        list();
        add();
        update();
        delete();
    }

    public void add() {
        String url = "http://127.0.0.1:2244/add";
        String json = "{\n" +
                "    \"userCode\": \"user1\",\n" +
                "    \"userId\": \"1111\",\n" +
                "    \"age\": 20,\n" +
                "    \"mail\": \"mail@qq.com\",\n" +
                "    \"phone\": \"12341234123\"\n" +
                "}";
        JsonResult result = postJson(url, json);
        System.out.println("/add");
        System.out.println(JsonUtils.objectToJson(result));
    }

    public void update() {
        String url = "http://127.0.0.1:2244/update";
        String json = "{\n" +
                "\t\"userId\": \"2\",\n" +
                "    \"userCode\": \"zxc\",\n" +
                "    \"age\": 19,\n" +
                "    \"mail\": \"111@ss.com\",\n" +
                "    \"phone\": \"12312312312\"\n" +
                "}";
        JsonResult result = postJson(url, json);
        System.out.println("/update");
        System.out.println(JsonUtils.objectToJson(result));
    }


    public void delete() {
        String url = "http://127.0.0.1:2244/delete";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("userCode", "user");
        JsonResult result = postParam(url, map);
        System.out.println("/delete");
        System.out.println(JsonUtils.objectToJson(result));
//        System.out.println(result);

    }

    public void list() {
        String url = "http://127.0.0.1:2244/list";
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", 1);
        map.put("pagesize", 10);
        JsonResult json = getJsonByGet(url, map);
        System.out.println("/list");
        System.out.println(JsonUtils.objectToJson(json));
    }

    public JsonResult getJsonByGet(String url, Map map) {
        return this.restTemplate.getForObject(url, JsonResult.class, map);
    }

    public JsonResult postJson(String url, String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        return this.restTemplate.postForObject(url, entity, JsonResult.class);
    }

    public JsonResult postParam(String url, Object params) {
        return this.restTemplate.postForObject(url, params, JsonResult.class);
    }
}
