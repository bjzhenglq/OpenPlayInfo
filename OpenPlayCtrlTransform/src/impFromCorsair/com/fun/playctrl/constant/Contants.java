/**
 * Project Name:OpenPlayCtrl
 * File Name:Contants.java
 * Package Name:com.fun.playctrl.constant
 * Date:2014-9-10上午10:18:47
 * Copyright (c) 2014, zhenglq@fun.tv All Rights Reserved.
 *
 */

package com.fun.playctrl.constant;

import java.util.HashMap;

/**
 * ClassName:Contants <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-10 上午10:18:47 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class Contants {

	public static final HashMap<String, Integer> areaTypeMap = new HashMap<String, Integer>();
	public static final HashMap<String, Integer> areaMap = new HashMap<String, Integer>();
	public static final HashMap<Integer, String> areaTaticMap = new HashMap<Integer, String>();
	public static final HashMap<String, Integer> clientTypeMap = new HashMap<String, Integer>();

	static {

		areaTypeMap.put("city", 1);
		areaTypeMap.put("province", 2);
		areaTypeMap.put("country", 3);
		areaTypeMap.put("area", 4);

		areaTaticMap.put(1, "海外");
		areaTaticMap.put(9, "香港");
		areaTaticMap.put(12, "澳门");
		areaTaticMap.put(11, "台湾");
		areaTaticMap.put(2, "北京");
		areaTaticMap.put(3, "上海");
		areaTaticMap.put(4, "广州");
		areaTaticMap.put(5, "深圳");
		areaTaticMap.put(6, "杭州");
		areaTaticMap.put(7, "长沙");
		areaTaticMap.put(8, "美国");
		areaTaticMap.put(10, "苏丹");

		areaMap.put("海外", 1);
		areaMap.put("香港", 2);
		areaMap.put("澳门", 3);
		areaMap.put("台湾", 4);
		areaMap.put("北京", 5);
		areaMap.put("上海", 6);
		areaMap.put("广州", 7);
		areaMap.put("深圳", 8);
		areaMap.put("天津", 9);
		areaMap.put("大连", 10);
		areaMap.put("青岛", 11);
		areaMap.put("烟台", 12);
		areaMap.put("淄博", 13);
		areaMap.put("无锡", 14);
		areaMap.put("苏州", 15);
		areaMap.put("温州", 16);
		areaMap.put("宁波", 17);
		areaMap.put("厦门", 18);
		areaMap.put("泉州", 19);
		areaMap.put("珠海", 20);
		areaMap.put("佛山", 21);
		areaMap.put("东莞", 22);
		areaMap.put("成都", 23);
		areaMap.put("杭州", 24);
		areaMap.put("郑州", 25);
		areaMap.put("武汉", 26);
		areaMap.put("哈尔滨", 27);
		areaMap.put("西安", 28);
		areaMap.put("长春", 29);
		areaMap.put("石家庄", 30);
		areaMap.put("沈阳", 31);
		areaMap.put("昆明", 32);
		areaMap.put("济南", 33);
		areaMap.put("南京", 34);
		areaMap.put("长沙", 35);
		areaMap.put("太原", 36);
		areaMap.put("福州", 37);
		areaMap.put("南宁", 38);
		areaMap.put("贵阳", 39);
		areaMap.put("乌鲁木齐", 40);
		areaMap.put("南昌", 41);
		areaMap.put("合肥", 42);
		areaMap.put("兰州", 43);
		areaMap.put("呼和浩特", 44);
		areaMap.put("西宁", 45);
		areaMap.put("海口", 46);
		areaMap.put("银川", 47);
		areaMap.put("美国", 48);
		areaMap.put("苏丹", 49);

		clientTypeMap.put("pc", 1);
		clientTypeMap.put("web", 2);
		clientTypeMap.put("aphone", 3);
		clientTypeMap.put("iphone", 4);
		clientTypeMap.put("ipad", 5);
		clientTypeMap.put("apad", 6);
		clientTypeMap.put("mweb", 7);
		clientTypeMap.put("winphone", 8);
		clientTypeMap.put("winpad", 9);
		clientTypeMap.put("third_part", 10);
		clientTypeMap.put("ott", 11);
	}
}
