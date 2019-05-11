package com.example.demo;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class SpringBootSecondsKillApplicationTests
{

    /**
     * 模拟50次秒杀请求
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        String url = "http://localhost:8080/secondsKill?product_id=1";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        for (int i = 0; i < 100; i++)
        {
            httpClient.execute(get);
        }
    }

}
