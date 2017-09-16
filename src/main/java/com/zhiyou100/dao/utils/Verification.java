package com.zhiyou100.dao.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Verification {
	public static String verification() {
		String[] beforeShuffle = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		List list = Arrays.asList(beforeShuffle); // 将数组转成List
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(3, 9);
		System.out.print(result);
		return result;
	}
}