package com.doctor.ch12;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author sdcuike
 *
 * @time 2015年10月25日 上午12:16:24
 */
public class Sec05 {

	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

		ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
		System.out.println(zonedDateTime);

		System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Shanghai")));
	}

}
