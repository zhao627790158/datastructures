package cn.zhaohent.datastructures.arrays.noorder;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以插入重复值
 * @author zhaoheng
 *
 */
public class OperateNoIndexRepeatable {
	

	private int[] datas = null;
	private int currentIndex = 0;

	public OperateNoIndexRepeatable(int length) {
		datas = new int[length];
	}
	
	public int insert(int data) {
		datas[currentIndex] = data;
		currentIndex++;
		return currentIndex-1;
	}

	/**
	 * 获取数据data在数组中的索引位置
	 * @param begin 开始查找的位置
	 * @param data 要查找索引的数据
	 * @return 在这个开始位置往后第一个索引
	 */
	private int getIndex(int begin,int data){
		int index =-1;
		for(int i =begin;i<currentIndex;i++){
			if(datas[i]==data){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void remove(int data) {
		//查找数据对应的索引
		int index =getIndex(0,data);
		//循环查找这个数据,直到找到为止
		while(index>=0){
			for(int i = index;i<currentIndex;i++){
				datas[i]=datas[i+1];
			}
			currentIndex--;
			//再次查找后序的数据对应的索引
			index =getIndex(index,data);
		}
	}
	public List<Integer> searchOne(int data) {
		List<Integer> retList = new ArrayList<Integer>();
		int index = getIndex(0,data);
		while(index>=0){
			retList.add(datas[index]);
			//再次查找
			index =getIndex(index+1,data);
		}
		return retList;
	}
	public void printDatas(){
		System.out.println("====================");
		for(int d : datas){
			System.out.println(d);
		}
	}
	
	
	

	
	
	
	
	
	
	

}
