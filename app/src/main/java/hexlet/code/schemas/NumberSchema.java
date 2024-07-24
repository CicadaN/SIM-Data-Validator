package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean required;
    private boolean positive;
    private Integer minRange, maxRange;

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive(){
        this.positive = true;
        return this;
    }

    public NumberSchema range(int minRange, int maxRange) {
        if (maxRange < minRange) throw new IllegalArgumentException("MinRange должен быть меньше MaxRange!");
        this.minRange = minRange;
        this.maxRange = maxRange;
        return this;
    }

    @Override
    public boolean isValid(Integer value){
        if (this.required && value == null) {
            return false;
        }
        if (value != null) {
            if (this.positive && value <= 0) return false;
            if (minRange != null || maxRange != null) {
                if (value < minRange || value > maxRange){
                    return false;
                }
            }
        }
        return true;
    }
}
