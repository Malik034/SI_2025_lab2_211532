import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SILab2Test {

    //EveryStatement Test
    @Test
    public void testAllItemsNullThrows(){
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
    }

    @Test
    public void testInvalidItemName() {
        List<Item> items = List.of(new Item(null, 1, 100, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, "1234567890123456"));
    }

    @Test
    public void testPriceOver300() {
        List<Item> items = List.of(new Item("TV", 1, 400, 0));
        assertEquals(370, SILab2.checkCart(items, "1234567890123456"));
    }

    @Test
    public void testDiscountCalculation() {
        List<Item> items = List.of(new Item("Shoes", 2, 100, 0.5));
        double result = SILab2.checkCart(items, "1234567812345678");
        assertEquals(70, result);
    }

    @Test
    public void testCardNumberInvalidCharacter() {
        List<Item> items = List.of(new Item("Pen", 1, 10, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, "1234abcd90123456"));
    }

    @Test
    public void testValidItemNoDiscount() {
        List<Item> items = List.of(new Item("Apple", 2, 100, 0));
        assertEquals(200, SILab2.checkCart(items, "1234567890123456"));
    }

    @Test
    public void testInvalidCardNumber() {
        List<Item> items = List.of(new Item("Notebook", 1, 50, 0));
        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "1234"));
    }

    // MultipleCondition Test
    @Test
    public void testAFalseBFalseCFalse() {
        Item item = new Item("Item1", 1, 100, 0);
        assertEquals(100, SILab2.checkCart(List.of(item), "1234567890123456"));
    }

    @Test
    public void testAFalseBFalseCTrue() {
        Item item = new Item("Item2", 11, 100, 0);
        assertEquals(1070, SILab2.checkCart(List.of(item), "1234567890123456"));
    }

    @Test
    public void testAFalseBTrueCFalse() {
        Item item = new Item("Item3", 1, 100, 0.1);
        assertEquals(60, SILab2.checkCart(List.of(item), "1234567890123456"));
    }

    @Test
    public void testAFalseBTrueCTrue() {
        Item item = new Item("Item4", 12, 100, 0.2);
        assertEquals(930, SILab2.checkCart(List.of(item), "1234567890123456"));
    }

    @Test
    public void testATrueBFalseCFalse() {
        Item item = new Item("Item5", 1, 400, 0);
        assertEquals(370, SILab2.checkCart(List.of(item), "1234567890123456"));
    }

    @Test
    public void testATrueBFalseCTrue() {
        Item item = new Item("Item6", 11, 400, 0);
        assertEquals(4370, SILab2.checkCart(List.of(item), "1234567890123456"));
    }

    @Test
    public void testATrueBTrueCFalse() {
        Item item = new Item("Item7", 1, 400, 0.25);
        assertEquals(270, SILab2.checkCart(List.of(item), "1234567890123456"));
    }

    @Test
    public void testATrueBTrueCTrue() {
        Item item = new Item("Item8", 12, 400, 0.25);
        assertEquals(3570, SILab2.checkCart(List.of(item), "1234567890123456"));
    }
}