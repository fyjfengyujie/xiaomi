package com.xiaomi.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	//测试01-05为程序的路径测试，测试06为性能方面的测试
	/**
	 * 输入数组为null
	 */
	@Test
	public void testBinSearch01(){
		int [] a1 = null ;
		System.out.println("*********数组为null");
		System.out.println(Solution.binarySearch(a1,10,-1));
		System.out.println(Solution.binarySearch(a1,10,0));
		System.out.println(Solution.binarySearch(a1,10,1));

	}

	/**
	 * 输入数组长度为0
	 */
	@Test
	public void testBinSearch02(){

		int [] a2 = {};
		System.out.println("*********数组长度为0");
		System.out.println(Solution.binarySearch(a2,10,-1));
		System.out.println(Solution.binarySearch(a2,10,0));
		System.out.println(Solution.binarySearch(a2,10,1));
	}

	/**
	 * 输入数组为升序数组
	 */
	@Test
	public void testBinSearch03(){
		//查找值不在数组内
		int [] a3 = {1,2,3,4,5,6,7,8,10,11,12,13,14,15,16};
		System.out.println("*********数组升序并且值不在数组内");
		//1 查找值小于数组最小值
		int val1 = 0;
		System.out.println(Solution.binarySearch(a3,val1,0));
		//2 查找值大于数组最大值
		int val2 = 20;
		System.out.println(Solution.binarySearch(a3,val2,0));
		//3 查找值在数组值域区间内，但是不在数组内
		int val3 = 9;
		System.out.println(Solution.binarySearch(a3,val3,0));
		//4 数组升序并且查找值在数组内
		System.out.println("*********数组升序并且值在数组内");

		int val4 = 10;
		System.out.println("查找值为: " +val4);
		int index = Solution.binarySearch(a3, val4, 0);
		System.out.println("返回下标: "+index);
		if(index>=0)
			System.out.println("下标对应的值: "+a3[index]);
		System.out.println("比较次数: "+ Solution.count);
		System.out.println("~~~~~~~~~~~~~~~~~~~");

		int val5 = 15;
		System.out.println("查找值为: " +val5);
		index = Solution.binarySearch(a3, val5, 0);
		System.out.println("返回下标: "+index);
		if(index>=0)
			System.out.println("下标对应的值: "+a3[index]);
		System.out.println("比较次数: "+ Solution.count);
		System.out.println("~~~~~~~~~~~~~~~~~~~");


	}

	/**
	 * 输入数组为降序数组
	 */
	@Test
	public void testBinSearch04(){
		//查找值不在数组内
		int [] a3 = {16,15,14,13,12,11,10,8,7,6,5,4,3,2,1};
		System.out.println("*********数组降序并且值不在数组内");
		//1 查找值小于数组最小值
		int val1 = 0;
		System.out.println(Solution.binarySearch(a3,val1,1));
		//2 查找值大于数组最大值
		int val2 = 20;
		System.out.println(Solution.binarySearch(a3,val2,1));
		//3 查找值在数组值域区间内，但是不在数组内
		int val3 = 9;
		System.out.println(Solution.binarySearch(a3,val3,1));
		//4 数组升序并且查找值在数组内
		System.out.println("*********数组降序并且值在数组内");

		int val4 = 8;
		System.out.println("查找值为: " +val4);
		int index = Solution.binarySearch(a3, val4, 1);
		System.out.println("返回下标: "+index);
		if(index>=0)
			System.out.println("下标对应的值: "+a3[index]);
		System.out.println("比较次数: "+ Solution.count);
		System.out.println("~~~~~~~~~~~~~~~~~~~");

		int val5 = 3;
		System.out.println("查找值为: " +val5);
		index = Solution.binarySearch(a3, val5, 1);
		System.out.println("返回下标: "+index);
		if(index>=0)
			System.out.println("下标对应的值: "+a3[index]);
		System.out.println("比较次数: "+ Solution.count);
		System.out.println("~~~~~~~~~~~~~~~~~~~");

	}

	/**
	 * 输入数组为无序数组
	 */
	@Test
	public void testBinSearch05(){
		//查找值不在数组内
		int [] a3 = {16,4,14,13,3,11,6,8,7,6,5,15,3,2,1};
		System.out.println("*********数组无序并且值不在数组内");
		int val1 = 0;
		System.out.println(Solution.binarySearch(a3,val1,-1));
		System.out.println("比较次数:"+ Solution.count);
		int val2 = 20;
		System.out.println(Solution.binarySearch(a3,val2,-1));
		System.out.println("比较次数:"+ Solution.count);
		int val3 = 9;
		System.out.println(Solution.binarySearch(a3,val3,-1));
		System.out.println("比较次数:"+ Solution.count);
		//4 数组升序并且查找值在数组内
		System.out.println("*********数组降序并且值在数组内");
		int val4 = 7;
		System.out.println(Solution.binarySearch(a3,val4,-1));
		System.out.println("比较次数:"+ Solution.count);
		int val5 = 15;
		System.out.println(Solution.binarySearch(a3,val5,-1));
		System.out.println("比较次数:"+ Solution.count);

	}

	/**
	 * 性能测试
	 */
	@Test
	public void testBinSearch06(){

		int allCount01 = 0;
		int allCount02 = 0;

		Random random = new Random();
		//查找数据源
		int []array = new int [10000];
		for(int i=0;i<10000;i++){
			array[i] = random.nextInt(10000);
		}
		//需要查找的值
		int []value = new int [100];
		for(int i=0;i<100;i++){
			value[i] = random.nextInt(10000);
		}
		System.out.println("暴力查找**************");
		for(int i=0;i<100;i++) {
			System.out.println("查找值为: " + value[i]);
			int index = Solution.binarySearch(array, value[i], -1);
			System.out.println("返回下标: "+index);
			if(index>=0)
				System.out.println("下标对应的值: "+array[index]);
			System.out.println("比较次数: "+ Solution.count);
			allCount01 += Solution.count;
			System.out.println("~~~~~~~~~~~~~~~~~~~");
		}

		//将数组排序为有序数组
		Arrays.sort(array);
		System.out.println("二分查找*************");
		for (int i=0; i<100;i++) {
			System.out.println("查找值为: " + value[i]);
			int index = Solution.binarySearch(array, value[i], 0);
			System.out.println("返回下标: "+index);
			if(index>=0)
				System.out.println("下标对应的值: "+array[index]);
			System.out.println("比较次数: "+ Solution.count);
			allCount02 += Solution.count;
			System.out.println("~~~~~~~~~~~~~~~~~~~");
		}

		System.out.println("暴力查找平均查找次数：" + allCount01/100);
		System.out.println("二分查找平均查找次数：" + allCount02/100);




	}

}
