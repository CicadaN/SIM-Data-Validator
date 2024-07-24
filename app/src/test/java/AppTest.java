import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid("")); // true
        assertTrue(schema.isValid(null)); // true

        schema.required();
        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid("")); // false
        assertTrue(schema.isValid("what does the fox say")); // true
        assertTrue(schema.isValid("hexlet")); // true

        schema.contains("wh");
        assertTrue(schema.isValid("what does the fox say")); // true
        schema.contains("whatthe");
        assertFalse(schema.isValid("what does the fox say")); // false

        StringSchema schema1 = v.string();
        schema1.minLength(10).minLength(4);
        assertTrue(schema1.isValid("Hexlet")); // true

        schema1.minLength(10).minLength(8);
        assertFalse(schema1.isValid("Hexlet")); // false


    }
}
