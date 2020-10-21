/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oshi.jesus;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;


/**
 *
 * @author beatriz
 */
public class OshiHD {
    public static void main(String[] args) {
    SystemInfo si = new SystemInfo();    
    OperatingSystem os = si.getOperatingSystem();
    
    //java.util.List<OSProcess> running = si.getOperatingSystem().getProcesses(3, OperatingSystem.ProcessSort.MEMORY);
 
    for(OSProcess process: os.getProcesses(20, OperatingSystem.ProcessSort.MEMORY))
    {
        long ramMemory = process.getResidentSetSize() / 1024;
        double cpuUsage = process.getProcessCpuLoadBetweenTicks(process);
      //  long diskUsage = process.getBytesRead() / process.getBytesWritten();
        
        System.out.println("ID    Nome         RAM             CPU");
        System.out.println(process.getProcessID() + " - " + process.getName() + " - " + ramMemory + " - " + cpuUsage + " - " + process.getBytesRead());
        
    }
    
    }
}