package com.warm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationStartTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
	}

	/**
	 * redis测试
	 * 
	 * @Param:
	 * @Return:
	 */
	@Test
	public void testRedis() throws Exception {
		String value = this.stringRedisTemplate.opsForValue().get("POINTS:INDEX:INDEX_SCENE06");
		System.out.println(value);
	}

	@Test
	public void chooseSort() throws Exception {
		int[] arr = { 1, 3, 2, 45, 65, 33, 12 };
		System.out.println("交换之前：");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		// 选择排序的优化
		for (int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
			int k = i;
			for (int j = k + 1; j < arr.length; j++) {// 选最小的记录
				if (arr[j] < arr[k]) {
					k = j; // 记下目前找到的最小值所在的位置
				}
			}
			// 在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
			if (i != k) { // 交换a[i]和a[k]
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
		System.out.println();
		System.out.println("交换后：");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}