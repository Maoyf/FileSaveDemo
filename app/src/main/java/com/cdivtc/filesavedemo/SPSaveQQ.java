package com.cdivtc.filesavedemo;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 28461 on 2018/10/22.
 */

public class SPSaveQQ {
    //保存QQ账号和密码到data.xml文件
    //创建用于保存QQ账号和密码的静态方法，返回类型为boolean
    public static boolean saveUserInfo(Context context,String account,String password){
        //获取SharedPreferences对象
        SharedPreferences sp = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        //调用SharedPreferences中的edit方法来获取可编辑的对象Editor
        SharedPreferences.Editor editor = sp.edit();
        //将要保存的数据添加到editor中
        editor.putString("account",account);
        editor.putString("password",password);
        editor.commit();
        return true;
    }

    //获取data.xml中存储的账号和密码
    //创建用于获取QQ账号和密码的静态方法，返回类型为Map,键值对
    public static Map<String,String> getUserInfo(Context context){
        //获取SharedPreferences对象
        SharedPreferences sp = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        //读取对象中的信息，用键值对的形式存放，默认值为空
        String account = sp.getString("account","");
        String password = sp.getString("password","");
        //实例化一个hashMap对象,用来存放获取到的键值对
        Map<String,String> userMap = new HashMap<String, String>();
        //将获取到的数据以键值对的形式，添加到userMap中
        userMap.put("account",account);
        userMap.put("password",password);
        return userMap;
    }

}
