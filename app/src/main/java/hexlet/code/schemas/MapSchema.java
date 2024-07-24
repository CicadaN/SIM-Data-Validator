package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private boolean required;
    private Integer sizeOf;

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeOf(Integer sizeOf) {
        this.sizeOf = sizeOf;
        return this;
    }
    @Override
    public boolean isValid(Map<?, ?> value) {
        if (this.required && value == null) {
            return false;
        }
        if (value != null) {
            if (sizeOf != null && value.size() != sizeOf) {
                return false;
            }
        }
        return true;
    }
}
