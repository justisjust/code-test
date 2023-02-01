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
public class ExcelTest {

    public static void main(String[] args) {
        String filePath = "D:\\haozhenbo\\Documents\\JD\\office_dongdong\\org.fwjjsxm\\RecvFile\\需调整明细0620.xlsx";
        readFile(filePath);
//        File file = new File("D:\\haozhenbo\\Desktop\\ruleNum.txt");
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write("222");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    static Map<String, Integer> companycenterMap = new HashMap<>();
    static Map<String, String> centerMap = new HashMap<>();
    static Map<String, Integer> regionMap = new HashMap<>();
    static {

        regionMap.put("华东", 40);
        regionMap.put("华北", 20);
        regionMap.put("东北", 30);
        regionMap.put("华中", 60);
        regionMap.put("西北", 80);
        regionMap.put("华南", 50);
        regionMap.put("西南", 70);

        companycenterMap.put("广州分公司",10);
        companycenterMap.put("集团总部",11223);
        companycenterMap.put("上海分公司",3);
        companycenterMap.put("成都分公司",4);
        companycenterMap.put("江苏京东",432);
        companycenterMap.put("总公司",6);
        companycenterMap.put("武汉分公司",600);
        companycenterMap.put("沈阳分公司",611);
        companycenterMap.put("西安分公司",645);
        companycenterMap.put("重庆公司",650);
        companycenterMap.put("杭州公司",688);
        companycenterMap.put("武汉金德分公司",709);
        companycenterMap.put("青岛昌益得公司",723);
        companycenterMap.put("贵阳公司",735);
        companycenterMap.put("哈尔滨公司",766);
        companycenterMap.put("厦门公司",769);
        companycenterMap.put("江苏公司",770);

        centerMap.put("无锡安装运营中心", "lw_3_365");
        centerMap.put("石家庄安装运营中心", "lw_6_488");
        centerMap.put("南京安装运营中心", "lw_3_238");
        centerMap.put("上海安装运营中心", "lw_3_106");
        centerMap.put("沈阳安装运营中心", "lw_611_581");
        centerMap.put("太原安装运营中心", "lw_6_790");
        centerMap.put("杭州安装运营中心", "lw_688_333");
        centerMap.put("宿迁安装运营中心", "lw_770_979");
        centerMap.put("合肥安装运营中心", "lw_3_350");
        centerMap.put("北京安装运营中心", "lw_6_950");
        centerMap.put("武汉安装运营中心", "lw_600_35");
        centerMap.put("青岛安装运营中心", "lw_723_767");
        centerMap.put("南昌安装运营中心", "lw_600_197");
        centerMap.put("哈尔滨安装运营中心", "lw_766_916");
        centerMap.put("银川安装运营中心", "lw_645_988");
        centerMap.put("济南安装运营中心", "lw_723_750");
        centerMap.put("乌鲁木齐安装运营中心", "lw_645_897");
        centerMap.put("郑州安装运营中心", "lw_600_606");
        centerMap.put("深圳安装运营中心", "lw_10_334");
        centerMap.put("天津安装运营中心", "lw_6_49");
        centerMap.put("西安安装运营中心", "lw_645_991");
        centerMap.put("成都安装运营中心", "lw_4_992");
        centerMap.put("长沙安装运营中心", "lw_600_255");
        centerMap.put("重庆安装运营中心", "lw_650_927");
        centerMap.put("佛山安装运营中心", "lw_10_408");
        centerMap.put("厦门安装运营中心", "lw_769_396");
        centerMap.put("广州安装运营中心", "lw_10_861");
        centerMap.put("南宁安装运营中心", "lw_10_631");
        centerMap.put("贵阳安装运营中心", "lw_735_275");
        centerMap.put("海口安装运营中心", "lw_10_993");
        centerMap.put("昆明安装运营中心", "lw_4_589");

    }
    
    

    private static void readFile(String filePath) {
        //第一步：先获取csv文件的路径，通过BufferedReader类去读该路径中的文件
        File csv = new File(filePath);
        try{
            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
            List<Object> dataList = EasyExcelFactory.read(new FileInputStream(filePath), new Sheet(1));
            File file = new File("D:\\haozhenbo\\Desktop\\sql2.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < dataList.size(); i++) {
                List<String> cellsList = JSON.parseArray(JSON.toJSONString(dataList.get(i)), String.class);
                String[] cells = new String[0];
                String[] row = cellsList.toArray(cells);
                String applyId = row[0];
                String region = row[1];
                String company = row[2];
                String center = row[3];
                StringBuilder sb = new StringBuilder("update im_clearing_receipt set ");
                sb.append("receipt_company_name = '").append(company)
                        .append("',receipt_company_id = ").append(companycenterMap.get(company))
                        .append(",receipt_warehouse_name = '").append(center)
                        .append("',receipt_warehouse_id = '").append(centerMap.get(center))
                        .append("',sign_region = '").append(region)
                        .append("',sign_region_code = ").append(regionMap.get(region))
                        .append(" where receipt_id = ").append(applyId)
                        .append(";\r\n");
                writer.write(sb.toString());
            }
            writer.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e) {
            System.out.println("文件读写出错");
        }
    }

}
