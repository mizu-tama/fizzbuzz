import java.util.*;

public class FunUtils {

    public static <T> InfinityList<T> cycle(List<T> xs) {
        return new InfinityList<T>(xs);
    }

    public static <T> List<T> take(int num, InfinityList<T> iList) {
        List<T> result = new ArrayList<T>(num);

        for (int i = 0; i < num; i++) {
            result.add(iList.next());
        }

        return result;
    }

    public static <T, R> List<R> map(Fun<T, R> f, List<T> xs) {
        List<R> result = new ArrayList<R>(xs.size());

        for (T x : xs) {
            result.add(f._(x));
        }

        return result;
    }

    public static <T1, T2, R> List<R> zipWith(Fun<T1, Fun<T2, R>> f, List<T1> xs, List<T2> ys) {
        int minListSize = min(xs.size(), ys.size());
        List<R> result = new ArrayList<R>(minListSize);

        for (int i = 0; i < minListSize; i++) {
            T1 x = xs.get(i);
            T2 y = ys.get(i);
            result.add(f._(x)._(y));
        }

        return result;
    }

    private static int min(int val1, int val2) {
        return val1 < val2 ? val1 : val2;
    }
}
