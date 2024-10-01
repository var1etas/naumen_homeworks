package com.study.naumen.homework2.task5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Task5 implements Task {

    static boolean flag;
    static String fileName;

    public void run() {
        Task5 task5 = new Task5();
        Scanner sc = new Scanner(System.in);
        while (true){
            String method = sc.next();
            if (method.equals("start")){
                flag = true;
                Thread t1 = new Thread(task5::start);
                t1.start();
            }
            if (method.equals("stop")){
                task5.stop();
            }
        }
    }

    @Override
    public void start() {
        String url = "https://cdn.mp3xa.me/PWz1xuIAReEGrHl_DXYk9w/1727808529/L21wMy8yMDEyLzEwL0FkZWxlIC0gUm9sbGluZyBpbiB0aGUgZGVlcC5tcDM";
        try (HttpClient client = HttpClient.newHttpClient())
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> jsonResponse = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            String response = jsonResponse.headers().map().get("content-disposition").getLast();
            fileName = response.substring(response.indexOf("=")+2,response.lastIndexOf("\""));
        } catch (Exception e){
            fileName = " ";
            System.out.println(e.getMessage());
        }

        System.out.println(fileName + " start downloading...");

        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())) {
            String pathName = "C:/Users/filat/Downloads/" + fileName;
            FileOutputStream fileOutputStream = new FileOutputStream(pathName);
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                if (!flag) {
                    fileOutputStream.close();
                    File file = new File(pathName);
                    if (file.exists()) {
                        System.out.println("Download stop, file delete: " + file.delete());
                    }
                    break;
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(flag) System.out.println(fileName + " download finish");
    }

    @Override
    public void stop() {
        flag = false;
    }
}
