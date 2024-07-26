package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        requiredStatus = true;
        addValidations("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive(){
        addValidations("positive", num -> num > 0);
        return this;
    }

    public NumberSchema range(int minRange, int maxRange) {
        if (maxRange < minRange) throw new IllegalArgumentException("MinRange должен быть меньше MaxRange!");
        addValidations("range", num -> num >= minRange && num <= maxRange);
        return this;
    }
}
