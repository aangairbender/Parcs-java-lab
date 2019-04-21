import java.util.List;
import java.util.ArrayList;
import parcs.*;

public class Algo implements AM {
    public void run(AMInfo info) {
        AlgoData data = (AlgoData)info.parent.readObject();

	int len = data.getItemsCount();
	if (len == 1)
	{
		info.parent.write(calc(data.getX(), data.getItem(0)));
		return ;
	}
	
	AlgoData data1 = new AlgoData(data, 0);
	point p1 = info.createPoint();
	channel c1 = p1.createChannel();
	p1.execute("Algo");
	c1.write(data1);
	
	AlgoData data2 = new AlgoData(data, 1);
	point p2 = info.createPoint();
	channel c2 = p2.createChannel();
	p2.execute("Algo");
	c2.write(data2);

	int res = 0;
	res += c1.readInt();
	res += c2.readInt();
	info.parent.write(res);
    }

	private int calc(int x, int n) {
		int cnt = 0;
		for (int i = 1; i <= n; ++i)
		{
			cnt += gcd(i, x);
		}
		return cnt;
	}

	private int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x % y);
	}
}