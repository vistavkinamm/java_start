import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String text = "";

        try {
            //FileWriter fileWriter = new FileWriter("text.sql");
            //fileWriter.append("Создать файл и записать в него текст, затем прочитать файл.");
            //fileWriter.flush();
            //fileWriter.close();

            FileReader fileReader = new FileReader("text.sql");
            while (fileReader.ready()) {
                text += (char) fileReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         //System.out.println(text);

        String[] string = text.split("\n");

        boolean booleanGender;

        for (int i=0; i<string.length; i++){
            String [] sb = string[i].split(" ");
            family.add(sb[0]);
            name.add(sb[1].charAt(0) + ".");
            soname.add(sb[2].charAt(0) + ".");
            age.add(Integer.valueOf(sb[3]));
            // booleanGender=(sb[4]=="М" ? true : false);
            gender.add(sb[4].equals("М") ? true : false);
            index.add(i);

            //System.out.println(sb[0] + " " + sb[1].charAt(0) + "." + sb[2].charAt(0) + "." + " " + sb[3] + " " + sb[4]);
        }

        index.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i=0; i<index.size(); i++) {

            //System.out.printf(family.get(index.get(i)));
            //System.out.printf(name.get(index.get(i)));
            //System.out.printf(soname.get(index.get(i)));
            //System.out.printf(age.get(index.get(i)).toString());
            //System.out.printf((gender.get(index.get(i)) ? " М" : "  Ж"));
            //System.out.println();

        }
        //System.out.println(family);

        //System.out.println(text);

        //4.Отсортировать по возрасту используя дополнительный список индексов.

        System.out.println("Сортировка по возрасту: ");
        for (int i = 0; i < index.size(); i++) {
            Collections.sort(age);
            System.out.println(index.get(index.get(i)) + " " + name.get(index.get(i)) + ", " + age.get(index.get(i)));
        }

    }
}


