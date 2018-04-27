package com.android.rfid;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;

public class DevSettings implements IDev {

	private static final String SET_TIME = "android.rfid.SET_TIME";// 设置系统时间

	private static final String LOCK_HOME_KEY = "android.rfid.LOCK_HOME";// 禁用HOME

	private static final String LOCK_MENU_KEY = "android.rfid.LOCK_MENU";// 禁用最近使用程序窗口

	private static final String LOCK_STATUSBAR = "android.rfid.DISABLE_STATUSBAR";// 禁用下拉栏

	private static final String LOCK_BACK_KEY = "android.rfid.LOCK_BACK";// 禁用下拉栏
	
	private static final String SET_APN = "android.rfid.SET_APN";

	private static String APN_SETTINGS = "android.rfid.APN_SETTING";

	private static String INSTALL_APK = "android.rfid.INSTALL_APK";// 静默安装APK

	private static String UNINSTALL_APK = "android.rfid.UNINSTALL_APK";// 静默卸载APK

	private static String SHUTDOWN = "android.rfid.SHUTDOWN";// 关机

	private static String REBOOT = "android.rfid.REBOOT";// 重启

	private static String NETWORK_BLACK_LIST = "android.rfid.NETWORK_BLACK_LIST";// 网络黑名单

	private static String NETWORK_WHITE_LIST = "android.rfid.NETWORK_WHITE_LIST";// 网络白名单

	// PHONE_CALL
	private static String PHONE_CALL_SETTING = "android.rfid.PHONE_CALL_SETTING";// 通话设置

	private static String AUTO_RUN_SETTING = "android.rfid.AUTO_RUN_SETTING";// 自启动设置

	private static final int DISABLE_STATUSBAR = 0x00010000;

	private static final String REPAIR_TIME_PASSWORD = "android.rfid.REPAIR_TIME_PASSWORD";
	private Context context;

	public DevSettings(Context context) {
		this.context = context;
	}

	@Override
	public boolean lockHome(boolean flag) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(LOCK_HOME_KEY);
		intent.putExtra("lockHome", flag);
		context.sendBroadcast(intent);
		return true;
	}

	@Override
	public boolean lockStatusBar(boolean flag) {

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(LOCK_STATUSBAR);
		if (flag) {
			intent.putExtra("lockStatus", DISABLE_STATUSBAR);
		} else {
			intent.putExtra("lockStatus", 0);
		}

		context.sendBroadcast(intent);
		return false;
	}

	@Override
	public String getDeviceId() {
		return null;
	}

	@Override
	public String getSerialNumber() {
		return null;
	}

	@Override
	public boolean setCurrentTime(long when) {
		if (when < 0) {
			return false;
		}
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(SET_TIME);
		intent.putExtra("time", when);
		context.sendBroadcast(intent);
		return true;
	}

	@Override
	public boolean setMenuKey(boolean flag) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(LOCK_MENU_KEY);
		intent.putExtra("lockMenu", flag);
		context.sendBroadcast(intent);
		return true;
	}

	// @Override
	// public boolean setAPN(String name, String apn, String proxy, int port,
	// String user, String server, String password, String mmsc,
	// String mcc, String mnc, String mmsproxy, int mmsport, int authtype,
	// String type, String protocol, int bearer, String roamingprotocol,
	// boolean current) {
	// Intent intent = new Intent() ;
	// intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
	// intent.setAction(SET_APN) ;
	// intent.putExtra("name", name) ;
	// intent.putExtra("apn", apn) ;
	// intent.putExtra("proxy", proxy) ;
	// intent.putExtra("port", port) ;
	// intent.putExtra("user", user) ;
	// intent.putExtra("server", server) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// intent.putExtra("", name) ;
	// context.sendBroadcast(intent) ;
	// return false;
	// }

	@Override
	public void setTimePassword(String newPass) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(REPAIR_TIME_PASSWORD);
		intent.putExtra("timePassword", newPass);
		context.sendBroadcast(intent);

	}

	@Override
	public void setAPN(String name, String apn, String type, String mcc, String mnc, String proxy, String port,
			String mmsproxy, String mmsport, String user, String password, String server, String mmsc) {

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(APN_SETTINGS);
		intent.putExtra("name", name);
		intent.putExtra("apn", apn);
		intent.putExtra("type", type);
		intent.putExtra("mcc", mcc);
		intent.putExtra("mnc", mnc);
		intent.putExtra("proxy", proxy);
		intent.putExtra("port", port);
		intent.putExtra("mmsproxy", mmsproxy);
		intent.putExtra("mmsport", mmsport);
		intent.putExtra("user", user);
		intent.putExtra("password", password);
		intent.putExtra("server", server);
		intent.putExtra("mmsc", mmsc);
		context.sendBroadcast(intent);
	}

	@Override
	public void installApk(String apkFilePath) {

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(INSTALL_APK);
		intent.putExtra("path", apkFilePath);
		context.sendBroadcast(intent);
	}

	@Override
	public void UnInstallApk(String packageName) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(UNINSTALL_APK);
		intent.putExtra("path", packageName);
		context.sendBroadcast(intent);

	}

	@Override
	public void shutdown() {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(SHUTDOWN);
		context.sendBroadcast(intent);

	}

	@Override
	public void reboot() {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(REBOOT);
		context.sendBroadcast(intent);

	}

	// @Override
	// public void createNetWorkBlackList() {
	// Intent intent = new Intent() ;
	// intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
	// intent.setAction(NETWORK_BLACK_LIST) ;
	// intent.putExtra("create", "create") ;
	// context.sendBroadcast(intent) ;
	//
	// }

	@Override
	public void addNetWorkBlackList(String website) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(NETWORK_BLACK_LIST);
		intent.putExtra("web", website);
		context.sendBroadcast(intent);

	}

	@Override
	public void deleteNetWorkBlackList(String website) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(NETWORK_BLACK_LIST);
		intent.putExtra("web", website);
		intent.putExtra("del", "del");
		context.sendBroadcast(intent);

	}

	@Override
	public void clearNetWorkBlackList() {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(NETWORK_BLACK_LIST);
		intent.putExtra("del", "all");
		context.sendBroadcast(intent);

	}

	@Override
	public void addNetWorkWhiteList(String website) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(NETWORK_WHITE_LIST);
		intent.putExtra("web", website);
		context.sendBroadcast(intent);

	}

	@Override
	public void deleteNetWorkWhiteList(String website) {

	}

	@Override
	public void clearNetWorkWhiteList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPhoneCall(boolean isForbidden) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(PHONE_CALL_SETTING);
		intent.putExtra("phone_call", isForbidden);
		context.sendBroadcast(intent);
	}

	@Override
	public List<ResolveInfo> getAutoRunApp() {
		PackageManager mPackageManager = context.getPackageManager();
		Intent intent = new Intent(Intent.ACTION_BOOT_COMPLETED);
		return null;
	}

	@Override
	public void setAutoRunApp(String packageReceiver, boolean isForbidden) {
		// AUTO_RUN_SETTING
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(AUTO_RUN_SETTING);
		intent.putExtra("package_name", packageReceiver);
		intent.putExtra("isforbidden", isForbidden);
		context.sendBroadcast(intent);

	}

	@Override
	public void recovery() {
		Intent intent = new Intent();
		intent.setAction("android.rfid.MASTER_CLEAR");
		context.sendBroadcast(intent);
	}

	@Override
	public void setWifiEnabled(boolean enabled) {
		Intent intent = new Intent();
		if (enabled) {
			intent.putExtra("name", "wlan");
			intent.setAction("android.rfid.CONTROL_CONNECTION");
			intent.putExtra("limited", false);
			context.sendBroadcast(intent);
		} else {
			intent.putExtra("name", "wlan");
			intent.setAction("android.rfid.CONTROL_CONNECTION");
			intent.putExtra("limited", true);
			context.sendBroadcast(intent);
		}
	}

	@Override
	public void setBtEnabled(boolean enabled) {
		Intent intent = new Intent();
		intent.putExtra("name", "bluetooth");
		intent.setAction("android.rfid.CONTROL_CONNECTION");
		if (enabled) {
			intent.putExtra("limited", false);
		} else {
			intent.putExtra("limited", true);
		}
		context.sendBroadcast(intent);
	}

	@Override
	public void setSimEnabled(boolean enabled) {
		Intent intent = new Intent();
		intent.putExtra("name", "sim");
		intent.setAction("android.rfid.CONTROL_INTERACTION");
		if (enabled) {
			intent.putExtra("shutdown", false);
		} else {
			intent.putExtra("shutdown", true);
		}
		context.sendBroadcast(intent);
	}

	@Override
	public void setAdbEnabled(boolean enabled) {
		Intent intent = new Intent();
		intent.setAction("android.rfid.CONTROL_ADB");
		if (enabled) {
			intent.putExtra("forbid_adb", false);
		} else {
			intent.putExtra("forbid_adb", true);
		}
		context.sendBroadcast(intent);
	}

	@Override
	public void setUsbEnabled(boolean enabled) {
		Intent intent = new Intent();
		intent.setAction("android.rfid.CONTROL_USB");
		if (enabled) {
			intent.putExtra("limite_usb", false);
		} else {
			intent.putExtra("limite_usb", true);
		}
		context.sendBroadcast(intent);
	}

	@Override
	public void setGpsEnabled(boolean enabled) {
		Intent intent = new Intent();
		intent.putExtra("name", "gps");
		intent.setAction("android.rfid.CONTROL_CONNECTION");
		if (enabled) {
			intent.putExtra("limited", false);
		} else {
			intent.putExtra("limited", true);
		}
		context.sendBroadcast(intent);
	}

	@Override
	public void setNfcEnabled(boolean enabled) {
		Intent intent = new Intent();
		intent.putExtra("name", "nfc");
		intent.setAction("android.rfid.CONTROL_INTERACTION");
		if (enabled) {
			intent.putExtra("shutdown", false);
		} else {
			intent.putExtra("shutdown", true);
		}
		context.sendBroadcast(intent);
	}

	@Override
	public void addWhiteAppsList(String pkgName) {
		Intent intent = new Intent();
		intent.putExtra("white_or_black", "white");
		intent.setAction("android.rfid.CONTROL_WOB_APP");
		intent.putExtra("pkgName", pkgName);
		context.sendBroadcast(intent);
	}

	@Override
	public void clearWhiteAppsList() {
		Intent intent = new Intent();
		intent.putExtra("white_or_black", "white");
		intent.putExtra("isClear", true);
		intent.setAction("android.rfid.CONTROL_WOB_APP");
		context.sendBroadcast(intent);
	}

	@Override
	public void deleteWhiteAppsList(String pkgName) {
		Intent intent = new Intent();
		intent.putExtra("white_or_black", "white");
		intent.putExtra("isDelect", true);
		intent.putExtra("pkgName", pkgName);
		intent.setAction("android.rfid.CONTROL_WOB_APP");
		context.sendBroadcast(intent);
	}

	@Override
	public List<String> queryWhiteAppsList() {
		List<String> arrayList = new ArrayList<String>();
		uri = getUri(FLAG_WHITE_APPS);
		Cursor cursor = context.getContentResolver().query(uri, new String[] { "_id, pkgName" }, null, null, null);
		if (cursor != null) {
			while (cursor.moveToNext()) {
				String name = cursor.getString(cursor.getColumnIndex("pkgName"));
				arrayList.add(name);
			}
			cursor.close();
		}
		return arrayList;
	}

	@Override
	public void addBlackAppsList(String pkgName) {
		Intent intent = new Intent();
		intent.putExtra("white_or_black", "black");
		intent.setAction("android.rfid.CONTROL_WOB_APP");
		intent.putExtra("pkgName", pkgName);
		context.sendBroadcast(intent);
	}

	@Override
	public void clearBlackAppsList() {
		Intent intent = new Intent();
		intent.putExtra("white_or_black", "black");
		intent.putExtra("isClear", true);
		intent.setAction("android.rfid.CONTROL_WOB_APP");
		context.sendBroadcast(intent);
	}

	@Override
	public void deleteBlackAppsList(String pkgName) {
		Intent intent = new Intent();
		intent.putExtra("white_or_black", "black");
		intent.putExtra("isDelect", true);
		intent.putExtra("pkgName", pkgName);
		intent.setAction("android.rfid.CONTROL_WOB_APP");
		context.sendBroadcast(intent);
	}

	@Override
	public List<String> queryBlackAppsList() {
		List<String> arrayList = new ArrayList<String>();
		uri = getUri(FLAG_BLACK_APPS);
		Cursor cursor = context.getContentResolver().query(uri, new String[] { "_id, pkgName" }, null, null, null);
		if (cursor != null) {
			while (cursor.moveToNext()) {
				String name = cursor.getString(cursor.getColumnIndex("pkgName"));
				arrayList.add(name);
			}
			cursor.close();
		}
		return arrayList;
	}

	Uri uri;
	private static int FLAG_WHITE_APPS = 1;
	private static int FLAG_BLACK_APPS = 0;

	private Uri getUri(int whiteOrBlack) {
		Uri appsUri;
		if (whiteOrBlack == FLAG_WHITE_APPS) {
			appsUri = Uri.parse("content://android.rfid.wob.WOBContentProvider/whiteapps");
		} else {
			appsUri = Uri.parse("content://android.rfid.wob.WOBContentProvider/blackapps");
		}
		return appsUri;
	}

	@Override
	public boolean lockBackKey(boolean flag) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		intent.setAction(LOCK_BACK_KEY);
		intent.putExtra("lockBack", flag);
		context.sendBroadcast(intent);
		return false;
	}

}
