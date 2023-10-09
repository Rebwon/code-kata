package com.rebwon.codekata.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    @DisplayName("하루가 지날 때 마다 SellIn과 Quality가 1씩 감소한다.")
    void name() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Elixir of the Mongoose", 5, 7)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(19);
        assertThat(app.items[1].sellIn).isEqualTo(4);
        assertThat(app.items[1].quality).isEqualTo(6);
    }

    @Test
    @DisplayName("SellIn이 0이 되면 Quality가 2만큼 감소한다.")
    void name1() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 0, 20),
                new Item("Elixir of the Mongoose", 0, 7)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(18);
        assertThat(app.items[1].sellIn).isEqualTo(-1);
        assertThat(app.items[1].quality).isEqualTo(5);
    }

    @Test
    @DisplayName("Quality는 0보다 작아지지 않는다.")
    void name22() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 0, 0),
                new Item("Elixir of the Mongoose", 0, 0)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(0);
        assertThat(app.items[1].sellIn).isEqualTo(-1);
        assertThat(app.items[1].quality).isEqualTo(0);
    }

    @Test
    @DisplayName("Aged Brie의 Quality는 SellIn이 지날 때 마다 1씩 증가한다.")
    void name33() {

        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 0)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(1);
        assertThat(app.items[0].quality).isEqualTo(1);
    }

    @Test
    @DisplayName("Aged Brie의 Quality는 SellIn이 0이 되면 2씩 증가한다.")
    void name34() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 0)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(2);
    }

    @Test
    @DisplayName("Quality는 50을 넘을 수 없다.")
    void name44() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 50)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(1);
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    @DisplayName("Sulfuras의 Quality와 SellIn은 변하지 않는다.")
    void name55() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isEqualTo(80);
        assertThat(app.items[1].sellIn).isEqualTo(-1);
        assertThat(app.items[1].quality).isEqualTo(80);
    }

    @Test
    @DisplayName("Backstage Passes의 Quality는 SellIn이 11보다 클 때 1씩 증가한다.")
    void name65() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(10);
        assertThat(app.items[0].quality).isEqualTo(21);
        assertThat(app.items[1].sellIn).isEqualTo(11);
        assertThat(app.items[1].quality).isEqualTo(21);
    }

    @Test
    @DisplayName("Backstage Passes의 Quality는 SellIn이 10보다 작거나 같을 때 2씩 증가한다.")
    void name66() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(22);
        assertThat(app.items[1].sellIn).isEqualTo(8);
        assertThat(app.items[1].quality).isEqualTo(22);
    }

    @Test
    @DisplayName("Backstage Passes의 Quality는 SellIn이 5보다 작거나 같을 때 3씩 증가한다.")
    void name77() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(4);
        assertThat(app.items[0].quality).isEqualTo(23);
        assertThat(app.items[1].sellIn).isEqualTo(3);
        assertThat(app.items[1].quality).isEqualTo(23);
    }

    @Test
    @DisplayName("Backstage Passes의 Quality는 SellIn이 0보다 작거나 같을 때 0이 된다.")
    void name88() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(0);
        assertThat(app.items[1].sellIn).isEqualTo(-2);
        assertThat(app.items[1].quality).isEqualTo(0);
    }
}
