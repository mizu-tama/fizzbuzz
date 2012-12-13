import java.util.*;

public class InfinityList<E> implements Iterator<E> {

    private List<E> seed;
    private int seedSize;
    private int nextIndex;

    public InfinityList(List<E> xs) {
        seed = xs;
        seedSize = xs.size();
        nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public E next() {
        int index = nextIndex;
        nextIndex++;
        if (nextIndex >= seedSize) {
            nextIndex = 0;
        }

        return seed.get(index);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
