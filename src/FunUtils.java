import java.util.List;


public class FunUtils {

	public static <T> InfinityList<T> cycle(List<T> xs) {
		// TODO Auto-generated method stub
		return new InfinityList<T>(xs);
	}

	public static <T> List<T> take(int num, InfinityList<T> xs) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, R> List<R> map(Fun<T, R> f, List<T> xs) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T1, T2, R> List<R> zipWith(Fun<T1, Fun<T2, R>> f, List<T1> xs, List<T2> ys) {
		// TODO Auto-generated method stub
		return null;
	}
}
