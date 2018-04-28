package com.android.rfid;

import java.util.List;

import android.content.pm.ResolveInfo;

public interface IDev {
	/**
	 * ����HOME��
	 * @param flag
	 * @return
	 */
	public boolean lockHome(boolean flag);
	/**
	 * ��������֪ͨ
	 * @param flag
	 * @return
	 */
	public boolean lockStatusBar(boolean flag);
	/**
	 * ���÷��ؼ�
	 */
	public boolean lockBackKey(boolean flag);
	/**
	 * ��ȡ�豸ID
	 * @return
	 */
	public String getDeviceId();
	/**
	 * ��ȡ�豸IMEI��
	 * @return
	 */
	public String getSerialNumber();
	/**
	 * ����ϵͳʱ��
	 * @param when
	 * @return
	 */
	public boolean setCurrentTime(long when);
	
	/**
	 * ���ò˵���
	 * @param flag
	 * @return
	 */
	public boolean setMenuKey(boolean flag);
	
	/**
	 * ����ʱ����������
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
	 * ��Ĭ��װAPK
	 * @param apkFilePath
	 */
	public void installApk(String apkFilePath) ;
	
	/**
	 * ��Ĭж��APK
	 * @param packageName
	 */
	public void UnInstallApk(String packageName) ;
	
	
	/**
	 *�ػ�
	 */
	public void shutdown() ;
	
	/**
	 *����
	 */
	public void reboot() ;
	
//	/**
//	 * �������������
//	 */
//	public void createNetWorkBlackList() ;
	
	/**
	 * ������������
	 * @param website
	 */
	public void addNetWorkBlackList(String website) ;
	
	/**
	 * ɾ�����������
	 * @param website
	 */
	public void deleteNetWorkBlackList(String website) ;
	
	/**
	 * ������������
	 * @param website
	 */
	public void clearNetWorkBlackList() ;
	
	/**
	 * ������������
	 * @param website
	 */
	public void addNetWorkWhiteList(String website) ;
	
	/**
	 * ɾ�����������
	 * @param website
	 */
	public void deleteNetWorkWhiteList(String website) ;
	
	/**
	 * ������������
	 * @param website
	 */
	public void clearNetWorkWhiteList() ;
	
	/**
	 * ����ͨ������
	 * @param flag
	 * @return
	 */
	public void setPhoneCall(boolean isForbidden) ;
	
	
	public List<ResolveInfo> getAutoRunApp();

	/**
	 * ��������������
	 * @param packageReceiver
	 * @param isForbidden
	 */
	public void setAutoRunApp(String packageReceiver, boolean isForbidden);
	
	/**
	 * �ָ���������
	 */
	public void recovery();
	/**
	 * ����WiFi�Ƿ����
	 */
	public void setWifiEnabled(boolean enabled);
	/**
	 * ���������Ƿ����
	 */
	public void setBtEnabled(boolean enabled);
	/**
	 * ����SIM���Ƿ����
	 */
	public void setSimEnabled(boolean enabled);
	/**
	 * ���õ���ģʽ�Ƿ����
	 */
	public void setAdbEnabled(boolean enabled);
	/**
	 * ���ô������洢�Ƿ���� 
	 */
	public void setUsbEnabled(boolean enabled);
	/**
	 * ����Gps�Ƿ����
	 */
	public void setGpsEnabled(boolean enabled);
	/**
	 * ����NFC�Ƿ����
	 */
	public void setNfcEnabled(boolean enabled);
	/**
	 * ����Ӧ�ð�����
	 */
	public void addWhiteAppsList(String pkgName);
	/**
	 * ���Ӧ�ð�����
	 */
	public void clearWhiteAppsList();
	/**
	 * ɾ��Ӧ�ð�����
	 */
	public void deleteWhiteAppsList(String pkgName);
	/**
	 * ��ѯӦ�ð�����
	 */
	public List<String> queryWhiteAppsList();
	/**
	 * ����Ӧ�ú�����
	 */
	public void addBlackAppsList(String pkgName);
	/**
	 * ���Ӧ�ú�����
	 */
	public void clearBlackAppsList();
	/**
	 * ɾ��Ӧ�ú�����
	 */
	public void deleteBlackAppsList(String pkgName);
	/**
	 * ��ѯӦ�ú�����
	 */
	public List<String> queryBlackAppsList();
	/**
	 * ���ʼ������APP
	 */
	public void addAlwaysApps(String pkgName);
	/**
	 * ɾ��ʼ������APP
	 */
	public void deleteAlwaysApps(String pkgName);
	/**
	 * ���ʼ������APP
	 */
	public void clearAlwaysApps();
	/**
	 * ��ѯʼ������APP
	 */
	public List<String> queryAlwaysApps();
}
