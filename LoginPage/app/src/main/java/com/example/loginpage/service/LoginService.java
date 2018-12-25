package com.example.loginpage.service;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

public class LoginService {

    public static boolean saveInfo(Context context,String name,String pwd){
        try {
            //File file=new File("/data/data/com.example.loginpage/info.txt");
            File file=new File(context.getFilesDir(),"info.txt");
            FileOutputStream fos=new FileOutputStream(file);
            fos.write((name+"##"+pwd).getBytes());
            fos.close();
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
