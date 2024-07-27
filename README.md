### Hexlet tests and linter status:
[![Actions Status](https://github.com/CicadaN/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/CicadaN/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/f6e9d2044042ec26f306/maintainability)](https://codeclimate.com/github/CicadaN/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/f6e9d2044042ec26f306/test_coverage)](https://codeclimate.com/github/CicadaN/java-project-78/test_coverage)

# Валидатор данных

Данный проект реализует библиотеку с помощью которой можно проверить корректность различных типов данных, таких как String, Integer и Map. Этот проект реализует гибкие схемы валидации, которые можно легко настраивать и использовать для проверки соответствия данных различным условиям.


## Структура проекта

1. **BaseSchema**: Абстрактный класс для схем валидации.
2. **StringSchema**: Валидация String (наследует BaseSchema<String>).
3. **NumberSchema**: Валидация Integer (наследует BaseSchema<Integer>).
4. **MapSchema**: Валидация объектов типа Map (наследует BaseSchema<Map>).
5. **Validator**: Класс с фабричными методами для создания экземпляров схем валидации

## Использование
### Валидация строк
```java
Validator validator = new Validator();
StringSchema schema = validator.string();

schema.required().minLength(5).contains("hexlet");

boolean isValid = schema.isValid("hexlet"); // true
isValid = schema.isValid("hex"); // false
```
### Валидация строк
```java
Validator validator = new Validator();
NumberSchema schema = validator.number();

schema.required().positive().range(1, 10);

boolean isValid = schema.isValid(5); // true
isValid = schema.isValid(0); // false
isValid = schema.isValid(11); // false
```
### Валидация объектов типа Map
```java
Validator validator = new Validator();
MapSchema schema = validator.map();

schema.required().sizeOf(2);

Map<String, Object> data = new HashMap<>();
data.put("key1", "value1");
data.put("key2", "value2");

boolean isValid = schema.isValid(data); // true
```
### Вложенная валидация карт (Map)
```java
Validator v = new Validator();
var schema = v.map();

Map<String, BaseSchema<String>>  schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
boolean isValid = schema.isValid(human1); // true
```


