package com.hzb.poi;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName PoiTest.java
 * @Description TODO
 * @createTime 2022年06月03日 16:23:00
 */
public class PoiTest {

    public static void main(String[] args) {
        String filePath = "D:\\haozhenbo\\Desktop\\结算规则SKU对应商城品类品牌数据_产研专用_20220602160603.csv";
        String skuFilePath = "D:\\haozhenbo\\Documents\\JD\\ME\\data\\ee\\haozhenbo\\file\\非空标准价-sku维度.xlsx";
        List<String> skuList = getMapFromExcel(skuFilePath);
        readFile(filePath, skuList);
//        File file = new File("D:\\haozhenbo\\Desktop\\ruleNum.txt");
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write("222");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void readFile(String filePath, List<String> skuList) {
        //第一步：先获取csv文件的路径，通过BufferedReader类去读该路径中的文件
        File csv = new File(filePath);
        try{
            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            File file = new File("D:\\haozhenbo\\Desktop\\ruleNum.txt");
            String lineDta = "";
            Map<String, String> map = new HashMap<>();
            Map<String, String> map2 = new HashMap<>();
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder("");
            int i = 0;
            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
            while ((lineDta = textFile.readLine()) != null) {
                String sku = (lineDta.split("\\^"))[0];
                String ruleNum = (lineDta.split("\\^"))[2];
                if(map.containsKey(ruleNum)) {
//                    list.add(ruleNum);
//                    System.out.println(ruleNum);
                    map2.put(ruleNum, sku);
                }else {
                    map.put(ruleNum, sku);
                }
                i++;
                if(i== 100) {
//                    break;
                }
            }
            textFile.close();

            for (Map.Entry<String, String> entry : map2.entrySet()) {
                if(skuList.contains(entry.getValue())) {
                    list.add(entry.getKey());
                }
            }

            System.out.println(map2.size());
            System.out.println((int) list.stream().distinct().count());
            String collect = list.stream().distinct().collect(Collectors.joining("\r\n"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(collect);
            writer.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e) {
            System.out.println("文件读写出错");
        }
    }

    private static List<String> getMapFromExcel(String filePath) {
        List<String> sku = new ArrayList<>();
        try{
            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
            List<Object> dataList = EasyExcelFactory.read(new FileInputStream(filePath), new Sheet(1));
            System.out.println(dataList.size() + "--");
            for (int i = 0; i < dataList.size(); i++) {
                List<String> cellsList = JSON.parseArray(JSON.toJSONString(dataList.get(i)), String.class);
                String[] cells = new String[0];
                String[] row = cellsList.toArray(cells);
                sku.add(row[0]);
            }
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }
        return sku.stream().distinct().collect(Collectors.toList());
    }
}
