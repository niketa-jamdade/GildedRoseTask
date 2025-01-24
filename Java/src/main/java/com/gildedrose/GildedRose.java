package com.gildedrose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GildedRose {

    public Item[] items;
    private Map<String, ItemUpdater> itemUpdaters;

    public GildedRose(Item[] items, Map<String, ItemUpdater> itemUpdaters) {
        this.items = items;
        this.itemUpdaters = itemUpdaters;
    }

    public void updateQuality() {
        items = Arrays.stream(items)
            .map(item -> {
                ItemUpdater updater = itemUpdaters.getOrDefault(item.name,Updaters.STANDARD);
                return updater.update(item);
            })
            .toArray(Item[]::new); // Collect stream elements back into an array
        }

    // Factory method for default updaters
    public static Map<String, ItemUpdater> createDefaultUpdaters() {
        Map<String, ItemUpdater> updaters = new HashMap<>();
        updaters.put("Aged Brie", new AgedBrieUpdater());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaters.put("Conjured Mana Cake", new ConjuredUpdater());  // Assuming all Conjured items degrade the same way
        updaters.put("+5 Dexterity Vest", new StandardItemUpdater());
        updaters.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaters.put("Elixir of the Mongoose", new StandardItemUpdater());
        return updaters;
    }
}
















































