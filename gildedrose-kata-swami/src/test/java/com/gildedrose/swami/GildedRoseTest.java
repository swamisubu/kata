package com.gildedrose.swami;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

	
	
    @Test
    public void testQuality() {
    	List<Item> itemList = new ArrayList<>();
		Item it1 = new Item();
		it1.setName("Ajay");
		it1.setQuality(40);
		it1.setSellIn(1);
		itemList.add(it1);
        GildedRoseFactored gildRose = new GildedRoseFactored(itemList);
        gildRose.updateQuality();
        assertEquals(39, gildRose.items.get(0).getQuality());
        assertEquals(0, gildRose.items.get(0).getSellIn());
    }
    
    @Test
    public void testQualityWithAgedBrie() {
    	List<Item> itemList = new ArrayList<>();
		Item it1 = new Item();
		it1.setName("Aged Brie");
		it1.setQuality(40);
		it1.setSellIn(0);
		itemList.add(it1);
        GildedRoseFactored gildRose = new GildedRoseFactored(itemList);
        gildRose.updateQuality();
        assertEquals(42, gildRose.items.get(0).getQuality());
        assertEquals(-1, gildRose.items.get(0).getSellIn());
    }
    
    @Test
   public void testQualityWithBackStage() {
    	List<Item> itemList = new ArrayList<>();
		Item it1 = new Item();
		it1.setName("Backstage passes to a TAFKAL80ETC concert");
		it1.setQuality(40);
		it1.setSellIn(0);
		itemList.add(it1);
        GildedRoseFactored gildRose = new GildedRoseFactored(itemList);
        gildRose.updateQuality();
        assertEquals(0, gildRose.items.get(0).getQuality());
        assertEquals(-1, gildRose.items.get(0).getSellIn());
    }
    
    
    

}
