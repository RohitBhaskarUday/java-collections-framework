package Rohit;

import java.util.Iterator;

public class ourGenericList<T>  implements Iterable<T>
{                           //generic type. to understand it as a different types.
    private T[] items;
    private int size;
    public ourGenericList(){
        size =0;
        items = (T[]) new Object[100];
    }

    public void add(T item){
        items[size ++] = item;
    }

    public T getItemAtIndex(int index){
        return items[index];
    }

    public Iterator<T> iterator(){
        return new ourGenericListIterator(this);

    }

    private class ourGenericListIterator implements Iterator<T>
    {
        //why private class? We dont want this class to be exposed
        private ourGenericList<T> list;
        private int index = 0;
        public ourGenericListIterator(ourGenericList<T> list){
            this.list = list;
        }


        @Override
        public boolean hasNext() {
            return index < list.size;
        }

        @Override
        public T next() {
            return list.items[index ++];
        }





    }




}
