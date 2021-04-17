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

