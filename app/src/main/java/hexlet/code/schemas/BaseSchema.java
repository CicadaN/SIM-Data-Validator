package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean requiredStatus = false;
    protected Map<String, Predicate<T>> validations = new LinkedHashMap<>();

    public final boolean isValid(T value) {
        if (value == null) {
            return !requiredStatus;
        } else {
            return validations.values()
                    .stream()
                    .allMatch(validation -> validation.test(value));
        }
    }

    protected final void addValidations(String name, Predicate<T> check) {
        validations.put(name, check);
    }
}
