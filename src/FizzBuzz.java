import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
	private String string;
	private Integer number;
	
	private static final FizzBuzz N = new FizzBuzz();

	private FizzBuzz() {
		string = null;
		number = null;
	}
	
	private FizzBuzz(int i) {
		string = null;
		number = i;
	}

	private FizzBuzz(String s) {
		string = s;
		number = null;
	}
	
	private static final Fun<FizzBuzz, Fun<FizzBuzz, FizzBuzz>> append = new Fun<FizzBuzz, Fun<FizzBuzz, FizzBuzz>>() {

		@Override
		public Fun<FizzBuzz, FizzBuzz> _(final FizzBuzz x) {
			if (x == N) {
				return new Fun<FizzBuzz, FizzBuzz>() {
					@Override
					public FizzBuzz _(final FizzBuzz y) {
						return y;
					}
				};
			} else if (x.string != null) {
				return new Fun<FizzBuzz, FizzBuzz>() {
					@Override
					public FizzBuzz _(final FizzBuzz y) {
						if (y.string != null) {
							return new FizzBuzz(x.string + y.string);
						}
						return x;
					}
				};
			} else {
				return new Fun<FizzBuzz, FizzBuzz>() {
					@Override
					public FizzBuzz _(final FizzBuzz y) {
						if (y == N) {
							return x;
						}else if (y.string != null) {
							return y;
						} else {
							throw new UnsupportedOperationException();
						}
					}
				};
			}		
		}
	};
	
	public static List<String> fizzbuzz(int num) {
		Fun<FizzBuzz, String> fizzbuzz2str = new Fun<FizzBuzz, String>() {
			@Override
			public String _(final FizzBuzz x) {
				if (x == N) {
					return null;
				} else if (x.string != null) {
					return x.string;
				} else {
					return String.valueOf(x.number);
				}
			}
		};
		
		List<FizzBuzz> fizz = FunUtils.take(num, FunUtils.cycle(Arrays.asList(N, N, new FizzBuzz("Fizz"))));
		List<FizzBuzz> buzz = FunUtils.take(num, FunUtils.cycle(Arrays.asList(N, N, N, N, new FizzBuzz("Buzz"))));

		List<FizzBuzz> nums = new ArrayList<FizzBuzz>(num);
		for (int i = 0; i < num; i++) {
			nums.add(new FizzBuzz(i+1));
		}
		
		List<FizzBuzz> result = FunUtils.zipWith(append, nums, FunUtils.zipWith(append, fizz, buzz));
		return FunUtils.map(fizzbuzz2str, result);	
	}
}
