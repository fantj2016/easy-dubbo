package com.fantj.easydubbo.register;

import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

public class RemoteRegister {

    private static Map<String , List<URL>> map = new HashMap<>();

    public static void register(String interfaceName, URL url){
        try {
            if (null == map.get(interfaceName)|| map.size() <1 ){
                map.put(interfaceName, Collections.singletonList(url));
                return;
            }
            List<URL> urls = map.get(interfaceName);
            urls.add(url);
            map.put(interfaceName, urls);
        }catch (Exception e){
            // do nothing
        }finally {
            // 最后一步将map 持久化到本地(用来进行本地注册)
            saveFile();
        }
    }

    public static URL get(String interfaceName){
        if (CollectionUtils.isEmpty(map)){
            map = getFile();
        }
        List<URL> urls = map.get(interfaceName);
        // 随机或者采用某种策略从 list 中拿到一个url并返回
        Random random = new Random();
        int i = random.nextInt(urls.size());
        return urls.get(i);
    }

    public static void saveFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<URL>> getFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
