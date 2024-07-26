package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String>{

    public StringSchema required() {
        requiredStatus = true;
        addValidations("required", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
       addValidations("minLength", s -> s.length() >= minLength);
       return this;
    }

    public StringSchema contains(String text) {
        addValidations("contains", s -> s.contains(text));
        return this;
    }
}
