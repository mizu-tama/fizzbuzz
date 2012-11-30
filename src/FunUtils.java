import java.util.List;


public class FunUtils {

	public static <T> InfinityList<T> cycle(List<T> xs) {
		return new InfinityList<T>(xs);
	}

	public static <T> List<T> take(int num, InfinityList<T> iList) {
		List<T> result = new ArrayList(num);
		
		// TODO なんかループしてresultにつめる
		
		
		return result;
	}

	public static <T, R> List<R> map(Fun<T, R> f, List<T> xs) {
		List<R> result = new ArrayList(xs.size());
		
		for (T x: xs) {
			result.add(f._(x));
		}
		
		return result;
	}

	public static <T1, T2, R> List<R> zipWith(Fun<T1, Fun<T2, R>> f, List<T1> xs, List<T2> ys) {
		// TODO 短い方のリストに合わせる
		
		
		return null;
	}
}
