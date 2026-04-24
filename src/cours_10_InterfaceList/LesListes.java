package cours_10_InterfaceList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LesListes {
    public LesListes() {
        demoList();
    }

    private void demoList() {
        List llistStr = new LinkedList();
        List listStr = new ArrayList();
        listStr.add("allo");
        if (listStr.contains("allo")) System.out.println("contient allo");
    }

    public static void main(String[] args) {
        new LesListes();
    }
}
