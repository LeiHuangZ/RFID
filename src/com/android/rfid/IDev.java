package com.android.rfid;

import java.util.List;

import android.content.pm.ResolveInfo;

public interface IDev {
	/**
	 * 禁用HOME键
	 * @param flag
	 * @return
	 */
	public boolean lockHome(boolean flag);
	/**
	 * 禁用下拉通知
	 * @param flag
	 * @return
	 */
	public boolean lockStatusBar(boolean flag);
	/**
	 * 设置返回键
	 */
	public boolean lockBackKey(boolean flag);
	/**
	 * 获取设备ID
	 * @return
	 */
	public String getDeviceId();
	/**
	 * 获取设备IMEI号
	 * @return
	 */
	public String getSerialNumber();
	/**
	 * 设置系统时间
	 * @param when
	 * @return
	 */
	public boolean setCurrentTime(long when);
	
	/**
	 * 设置菜单键
	 * @param flag
	 * @return
	 */
	public boolean setMenuKey(boolean flag);
	
	/**
	 * 设置时间设置密码
	 * @param newPass
	 */
	public void setTimePassword(String newPass) ;
	
	/**
	 * 
	 * @param name
	 * @param apn
	 * @param type
	 * @param mcc
	 * @param mnc
	 * @param proxy
	 * @param port
	 * @param mmsproxy
	 * @param mmsport
	 * @param user
	 * @param password
	 * @param server
	 * @param mmsc
	 * @return
	 */
	public void setAPN(String name, String apn, String type, String mcc, String mnc, String proxy, String port,
    		String mmsproxy, String mmsport, String user, String password, String server, String mmsc
    		);
	
	/**
	 * 静默安装APK
	 * @param apkFilePath
	 */
	public void installApk(String apkFilePath) ;
	
	/**
	 * 静默卸载APK
	 * @param packageName
	 */
	public void UnInstallApk(String packageName) ;
	
	
	/**
	 *关机
	 */
	public void shutdown() ;
	
	/**
	 *重启
	 */
	public void reboot() ;
	
//	/**
//	 * 创建网络黑名单
//	 */
//	public void createNetWorkBlackList() ;
	
	/**
	 * 添加网络黑名单
	 * @param website
	 */
	public void addNetWorkBlackList(String website) ;
	
	/**
	 * 删除网络黑名单
	 * @param website
	 */
	public void deleteNetWorkBlackList(String website) ;
	
	/**
	 * 清空网络黑名单
	 * @param website
	 */
	public void clearNetWorkBlackList() ;
	
	/**
	 * 添加网络白名单
	 * @param website
	 */
	public void addNetWorkWhiteList(String website) ;
	
	/**
	 * 删除网络白名单
	 * @param website
	 */
	public void deleteNetWorkWhiteList(String website) ;
	
	/**
	 * 清空网络白名单
	 * @param website
	 */
	public void clearNetWorkWhiteList() ;
	
	/**
	 * 设置通话功能
	 * @param flag
	 * @return
	 */
	public void setPhoneCall(boolean isForbidden) ;
	
	
	public List<ResolveInfo> getAutoRunApp();

	/**
	 * 设置自启动程序
	 * @param packageReceiver
	 * @param isForbidden
	 */
	public void setAutoRunApp(String packageReceiver, boolean isForbidden);
	
	/**
	 * 恢复出厂设置
	 */
	public void recovery();
	/**
	 * 设置WiFi是否可用
	 */
	public void setWifiEnabled(boolean enabled);
	/**
	 * 设置蓝牙是否可用
	 */
	public void setBtEnabled(boolean enabled);
	/**
	 * 设置SIM卡是否可用
	 */
	public void setSimEnabled(boolean enabled);
	/**
	 * 设置调试模式是否可用
	 */
	public void setAdbEnabled(boolean enabled);
	/**
	 * 设置大容量存储是否可用 
	 */
	public void setUsbEnabled(boolean enabled);
	/**
	 * 设置Gps是否可用
	 */
	public void setGpsEnabled(boolean enabled);
	/**
	 * 设置NFC是否可用
	 */
	public void setNfcEnabled(boolean enabled);
	/**
	 * 设置应用白名单
	 */
	public void addWhiteAppsList(String pkgName);
	/**
	 * 清除应用白名单
	 */
	public void clearWhiteAppsList();
	/**
	 * 删除应用白名单
	 */
	public void deleteWhiteAppsList(String pkgName);
	/**
	 * 查询应用白名单
	 */
	public List<String> queryWhiteAppsList();
	/**
	 * 设置应用黑名单
	 */
	public void addBlackAppsList(String pkgName);
	/**
	 * 清除应用黑名单
	 */
	public void clearBlackAppsList();
	/**
	 * 删除应用黑名单
	 */
	public void deleteBlackAppsList(String pkgName);
	/**
	 * 查询应用黑名单
	 */
	public List<String> queryBlackAppsList();
	/**
	 * 添加始终运行APP
	 */
	public void addAlwaysApps(String pkgName);
	/**
	 * 删除始终运行APP
	 */
	public void deleteAlwaysApps(String pkgName);
	/**
	 * 清除始终运行APP
	 */
	public void clearAlwaysApps();
	/**
	 * 查询始终运行APP
	 */
	public List<String> queryAlwaysApps();
}
