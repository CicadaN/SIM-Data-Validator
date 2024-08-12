### Hexlet tests and linter status:
[![Actions Status](https://github.com/CicadaN/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/CicadaN/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/f6e9d2044042ec26f306/maintainability)](https://codeclimate.com/github/CicadaN/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/f6e9d2044042ec26f306/test_coverage)](https://codeclimate.com/github/CicadaN/java-project-78/test_coverage)

# Data Validator

This project implements a library that allows you to check the validity of various data types, such as String, Integer, and Map. The project features flexible validation schemas that can be easily customized and used to verify that data meets various conditions.

## Project Structure

1. **BaseSchema**: An abstract class for validation schemas.
2. **StringSchema**: Validation for Strings (inherits from BaseSchema<String>).
3. **NumberSchema**: Validation for Integers (inherits from BaseSchema<Integer>).
4. **MapSchema**: Validation for Map objects (inherits from BaseSchema<Map>).
5. **Validator**: A class with factory methods for creating instances of validation schemas.

## Usage Examples:

### Validation of Strings
```java
Validator validator = new Validator();
StringSchema schema = validator.string();

schema.required().minLength(5).contains("hexlet");

boolean isValid = schema.isValid("hexlet"); // true
isValid = schema.isValid("hex"); // false
```
### Validation of Number
```java
Validator validator = new Validator();
NumberSchema schema = validator.number();

schema.required().positive().range(1, 10);

boolean isValid = schema.isValid(5); // true
isValid = schema.isValid(0); // false
isValid = schema.isValid(11); // false
```
### Validation of Map type objects
```java
Validator validator = new Validator();
MapSchema schema = validator.map();

schema.required().sizeOf(2);

Map<String, Object> data = new HashMap<>();
data.put("key1", "value1");
data.put("key2", "value2");

boolean isValid = schema.isValid(data); // true
```
### Nested Map Validation (Map)
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


