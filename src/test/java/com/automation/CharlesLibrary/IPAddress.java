package com.automation.CharlesLibrary;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;

/**
 * @author Ramesh P
 */
public class IPAddress {
    CharlesHelper charlesHelper = new CharlesHelper();
    String getPlatform = charlesHelper.getPlatform();
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(IPAddress.class);
    String ip = null;
    public  String getIpAddress() throws Exception {
        if(getPlatform.contains("Mac")) {
            InetAddress i;
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = e.nextElement();
                Enumeration<InetAddress> ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    i = ee.nextElement();
                    if (i.getHostAddress().contains("192")) {
                        ip = i.getHostAddress();
                        log.info("<< IP Address of Machine is >> "+ip);
                    }
                }
            }
            return ip;
        }else{
            String localIp = null;
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("google.com", 80));
                ip=socket.getLocalAddress().toString();
                String[] iprange = ip.split("/");
                localIp = iprange[1];
            } catch (IOException e) {
                e.printStackTrace();
            }
            ip=localIp;
            log.info("IP of machine: "+ip);
            return ip;
        }
    }
}
