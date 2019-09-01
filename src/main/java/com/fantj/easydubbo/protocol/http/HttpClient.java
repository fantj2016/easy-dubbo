package com.fantj.easydubbo.protocol.http;


import com.fantj.easydubbo.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public String post(String hostname, Integer port, Invocation invocation){
        ObjectOutputStream oos = null;
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            // 发送数据
            OutputStream outputStream = urlConnection.getOutputStream();
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            oos.flush();

            // 接收数据
            InputStream inputStream = urlConnection.getInputStream();
            return IOUtils.toString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
