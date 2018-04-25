package com.gujian.debitapp.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.alibaba.fastjson.JSON;
import com.gujian.debitapp.entity.HelpEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by gujian
 * Time is 2017/10/17
 * Email is gujian@maihaoche.com
 */

public class AssetsUtil {

    public static HelpEntity getHelpJson(Context context){
        AssetManager am = context.getAssets();
        HelpEntity list = null;
        try {
            InputStream in = am.open("helpJson.txt");
            int lenght = in.available();
            //创建byte数组
            byte[] buffer = new byte[lenght];
            //将文件中的数据写入到字节数组中
            in.read(buffer);
            in.close();
            String result = new String(buffer);
            if(result!=null){
                list =  JSON.parseObject(result,HelpEntity.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
