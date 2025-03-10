package code_ptit.practice.security;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BinaryFile <T>{
    private List<T> list;
    public BinaryFile(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            this.list = new ArrayList<>((ArrayList<T>) ois.readObject());
        } catch (Exception e) {

        }
    }

    public List<T> getList() {
        return list;
    }
}
