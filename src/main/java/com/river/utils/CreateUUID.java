package com.river.utils;

import java.util.UUID;

public class CreateUUID {

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
