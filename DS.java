/*
 * Author：dragon
 * 实现功能：随机抽取花名册与题目库随机匹配 单人单题 每次都是随机 机会均等 开发真的不操盘
 * 使用方法：编译后按回车开始摇号    Good Luck   God Bless You!!!!
 * 开发建议 ：先洗脸后摇号 这么做不会降低概率 但是心里好受 毕竟每人一次 早晚要来
 *  -----------------------是福不是祸 是祸躲不过-----------------------
 * 完成时间：2020/5/13  22：14
 * */

import java.util.ArrayList;

import java.util.Scanner;

final public class DS {
    private static DS dsInstance = null;
    private static int unitNum = 8;
    private static int subNum = 20;
    private static int[] question = new int[]{4, 8, 7, 6, 7, 5, 6, 4};

    private static boolean[][] flag = new boolean[unitNum][subNum];


    private String peoples = "张三,李四"; // 这里添加人员名单，逗号,间隔
    private ArrayList<String> array = null;

    private DS() {


        array = new ArrayList<String>(50);
        String temp[] = peoples.split(",");
        for (String t : temp) {
            array.add(t);
        }
        System.out.println("总人数为:" + array.size());
    }

    public static DS getInstance() {
        if (dsInstance == null) {
            dsInstance = new DS();
        }
        return dsInstance;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("\t========================================================================================");
        System.out.println("\t* 开源是一种精神");
        System.out.print(" \t* Author：dragon\n" +
                " \t* 实现功能：随机抽取花名册与题目库随机匹配 单人单题 每次都是随机 机会均等 开发真的不操盘\n" +
                " \t* 使用方法：编译后按回车开始摇号    Good Luck   God Bless You!!!!\n" +
                " \t* 开发建议 ：先洗脸后摇号 这么做不会降低概率 但是心里好受 毕竟每人一次 早晚要来\n" +
                " \t* 如果真的不会建议连夜扛着飞机跑 跑到大山里 喂？ 喂？？喂！没有信号 You are safe！\n" +
                " \t* --我在8848珠穆朗玛峰等你们 有意见尽管提 反正不采纳 你可以上来找我 我没信号--\n" +
                " \t* ---------------------------是福不是祸 是祸躲不过---------------------------\n" +
                " \t* 完成时间：2020/5/13  22：14\n\t");

        System.out.println();
        DS ds = DS.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (ds.getArraySize() > 0) {
            System.out.println("剩余人数为:" + ds.getArraySize());
            System.out.println("按回车键抽签~");
            scanner.nextLine();
            int index = (int) (Math.random() * ds.getArraySize());
            int X = (int) (Math.random() * unitNum + 1);
            int Y = (int) (Math.random() * subNum + 1);
            int Z = (int) (Math.random() * question[X - 1] + 1);
            while (flag[X - 1][Y - 1]) {
                X = (int) (Math.random() * unitNum + 1);
                Y = (int) (Math.random() * subNum + 1);
                System.out.println("发生碰撞");
            }
            flag[X - 1][Y - 1] = true;
            System.out.println("[姓名:" + ds.RandomGet(index) + ",题目:第" + X + "单元  第" + Y + "题 第" + Z + "小问]");
            ds.removePeople(index);
            System.out.println("-------------------");

        }

        scanner.close();

    }

    public synchronized String RandomGet(int index) {
        return array.get(index);
    }

    public synchronized int getArraySize() {
        return array.size();
    }

    public synchronized void removePeople(int index) {
        array.remove(index);
    }
}


