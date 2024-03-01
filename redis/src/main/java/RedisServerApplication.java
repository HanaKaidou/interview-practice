import com.titan.server.common.config.executor.TaskThreadPoolConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 启动器
 *
 * @author: ChangShiHao
 * @date: 2022/2/23 16:32
 */
@SpringBootApplication
@MapperScan(value = {"com.titan.server.**.mapper"})
@ComponentScan({"com.titan"})
@EnableAsync//开启异步线程支持
@EnableConfigurationProperties({TaskThreadPoolConfig.class})//开启配置属性支持
@EnableScheduling
@EnableFeignClients
public class RedisServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisServerApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }


    /**
     * 添加URL特殊字符放行
     *
     * @param
     * @Return org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
     * @Author Chang ShiHao
     * @Date 19:37 2023/2/15
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]\\"));
        return factory;
    }

}
