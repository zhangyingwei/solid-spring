# solid-spring

# 使用指南

## 新建一个config

```text
@Configuration
public class MyConfig {
    @Bean(name = "solidConfiguration")
    public SolidConfiguration templateBuilder(ApplicationContext ctx) {
        SolidConfiguration configuration = new SolidConfiguration(
                new FileTemplateResourceLoader("src/main/resources")
        );
        return configuration;
    }
    @Bean
    public SprintSolidTemplateResolver getViewResolver(@Qualifier("solidConfiguration") SolidConfiguration configuration) {
        TemplateResolver templateResolver = new TemplateResolver(configuration);
        templateResolver.setSuffix(".html");
        templateResolver.setPrefix("templates");
        return new SprintSolidTemplateResolver(templateResolver);
    }
}
```

## Controller

```text
@Controller
public class DemoController {
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView model) {
        System.out.println("index controller");
        model.addObject("username", "张英伟");
        model.addObject("password", "123456");
        model.setViewName("index");
        return model;
    }
}
```
