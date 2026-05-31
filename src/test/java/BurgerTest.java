package praktikum;

import org.junit.Before;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;


@RunWith(MockitoJUnitRunner.class)
    public class BurgerTest {
        @Mock
        private Bun bun;
        private Burger burger;
        @Mock
        private Ingredient firstIngredient;
        @Mock
        private Ingredient secondIngredient;

        @Before
            public void setUp() {
                burger = new Burger();
            }

        @Test
            public void setOnlyBuns() {
                burger.setBuns(bun);
                assertEquals(bun, burger.bun);
            }

        @Test
            public void addOneIngredient() {
                burger.addIngredient(firstIngredient);
                assertTrue(burger.ingredients.contains(firstIngredient));
            }

        @Test
            public void removeOneIngredient() {
                burger.addIngredient(firstIngredient);
                burger.removeIngredient(0);
                assertTrue(burger.ingredients.isEmpty());
            }

        @Test
            public void moveFirstIngredient() {
                burger.addIngredient(firstIngredient);
                burger.addIngredient(secondIngredient);
                burger.moveIngredient(0, 1);
                assertEquals(secondIngredient, burger.ingredients.get(0));
            }

        @Test
            public void moveSecondIngredient() {
                burger.addIngredient(firstIngredient);
                burger.addIngredient(secondIngredient);
                burger.moveIngredient(0, 1);
                assertEquals(firstIngredient, burger.ingredients.get(1));
            }

        @Test
            public void increaseByOne() {
                burger.addIngredient(firstIngredient);
                assertEquals(1, burger.ingredients.size());
            }
}