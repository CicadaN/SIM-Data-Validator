package hexlet.code.schemas;

public abstract class BaseSchema<T> {
//    private boolean required;
//
//    public BaseSchema<T> required() {
//        this.required = true;
//        return this;
//    }
    public abstract boolean isValid(T value);
}