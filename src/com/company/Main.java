package com.company;

//Вариант 1
// Разработайте многопоточное приложение для побайтового копирования файла.
// Продемонстрируйте работу одноовременного копирования файла в несколько файлов.

public class Main extends Thread{

    private int n;

    public Main(int n){
        this.n = n;
    }

    public void run(){
        MainInterface mI = (int m) -> {
                String text = makeText();
                String newText = "";
                for (int i = 0; i < text.length(); i++){
                    char ch = text.charAt(i);
                    newText += ch;
                    System.out.println("поток " + m);
                }
                System.out.println(newText);
        };
        mI.mainFunction(n);
    }

    public static void main(String[] args){
        Main myMain1 = new Main(1);
        Main myMain2 = new Main(2);
        Main myMain3 = new Main(3);
        myMain1.start();
        myMain2.start();
        myMain3.start();
    }

    public String makeText(){
        String text = "Австрия потеряла Венецию и признала объединение северогерманских государств с Пруссией. Вскоре после этого венгерская элита при посредничестве супруги Франца Елизаветы Баварской добилась от Франца Иосифа предоставления ей равных прав с австрийскими немцами и преобразования Австрийской империи в двуединую монархию. Опасаясь новой революции, император, в 1853 году чуть не убитый венгерским националистом, был вынужден согласиться. Это привело к началу национального движения и среди других народов дунайской монархии.";
        return text;
    }
}
