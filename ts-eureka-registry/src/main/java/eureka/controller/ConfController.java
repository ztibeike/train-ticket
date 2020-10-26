package com.example.eureka.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Slf4j
@RestController
public class ConfController {

    @GetMapping("/getConf")
    public String getConf() {
       // Map<String, List<String>> map = new HashMap<String, List<String>>();
        //JsonInfo jInfo= new JsonInfo();
        String resoult="";
        Map<String,String> zuuMap=new HashMap<String,String>();  //service-a, 172.19.0.8:8031
        Map<String,String> service=new HashMap<String, String>(); // 172.19.0.10:10001  service-a
        Map<String, String[]> serviceMap=new HashMap<>(); // service-a   [172.19.0.10:10001]
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject("http://localhost:8030/eureka/apps", String.class);
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> ArrayIpPort= new ArrayList<>();
        ArrayList<String> ArrayGetWay= new ArrayList<>();  //需要二次填写
        ArrayList<String> ArrayRelace= new ArrayList<>();  //需要二次填写
        ArrayList<String> ArrayGroup= new ArrayList<>();
        ArrayList<Boolean> ArrayLeaf= new ArrayList<>();
        try {
            JsonNode rootNode = mapper.readTree(json);
            JsonNode applicationsNode = rootNode.path("applications").path("application");
            for (int i = 0; i < applicationsNode.size(); i++) {
                String applicationName = applicationsNode.get(i).path("name").asText();
               // map.put(applicationName, new ArrayList<String>());
                if (applicationName.contains("ZUUL")){
                    JsonNode instanceNode = applicationsNode.get(i).path("instance");
                    for (int j = 0; j < instanceNode.size(); j++) {
                        String zuulInfo=instanceNode.get(j).path("ipAddr").asText() + ":" + instanceNode.get(j).path("port").path("$").asText();
                        ArrayGetWay.add(zuulInfo);//获取所有的网关信息
                        /*
                        String infoUrl=instanceNode.get(j).path("statusPageUrl").toString(); //容器内无法访问，废弃
                        //infoUrl="http://192.168.223.132:8031/actuator/info"; //test
                        String jsonInfo=restTemplate.getForObject(infoUrl,String.class); //获取网关所属实例组信息
                        JsonNode rootNodeInfo = mapper.readTree(jsonInfo);
                        //System.out.println(rootNodeInfo);
                        String serviceName=rootNodeInfo.path("getway").asText().toUpperCase();//获取网关负责的实例组名
                        System.out.println(serviceName.toLowerCase()+"->"+zuulInfo);
                        zuuMap.put(serviceName.toLowerCase(),zuulInfo); //服务组->网关
                        // map.get(applicationName).add(instanceNode.get(j).path("ipAddr").asText() + ":" + instanceNode.get(j).path("port").path("$").asText());
                        // map.get(applicationName).add(instanceNode.get(j).path("statusPageUrl").toString());
                        /
                         */
                    }
                }else {//非网关信息
                    JsonNode instanceNode = applicationsNode.get(i).path("instance");//一个实例组 例：service-a组 ，可能有多个实例
                    String[] serArr=new String[instanceNode.size()];
                    for (int j = 0; j < instanceNode.size(); j++) {
                        String serInfo=instanceNode.get(j).path("ipAddr").asText() + ":" + instanceNode.get(j).path("port").path("$").asText();
                        ArrayIpPort.add(serInfo);//服务信息
                        ArrayGroup.add(applicationName.toLowerCase());//服务所在组信息
                        /* 废弃
                        String infoUrl=instanceNode.get(j).path("statusPageUrl").toString();
                        //infoUrl="http://192.168.223.132:10001/actuator/info"; //test
                        String jsonInfo=restTemplate.getForObject(infoUrl,String.class); //获取叶子节点信息
                        JsonNode rootNodeInfo = mapper.readTree(jsonInfo);
                        String leaf=rootNodeInfo.path("leaf").asText();
                        ArrayIpPort.add(serInfo); //服务直接加入配置文件数组
                        ArrayGroup.add(applicationName.toLowerCase()); //所属服务组
                        if (leaf == "0") {
                            ArrayLeaf.add(false);
                        } else {//默认处理为叶子节点
                            ArrayLeaf.add(true);
                        }
                        service.put(serInfo,applicationName.toLowerCase()); //服务->所在组
                        System.out.println(serInfo+"->"+applicationName.toLowerCase());
                        serArr[j]=serInfo;
                         */
                    }
                    //serviceMap.put(applicationName.toLowerCase(),serArr);// 服务组名->所有的实例
                }
            }
            /*
            for (int j = 0; j < ArrayIpPort.size(); j++) {
                String serviceGrp=service.get(ArrayIpPort.get(j));
                String getWay=zuuMap.get(serviceGrp);
                System.out.println(getWay);
                ArrayGetWay.add(getWay);
                if (serviceMap.get(serviceGrp).length==1){
                    ArrayRelace.add(ArrayIpPort.get(j));
                }else {
                   // System.out.println(serviceMap.get(serviceGrp).length);
                   // System.out.println(j);
                    int index=0;
                    for(int k=0 ;k<serviceMap.get(serviceGrp).length;k++){
                        if (serviceMap.get(serviceGrp)[k]==ArrayIpPort.get(j)){
                            index=k;
                            break;
                        }
                    }
                    ArrayRelace.add(serviceMap.get(serviceGrp)[serviceMap.get(serviceGrp).length-1-index]);
                }
            }*/
            String[] a1 = new String[ArrayIpPort.size()];
            ArrayIpPort.toArray(a1);
            //jInfo.ArrayIpPort=a1;

            String[] a2 = new String[ArrayGetWay.size()];
            ArrayGetWay.toArray(a2);
           // jInfo.ArrayGetWay=a2;

           // String[] a3 = new String[ArrayRelace.size()];
           // ArrayRelace.toArray(a3);
           // jInfo.ArrayRelace=a3;

            String[] a4 = new String[ArrayGroup.size()];
            ArrayGroup.toArray(a4);
          //  jInfo.ArrayGroup=a4;

          //  Boolean[] a5 = new Boolean[ArrayLeaf.size()];
          //  ArrayLeaf.toArray(a5);
         //   jInfo.ArrayLeaf=a5;

           // System.out.println(Arrays.toString(a5));
            JSONArray jsonarray1 = JSONArray.fromObject(a1);
            System.out.println(jsonarray1);
            JSONArray jsonarray2 = JSONArray.fromObject(a2);
            System.out.println(jsonarray2);
          //  JSONArray jsonarray3 = JSONArray.fromObject(a3);
          //  System.out.println(jsonarray3);
            JSONArray jsonarray4 = JSONArray.fromObject(a4);
           System.out.println(jsonarray4);
          //  JSONArray jsonarray5 = JSONArray.fromObject(a5);
         //   System.out.println(jsonarray5);

          /*  resoult="{\"ArrayIpPort\":"+jsonarray1+",\n" +
                    "\"ArrayGetWay\":"+jsonarray2+",\n" +
                    "\"ArrayRelace\":"+jsonarray3+",\n" +
                    "\"ArrayGroup\":"+jsonarray4+",\n" +
                    "\"ArrayLeaf\":"+jsonarray5+"}";
           */
            resoult="{\"ArrayIpPort\":"+jsonarray1+",\n" +
                    "\"ArrayGetWay\":"+jsonarray2+",\n" +
                    "\"ArrayGroup\":"+jsonarray4+"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        try {
            JSONObject jsonObject = JSONObject.fromObject(jInfo);
            String jsonStr = jsonObject.toString();
            System.out.println(jsonStr);
            resoult=jsonStr;
        } catch (Exception e) {
            System.out.println("转json失败");
        }
        String[] arr = {"asd","dfgd","asd","234"};

        JSONArray jsonarray = JSONArray.fromObject(arr);

        System.out.println(jsonarray);*/
       // System.out.println(map);
        return resoult;
    }

}
/*
class JsonInfo{
    public  String [] ArrayIpPort;
    public   String [] ArrayGetWay;  //需要二次填写
    public   String [] ArrayRelace;  //需要二次填写
    public   String [] ArrayGroup;
    public   Boolean [] ArrayLeaf;
}*/
