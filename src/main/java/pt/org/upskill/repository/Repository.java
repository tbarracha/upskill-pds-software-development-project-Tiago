package pt.org.upskill.repository;

import TiWorks.Serializer;
import TiWorks.TiUtils;
import pt.org.upskill.domain.IOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> implements Persistable<T>, Serializable {

    protected ArrayList<T> contentList;

    public ArrayList<T> getContentList() {
        return new ArrayList<>(contentList);
    }

    public Repository() {
        contentList = new ArrayList<>();
    }



    // List "Interface"
    // ---------------------------------------------------------------
    public T getAtIndex(int index) {
        index = Math.max(0, index);

        if (contentList.isEmpty() == false && index >= 0 && index < contentList.size()) {
            return contentList.get(index);
        } else {
            System.out.println(String.format("Couldn't find object at index: %d", index));
            return null;
        }
    }

    public T getRandom() {
        return TiUtils.Randomizer.getRandomFromList(contentList);
    }

    public int size() {
        return contentList.size();
    }

    public boolean contains(T item) {
        return contentList.contains(item);
    }

    public boolean addToRepository(T item) {
        if (!contains(item)) {
            contentList.add(item);
            return true;
        }

        return false;
    }

    public boolean removeFromRepository(T item) {
        return contentList.remove(item);
    }



    // Save, Delete & Load
    // ---------------------------------------------------------------
    @Override
    public boolean save(T object) {
        return addToRepository(object);
    }

    @Override
    public boolean delete(T object) {
        return removeFromRepository(object);
    }

    protected String getContentListToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < contentList.size(); i++) {
            stringBuilder.append(String.format("%d - %s", i, contentList.get(i)));
            if (i < contentList.size() - 1)
                stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
