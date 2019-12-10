package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class GoodsWagonGroup implements Iterable<GoodsWagon>{
    private List<GoodsWagon> goodsWagonsList = new ArrayList<>();

    public void addGoodsWagon(GoodsWagon goodsWagon) {
        this.goodsWagonsList.add(goodsWagon);
    }

    @Override
    public Iterator<GoodsWagon> iterator() {
        return this.goodsWagonsList.iterator();
    }
}