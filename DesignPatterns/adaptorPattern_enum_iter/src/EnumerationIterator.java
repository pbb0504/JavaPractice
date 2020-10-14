/**
 * @author: pbb
 * @date: 2020/10/14 21:49
 */
public class EnumerationIterator implements Iterator{
    Enumeration enumeration;

    EnumerationIterator(Enumeration enumeration){
        this.enumeration = enumeration;
    }
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
