import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import parcs.*;

public class Main {
    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("Algo.jar");
        AlgoData data = fromFile(curtask.findFile("input"));

        AMInfo info = new AMInfo(curtask, null);
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("Algo");
        c.write(data);

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c.readInt());
        curtask.end();
    }

    public static AlgoData fromFile(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        int n = sc.nextInt();
	 int x = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        return new AlgoData(a, x);
    }
}