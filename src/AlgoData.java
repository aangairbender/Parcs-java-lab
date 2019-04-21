import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class AlgoData implements Serializable {
    private int mX;
    private List<Integer> mItems;
    private int l, r;

    public AlgoData(List<Integer> items, int x) {
        this.mX = x;
	 this.mItems = items;
	 this.l = 0;
	 this.r = items.size()-1;
    }

    public AlgoData(AlgoData p, int s) {
	mItems = p.mItems;
	mX = p.mX;
	if (s == 0) {
		l = p.l;
		r = (p.l + p.r) / 2;
	} else {
		l = (p.l + p.r) / 2 + 1;
		r = p.r;
	}
    }

    public int getX() {
        return mX;
    }

    public int getItem(int i) {
        return mItems.get(l+i);
    }

    public int getItemsCount() {
	return r-l+1;
    }
}