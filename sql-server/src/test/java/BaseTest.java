import com.hisense.sql.controller.TestController;
import com.hisense.sql.domain.JsonResult;
import com.hisense.sql.domain.JsonUtils;
import com.hisense.sql.sqlApplication;
import org.codehaus.jettison.json.JSONObject;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = sqlApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class BaseTest {

    @Autowired
    public TestRestTemplate restTemplate;

    public Logger logger= LoggerFactory.getLogger(this.getClass());

    protected JSONObject getJsonByGet(String url)
    {
        return this.restTemplate.getForObject(url,JSONObject.class);
    }

    private ResponseEntity postEntityByForm(LinkedMultiValueMap map,String url)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<Map> formEntity = new HttpEntity<>(map,headers);
        return this.restTemplate.postForEntity(url,formEntity,String.class);
    }

    public JsonResult postJson(String url,String json)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<>(json,headers);
        return  this.restTemplate.postForObject(url,entity,JsonResult.class);
    }

    public void add()
    {
        String url = "http://localhost:1234/add";
        String json = "{\"userCode\":\"code\",\"age\":\"19\",\"userId\":\"123\"}";
        JsonResult result = postJson(url,json);
        System.out.println(JsonUtils.objectToJson(result));
    }

    public void update()
    {

    }

    public void list()
    {

    }

    public void detail()
    {

    }

    public void del()
    {

    }

    @Test
    public void coreTest()
    {

        add();
        update();
        list();
        detail();
        del();
    }

}











