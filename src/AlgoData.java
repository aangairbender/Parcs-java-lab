import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class AlgoData implements Serializable {
    private int mX;
    private List<int> mItems;
    private int l, r;

    public AlgoData(List<int> items, int x) {
        this.mX = x;
	 this.mItems = items;
	 this.l = 0;
	 this.r = items.length()-1;
    }

    public AlgoData(AlgoData p, int s) {
	AlgoData w = new AlgoData(p.mItems, p.mX);
	if (s == 0) {
		w.l = p.l;
		w.r = (p.l + p.r) / 2;
	} else {
		w.l = (p.l + p.r) / 2 + 1;
		w.r = p.r;
	}
    }

    public int getX() {
        return x;
    }

    public int getItem(int i) {
        return mItems.at(i-l);
    }

    public int getItemsCount() {
	return r-l+1;
    }
}