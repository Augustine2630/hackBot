package com.bot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    List<File> motivation = new ArrayList<>();
    {
        File file = new File("D:\\memes\\1.jpg");
        File file1 = new File("D:\\memes\\2.jpg");
        File file2 = new File("D:\\memes\\3.jpg");
        File file3 = new File("D:\\memes\\4.jpg");
        File file4 = new File("D:\\memes\\5.jpg");
        File file5 = new File("D:\\memes\\6.jpg");
        File file6 = new File("D:\\memes\\7.jpg");
        File file7 = new File("D:\\memes\\8.jpg");
        File file8 = new File("D:\\memes\\9.jpg");
        File file9 = new File("D:\\memes\\10.jpg");
        File file10 = new File("D:\\memes\\11.jpg");
        motivation.add(file);
        motivation.add(file1);
        motivation.add(file2);
        motivation.add(file3);
        motivation.add(file4);
        motivation.add(file5);
        motivation.add(file6);
        motivation.add(file7);
        motivation.add(file8);
        motivation.add(file9);
        motivation.add(file10);
    }
    List<File> boring = new ArrayList<>();
    {
        File file = new File("D:\\boring\\1.jpg");
        File file1 = new File("D:\\boring\\2.jpg");
        File file2 = new File("D:\\boring\\3.jpg");
        File file3 = new File("D:\\boring\\4.jpg");
        boring.add(file);
        boring.add(file1);
        boring.add(file2);
        boring.add(file3);
    }

    List<File> studing = new ArrayList<>();
    {
        File file = new File("D:\\studing\\1.jpg");
        File file1 = new File("D:\\studing\\2.jpg");
        File file2 = new File("D:\\studing\\3.jpg");
        File file3 = new File("D:\\studing\\4.jpg");
        studing.add(file);
        studing.add(file1);
        studing.add(file2);
        studing.add(file3);
    }
    List<File> boiled = new ArrayList<>();
    {
        File file = new File("D:\\boiled\\1.jpg");
        File file1 = new File("D:\\boiled\\2.jpg");
        File file2 = new File("D:\\boiled\\3.jpg");
        File file3 = new File("D:\\boiled\\4.jpg");
        boiled.add(file);
        boiled.add(file1);
        boiled.add(file2);
        boiled.add(file3);
    }

    public File getRandomBoiledImg() {
        int a = 0;
        int b = boiled.size();
        int randomNumber = a + (int) (Math.random() * b);
        return boiled.get(randomNumber);
    }

    public File getRandomStudingImg() {
        int a = 0;
        int b = studing.size();
        int randomNumber = a + (int) (Math.random() * b);
        return studing.get(randomNumber);
    }
    public File getRandomBoringImg() {
        int a = 0;
        int b = boring.size();
        int randomNumber = a + (int) (Math.random() * b);
        return boring.get(randomNumber);
    }

    public File getRandomMotivationImg() {
        int a = 0;
        int b = motivation.size();
        int randomNumber = a + (int) (Math.random() * b);
        return motivation.get(randomNumber);
    }
}
