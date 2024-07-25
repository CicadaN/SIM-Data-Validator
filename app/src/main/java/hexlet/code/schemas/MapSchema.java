package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, Object>> {
    private boolean required;
    private Integer size;
    private Map<String, BaseSchema<?>> schemas = new HashMap<>();

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeOf(Integer size) {
        this.size = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        this.schemas = schemas;
        return this;
    }

    @Override
    public boolean isValid(Map<String, Object> value) {
        if (required && value == null) {
            return false;
        }
        if (value != null) {
            if (size != null && value.size() != size) {
                return false;
            }
            if (!schemas.isEmpty()) {
                for (Map.Entry<String, BaseSchema<?>> entry : schemas.entrySet()) {
                    String key = entry.getKey();
                    BaseSchema<?> schema = entry.getValue();
                    if (!value.containsKey(key)) {
                        return false;
                    }
                    if (!schema.isValid(value.get(key))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}