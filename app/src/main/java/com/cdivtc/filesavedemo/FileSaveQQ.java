package com.cdivtc.filesavedemo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 28461 on 2018/10/12.
 */

public class FileSaveQQ {
    //第一步：写保存QQ账号和密码的方法
    //通过类名来调用这个保存方法，所以要创建一个静态公有方法，返回值类型为boolean
    public static boolean saveUserInfo(Context context,String account,String password){
        //获取到文件输出流
        try {
            FileOutputStream fos = context.openFileOutput("data.txt",Context.MODE_PRIVATE);
            //写入信息
            fos.write((account+":"+password).getBytes());
            //关闭流
            fos.close();
            //返回数据
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //第二步获取信息的方法，就是从data.txt中获取到保存的QQ账号和密码
    public  static Map<String,String> getUserInfo(Context context){
        //定义一个字符串类型的变量，用来存放获取到的内容
        String content ="";
        //定义一个文件输入流，通过openFileInput方法来获取到这个输入流信息
        try {
            FileInputStream fis = context.openFileInput("data.txt");
            //通过字节类型的数组来存储获取的字节流
            byte[] buffer = new byte[fis.available()];
            //读取buffer中的内容
            fis.read(buffer);
            //转换成字符串类型的数据，并保存到content中
            content = new String(buffer);//读取到的内容是字符串account:password
            //定义一个Map类型的变量，通过键值对的形式来存放账号和密码
            Map<String,String> userMap = new HashMap<String, String>();
            //通过:来将获取的数据进行分割，分割成账号和密码
            //分割后会得到两个字符串，这就要定义一个字符串类型的数组，来存储这两个字符串
            String[] infos = content.split(":");
            //将分割出来的账号和密码，分别添加到userMap对象中
            userMap.put("account",infos[0]);
            userMap.put("password",infos[1]);
            //关闭输入流
            fis.close();
            //返回取出的数据
            return userMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
