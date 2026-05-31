package praktikum;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
    public class ReceiptTest {
        @Mock
        private Bun bun;
        private Burger burger;
        private final String bunName;
        private final float bunPrice;
        @Mock
        private Ingredient ingredient;
        private final String ingredientName;
        private final float ingredientPrice;
        private final IngredientType ingredientType;
        private final String rightReceipt;
        static String newline = System.lineSeparator();

    public ReceiptTest(String bunName, float bunPrice, IngredientType ingredientType, String ingredientName,
                       float ingredientPrice, String expectedReceipt) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.rightReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                {"black bun", 100.0f, IngredientType.SAUCE, "sour cream", 200.0f,
                        "(==== black bun ====)"+newline+"= sauce sour cream ="+newline+"(==== black bun ====)" +
                                newline+newline+"Price: 400.000000"+newline},
                {"white bun", 200.0f, IngredientType.FILLING,"sausage", 300.0f,
                       "(==== white bun ====)"+newline+"= filling sausage ="+newline+"(==== white bun ====)" +
                               newline+newline+"Price: 700.000000"+newline},
                {"red bun", 300.0f, IngredientType.FILLING, "dinosaur", 200.0f,
                       "(==== red bun ====)"+newline+"= filling dinosaur ="+newline+"(==== red bun ====)" +
                               newline+newline+"Price: 800.000000"+newline}
            });
        }

    @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);
            burger = new Burger();}

    @Test
        public void rightGetReceipt() {
            Mockito.when(bun.getName()).thenReturn(bunName);
            Mockito.when(bun.getPrice()).thenReturn(bunPrice);
            Mockito.when(ingredient.getType()).thenReturn(ingredientType);
            Mockito.when(ingredient.getName()).thenReturn(ingredientName);
            Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
            burger.setBuns(bun);
            burger.addIngredient(ingredient);
            assertEquals(rightReceipt, burger.getReceipt());
        }
}