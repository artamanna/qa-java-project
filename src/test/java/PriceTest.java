package praktikum;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
    public class PriceTest {
        @Mock private Bun bun;
        private Burger burger;
        @Mock
        private Ingredient ingredient;
        private final float bunPrice;
        private final float ingredientPrice;
        private final float totalPrice;

        public PriceTest(float bunPrice, float ingredientPrice, float totalPrice) {
            this.bunPrice = bunPrice;
            this.ingredientPrice = ingredientPrice;
            this.totalPrice = totalPrice;
        }

        @Parameterized.Parameters(name = "Buns: {0}, Ingredients: {1}, Total: {2}")
            public static Collection<Object[]> data() {
                return Arrays.asList(new Object[][] {
                    { 0.0f, 0.0f, 0.0f },
                    { 100.0f, 600.0f, 800.0f },
                    { 200.0f, 0.0f, 400.0f },
                    { 0.0f, 200.0f, 200.0f }
                });
        }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();}

    @Test
    public void rightGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(totalPrice, burger.getPrice(), 0.001f);
    }
}