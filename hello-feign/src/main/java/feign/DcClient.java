package feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//定义一个feign接口
@FeignClient("hello-service")   //通过@ FeignClient（“服务名”），来指定调用哪个服务
public interface DcClient {
    @GetMapping("/hello")
    String consumer();

    /**
     * @RequestMapping(value = "/hello",method = RequestMethod.GET)
         String consumer();
     //带参数@RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
     */
}
