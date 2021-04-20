# 知识点

### mybatis-plus 逻辑删除
```yaml
mybatis-plus:
  global-config:
    db-config:
      logic-delete-value: 1  # 逻辑已删除（默认为1）
      logic-not-delete-value: 0  # 逻辑未删除 （默认为0）
```


```java
    // 在对应的逻辑删除字段加上注解
    class Table {
        @TableLogic
        private Integer colume;
    }
```

## 后端校验
JSR303
1. 给Bean 加上校验注解
   在 javax.validation.constraints 包下的注解
2. 在controller 给接收实体加上 @Valid   
3. 在controller 给校验的Bean后, 紧跟一个参数 BindingResult , 可以获取到校验的结果

> 分组校验功能
1. 给校验注解标注 groups 
2. @Valid  修改为   @Validated(AddGroup.class)   

> 自定义校验注解
1. 编写一个自定义的校验注解
2. 编写一个自定义的校验器
3. 关联自定义的校验器和校验注解

## 同一异常处理
@ControllerAdvice
