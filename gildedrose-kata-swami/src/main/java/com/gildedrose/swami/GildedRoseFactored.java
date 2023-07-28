package com.gildedrose.swami;

import java.util.List;

import lombok.extern.java.Log;

@Log
public class GildedRoseFactored {
	
	List<Item> items;
	
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String HAND_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	

   public GildedRoseFactored(List<Item> items) {
        this.items = items;
    } 

    public void updateQuality() {
    		
    		items.forEach( it -> {
    			log.info("Start factored name: "+it.getName());
    			log.info("Start factored quality: "+it.getQuality());
    			log.info("Start factored sellin: "+it.getSellIn());
    			if(!AGED_BRIE.equals(it.getName()) && !BACKSTAGE_CONCERT.equals(it.getName())) {
    					if (!HAND_RAGNAROS.equals(it.getName()) && it.getQuality() > 0) {
    						it.setQuality(it.getQuality() - 1);
    					}
    			} else if (it.getQuality() < 50) {
    				     it.setQuality(it.getQuality() +1);
    				     if( BACKSTAGE_CONCERT.equals(it.getName())) {
    				    	 if (it.getSellIn() < 6 && it.getQuality() < 50 ) {
    				    		 it.setQuality(it.getQuality() + 2);
    				    	 } else if (it.getSellIn() < 11 && it.getQuality() < 50 ) {
    				    		 it.setQuality(it.getQuality() + 1);
    				    	 }
    				     }
    			}
    			if (!HAND_RAGNAROS.equals(it.getName())) {
    				it.setSellIn(it.getSellIn() -1);
    			}
    			if(it.getSellIn() < 0) {
    				 if(!AGED_BRIE.equals(it.getName())) {
    					 if (!BACKSTAGE_CONCERT.equals(it.getName())) {
    						  if(it.getQuality() > 0 && !HAND_RAGNAROS.equals(it.getName())) 
    						   it.setQuality(it.getQuality() - 1);
    					 } else {
    						 it.setQuality(0);
    					 }
    				 } else if(it.getQuality() < 50) {
    					   	it.setQuality(it.getQuality() + 1);
    				 }
    			}
    			log.info("End factored name: "+it.getName());
    			log.info("End factored quality: "+it.getQuality());
    			log.info("End factored sellin: "+it.getSellIn());
    		});
    }
}
