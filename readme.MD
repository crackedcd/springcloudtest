### 简单的Spring Cloud demo.


---


- 通过mapi访问mdc, 配置是mconfigserver/mconfigclient.

- 环境 springboot2.0.2, jdk10.

- 工程启动后, 通过http://localhost:8902/hi?name=aaa访问


---


-  springboot2.0.2, eureka的pom名称改成了:

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;不能直接抄网上的.

-  jdk9之后, 把javaEE的模块移出了默认的path下, 因此需要在jvm的选项里面增加:

>    --add-modules java.xml.bind

-  eureka有自我保护机制(https://github.com/Netflix/eureka/wiki/Understanding-Eureka-Peer-to-Peer-Communication), 可通过将eureka.server.enable-self-preservation置为false来关闭. 但生产环境应该打开这个保护机制.

-  feign基于接口, @FeignClient的value参数指定提供服务的服务名, @RequestMapping的value参数指定提供服务的API(controller).

-  配置中心的config-server可配置git/svn/native等方式. config-client的配置需要修改bootstrap.properties(因其在Spring Cloud中, 由父Spring ApplicationContext加载, 优先级高于application.properties). config-client的启动如果依赖config-server的配置(例如使用了@Value("{}")注解), 那么一定要config-server启动完成后, config-client才可以启动.

-  eureka server的高可用, 是在server的classpath中同时指定两个properties文件, 在两个文件中的spring.application.name一致, eureka.client.serviceUrl.defaultZone分别设置为对方.
    配置hosts:

>    127.0.0.1    eureka.server.primary
>   127.0.0.1    eureka.server.secondary

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过设置jvm参数, 启动两个eureka server:

>    java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=primary
>    java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=secondary

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;若启动成功, 可在界面的DS Replicas中看到备用server的情况. 然后将服务注册到任意一个eureka server即可.


