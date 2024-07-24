package hexlet.code.schemas;

public class StringSchema {
    private boolean required;
    private int minLength = 0;
    private String contains;


    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }

    public boolean isValid(String value){
        if (this.required && (value == null || value.isEmpty())) {
            return false;
        } else if (value != null) {
            if (value.length() < this.minLength) return false;
            if (this.contains != null && !value.contains(this.contains)) return false;
        }
        return true;
    }
}
