package com.gildedrose;

public class BackstagePassUpdater implements ItemUpdater{
    @Override
    public Item update(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else {
            if (item.quality < 50) item.quality += 1;
            if (item.sellIn <10 && item.sellIn >5 && item.quality < 50) item.quality += 2;
            if (item.sellIn <= 5 && item.quality < 50) item.quality += 3;
        }
        item.sellIn--;
        return item;
    }
}

