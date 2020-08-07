

[TOC]



## 1 spring boot 项目构建

### 1.1 pom 依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
  <!-- Inherit defaults from Spring Boot -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.4.RELEASE</version>
        <relativePath/>
    </parent>

    <artifactId>spring-boot-example</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>spring-boot-example</name>
    <description>spring boot example </description>


    <!-- Add typical dependencies for a web application -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <!-- Package as an executable jar -->
    <build>
        <finalName>spring-boot-example</finalName>

        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

### 1.2 启动类

```java
@RestController
@SpringBootApplication
public class SpringBootBootStrapExample {

    public static void main(String[] args) {
		SpringApplication.run(SpringBootBootStrapExample.class, args);
    }


    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


}
```



## 2 spring boot 部署注意事项

### 2.1 spring-boot 项目 war包启动

1 修改打包方式为 war  

```xml
<packaging>war</packaging>
```

2 启动类继承SpringBootServletInitializer 并Override configure方法 如下

```java
public class SpringBootBootStrapExample extends SpringBootServletInitializer {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootBootStrapExample.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootBootStrapExample.class);
    }
```

3 将 spring-boot-starter-tomcat 依赖改为<scope>provided</scope>

```xml
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
</dependency>
```

### 2.2 spring-boot 热部署

1 添加依赖 spring-boot-devtools 依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

2 设置不重启

```java
public static void main(String[] args) {
    System.setProperty("spring.devtools.restart.enabled", "false");
    SpringApplication.run(MyApp.class, args);
}
```



##   3 spring boot 注入bean

###  3.1 注入Servlet,Filter,*Listener

####  3.1.1 通过 *RegistrationBean

**ServletRegistrationBean**，**FilterRegistrationBean**, **ServletListenerRegistrationBean**

**Servlet ServletRegistrationBean**  

```java
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet());
        servletRegistrationBean.addUrlMappings("/service");
        return servletRegistrationBean;
    }
```

**Filter  FilterRegistrationBean**

```java
    @Bean
    public FilterRegistrationBean myFileter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
```

**Listener ServletListenerRegistrationBean** 

```java
    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }
```

#### 3.1.2 embedded containe 嵌入容器 (tomcat jetty)  jar启动

> 注: war 启动不适用
>
> @WebServlet, @WebFilter, and @WebListener

