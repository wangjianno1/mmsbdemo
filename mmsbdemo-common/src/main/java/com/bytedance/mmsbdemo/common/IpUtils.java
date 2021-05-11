package com.bytedance.mmsbdemo.common;

public class IpUtils {

    /**
     * IP地址转换成数值
     *
     * @param strIp
     * @return
     */
    public static long ip2Numeric(String strIp) {
        long[] ip = new long[4];
        String[] ipSec = strIp.split("\\.");
        for (int i = 0; i < 4; i++) {
            ip[i] = Long.valueOf(ipSec[i]);
        }
        long numericIp = (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
        return numericIp;
    }

    /**
     * 工具测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ip2Numeric("255.255.255.255"));

    }
}
