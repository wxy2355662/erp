package com.mar.erp.base.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

public class GetIpUtil {
    /**
     * 获取用户真实IP地址，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，
     * 取X-Forwarded-For中第一个非unknown的有效IP字符串。
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     * <p>
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 获取请求ip
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        String headerIP = request.getHeader("x-real-ip");
        if(headerIP == null || "".equals(headerIP) || "null".equals(headerIP)){
            headerIP = request.getHeader("x-forwarded-for");
        }
        if(headerIP !=null && !"".equals(headerIP) && !"null".equals(headerIP)){
            ip = headerIP;
        }
        return ip;
    }

    /**
     * 获取真实的ip
     * @param request
     * @return
     * @throws UnknownHostException
     */
    public static String getRealIp(HttpServletRequest request){
        String ip;
        // 有的user可能使用代理，为处理用户使用代理的情况，使用x-forwarded-for
        if  (request.getHeader("x-forwarded-for") == null)  {
            ip = request.getRemoteAddr();
        }  else  {
            ip = request.getHeader("x-forwarded-for");
        }
        if  ("127.0.0.1".equals(ip))  {
            try {
                // 获取本机真正的ip地址
                ip = InetAddress.getLocalHost().getHostAddress();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ip;
    }


}


