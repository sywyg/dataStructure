package com.sywyg.sort;

/**
 * 快速排序
 * 思想：选择一个基准值,通常选择第一个或者最后一个。
 * 通过一趟扫描，将待排序列分成两部分,小于基准值在左,大于等于基准值在右。
 * 而基准值在最终排序的位置,然后再用同样的方法递归排序左右两部分。
 * 时间复杂度分析：java宝典
 * @author sywyg
 * @since 2015.7.28
 * @version 1.1
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = {1,2,12,3,4,6,1,8,0,11,11,2,12};
		for (int i : array) {
			System.out.print(i + ",");
			
		}
		
		System.out.println("\n排序之后");
		
		QuickSort sort = new QuickSort();
		sort.solution(array,0,array.length-1);
		for (int i : array) {
			System.out.print(i + ",");
		}
	}

	/**
	 * 实现快排
	 * @param array 将要排序的数组
	 * @param start 数组起始位置，0 
	 * @param end 数组最后元素下标
	 */
	public void solution(int[] array,int start,int end){
		if(start < 0 || end < 0) return;
		if(start >= array.length || end >= array.length) return;
		if(start >= end) return;
		// 数组第一个元素作为基准值
		int temp = array[start];
		// 获取起始位置和结束位置
		int tempStart = start;
		int tempEnd = end;
		// 开始排序
		while(tempStart < tempEnd){
			// 1. 先从后往前遍历
			while(array[tempEnd] >= temp && tempStart < tempEnd)
				tempEnd--;
			if(tempStart < tempEnd)
				// 小于temp的值就要放在tempStart位置
				array[tempStart++] = array[tempEnd];
			else 
				// 不存在小于temp的值，然后跳出循环
				break;
			
			// 2. 出现后面的值比temp小的情况后，从前往后遍历
			while(array[tempStart] <= temp && tempStart < tempEnd)
				tempStart++;
			if(tempStart < tempEnd)
				// 大于temp的值就要放在tempEnd位置
				array[tempEnd++] = array[tempStart];
			else
				break;
		}
		// 存放temp最终的位置
		array[tempStart] = temp;
		// 递归遍历左右两部分
		solution(array, start, tempStart - 1);
		solution(array, tempEnd + 1, end);
	}
}
