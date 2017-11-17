package com.ntu.oa.util;

public class MsgInfo
{
    public static String a_suc_code = "200";// 请求成功
    
    public static String a_sucess_code = "0";// 天眼查请求成功

    public static String a_error_code = "500";// 请求失败

    public static String loginError_code = "501";// 未登录
    
    public static String no_user_code = "502";//该用户不存在
    
    public static String is_user_code = "503";//该手机已经被注册

    public static String a_paramExc_code_null = "400";// 请求参数错误 参数为空

    public static String a_paramExc_code_error = "401";// 请求参数错误 参数错误

    public static String a_resultNull_error = "402";// 请求参数错误 参数错误
    
    public static final String a_binderror_code = "303"; // 公司绑定全宗错误

    public static final String a_binderror_msg = "公司绑定全宗错误"; // 公司绑定全宗错误
    
    public static final String a_pwd_code = "原密码输入错误";//输入密码与正确密码不符
    
}
