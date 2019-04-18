import java.util.List;
import java.util.ArrayList;
import parcs.*;

public class Algo implements AM {
    public void run(AMInfo info) {
        AlgoData data = (AlgoData)info.parent.readObject();

	int len = data.getItemsLength();
	if (len == 1)
	{
		info.parent.write(data.getItem(0) == data.getX() ? 1 : 0);
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
	res += c1.readLong();
	res += c2.readLong();
	info.parent.write(res);
    }
}