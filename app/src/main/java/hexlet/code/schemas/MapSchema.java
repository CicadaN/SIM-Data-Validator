package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        requiredStatus = true;
        addValidations("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeOf(Integer size) {
        addValidations("sizeOf", map -> map.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addValidations(
                "shape",
                map -> schemas.entrySet().stream().allMatch(e -> {
                    var v = map.get(e.getKey());
                    var schema = e.getValue();
                    return schema.isValid((T) v);
                })
        );
        return this;
    }
}