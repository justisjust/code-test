package com.hzb.poi;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName PoiTest.java
 * @Description TODO
 * @createTime 2022年06月03日 16:23:00
 */
public class PoiTest2 {

    private static final Pattern OBJECT_KEY_PATTERN = Pattern.compile("^([^\\/]([\\w\\u4e00-\\u9fa5\\/\\.\\-]{0,200}))$");

    public static void main(String[] args) {
        String file1Path = "D:\\haozhenbo\\Downloads\\mysql-cn-north-1-2b281b35980a4bc1.rds.jdcloud.com2.csv";
        String file2Path = "D:\\haozhenbo\\Downloads\\mysql-cn-north-1-2b281b35980a4bc1.rds.jdcloud.com1.csv";
        Map<String, List<String>> map = new HashMap<>();
//        readFile(file1Path, map);
//        readFile(file2Path, map);

        String url1 = "http:////test.storage.jd.com/test1202003219/scm5e6fd4d4baa34eb6b600d691e4557978?Expires=3231576109&AccessKey=pqPmKkKfxztGp9ed&Signature=DwEey1rzzmzgNaIsKlV4xfgKty4%3D";
        String url2 = "http://storage.jd.com/shj/7gpxKtXaCfAf8Nwd.xlsx?Expires=3231898963&AccessKey=aPMI35v1VrgOtUwP&Signature=Mql8POf2iuP2VuMcQfvrfSAtqlQ%3D";
        String url3 = "7gpxKtXaCfAf8Nwd.xlsx";
        validateObjectKey(url3);
//        int size = 0;
//        for (List<String> value : map.values()) {
//            size += value.size();
//        }
//        System.out.println(size);

    }

    public static String validateObjectKey(String var0) {
        var0 = var0.replaceAll("\\\\", "/");
        System.out.println(OBJECT_KEY_PATTERN.matcher(var0).find());
        System.out.println(!var0.contains("//"));
        if (OBJECT_KEY_PATTERN.matcher(var0).find() && !var0.contains("//") && !var0.contains(" ")) {
            return var0;
        } else {
            throw new IllegalArgumentException("Object key is Illegal");
        }
    }

    private static void readFile(String filePath, Map<String, List<String>> map) {
        //第一步：先获取csv文件的路径，通过BufferedReader类去读该路径中的文件
        File csv = new File(filePath);
        try{
            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            File file = new File("D:\\haozhenbo\\Desktop\\ruleNum.txt");
            String lineDta = "";
            List<String> list = new ArrayList<>();
            int i = 0;
            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
            while ((lineDta = textFile.readLine()) != null) {
//                System.out.println(lineDta.replaceAll("\"", ""));
                if(lineDta.contains("charging_standard_code")) {
                    continue;
                }
                String[] split = lineDta.replaceAll("\"", "").split("\t");
                String key = split[1];
                String ruleNo = split[0];
                if(map.containsKey(key)) {
                    map.get(key).add(ruleNo);
                    System.out.println(key);
                }else {
                    map.put(key, Lists.newArrayList(ruleNo));
                }
            }
            textFile.close();

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

}
