package cn.keshe.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyServices {

    public String IsTntegerS(String str){
        String  a="1";
        if(str==null || "".equals(str.trim())){
            a="输入学号不能为空！";
        }else{
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str.trim());
            if(isNum.matches()) {
                if(str.trim().length()>18||str.trim().length()<8){
                    a="学号应在8到12位数字";
                }else{
                    a="";
                }
            }
            else{
                a="学号应为数字！";
            }
        }
        return a;
    }
    public  String Isempty( String str ) {
        String  a="1";
        if(str==null || "".equals(str.trim())){
            a="输入内容不能为空！";
        }else{
            a="";
        }
        return a;
    }
    public String IsTntegerPhone(String str){
        String  a="1";
        if(str==null || "".equals(str.trim())){
            a="输入电话不能为空！";
        }else{
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str.trim());
            if(isNum.matches()) {
                if(str.trim().length()>11||str.trim().length()<8){
                    a="电话应为8到11位数字";
                }else{
                    a="";
                }
            }
            else{
                a="电话应为数字！";
            }
        }
        return a;
    }

    public String IsPassword(String str){
        String a="2";
        if(str.length()<6||str.length()>18){
            a="密码必须为6到18位之间";
        }else{
            a="";
        }
        return a;
    }
    public String IsTntegerQQ(String str){
        String  a="3";
        if(str==null || "".equals(str.trim())){
            a="输入QQ不能为空！";
        }else{
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str.trim());
            if(isNum.matches()) {
               a="";
            }
            else{
                a="QQ应为数字！";
            }
        }
        return a;
    }
    public String IsTntegerT(String str){
        String  a=null;
        if(str==null || "".equals(str.trim())){
            a="输入工号不能为空！";
        }else{
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str.trim());
            if(isNum.matches()) {
                if(str.trim().length()>12||str.trim().length()<6){
                    a="工号应在6到12之间";
                }else{
                    a="";
                }
            }
            else{
                a="学号应为数字！";
            }
        }
        return a;
    }
}
