package com.rebwon.codekata.gildedrose;

public class Item {

    public String name;

    // 아이을 판매해야 하는 남은 기간 (일수)
    public int sellIn;

    // 아이템의 가치 (높을수록 좋음)
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
