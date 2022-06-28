package com.example.java_project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    static private Random random = new Random();

    static private List<String> list1 = null;
    static private List<String> list2 = null;
    static private List<String> list3 = null;

    static {
        try {
            list1 = importList("D:\\抽奖软件工作目录\\list\\list1.txt");
            list2 = importList("D:\\抽奖软件工作目录\\list\\list2.txt");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    static private List<String> importList(String fileName) throws UnsupportedEncodingException {
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 一行一行地处理...
            list.add(line);
        }
        return list;
    }

    @FXML
    protected void onStartList1() {
        welcomeText.setText(list1.get(random.nextInt(list1.size())));
    }

    @FXML
    protected void onStartList2() {
        welcomeText.setText(list2.get(random.nextInt(list2.size())));
    }

    @FXML
    protected void reset() {
        welcomeText.setText("抽 奖 环 节");
        try {
            list1 = importList("D:\\抽奖软件工作目录\\list\\list1.txt");
            list2 = importList("D:\\抽奖软件工作目录\\list\\list2.txt");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}