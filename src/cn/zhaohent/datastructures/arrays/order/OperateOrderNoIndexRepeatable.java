package cn.zhaohent.datastructures.arrays.order;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以插入重复值 ,有序数组
 * 
 * @author zhaoheng
 *
 */
public class OperateOrderNoIndexRepeatable {

	private int[] datas = null;
	private int currentIndex = 0;

	public OperateOrderNoIndexRepeatable(int length) {
		datas = new int[length];
	}

	public int insert(int data) {
		// 假设是升序
		int index = 0;
		// 查找 data应该存放的位置
		for (index = 0; index < currentIndex; index++) {
			if (datas[index] > data) {
				break;
			}
		}
		// 把这个位置以后的数据向后移动一位
		// 先冲 尾部开始移动 防止被覆盖
		for (int i = currentIndex; i > index; i--) {
			// 因为currentIndex 最后会++ 所以这里直接使用currentIndex
			datas[i] = datas[i - 1];
		}
		// 把data设置到应该存放的位置
		datas[index] = data;
		currentIndex++;
		return currentIndex - 1;
	}

	/**
	 * 获取数据data在数组中的索引位置
	 * 
	 * @param begin
	 *            开始查找的位置
	 * @param data
	 *            要查找索引的数据
	 * @return 在这个开始位置往后第一个索引
	 */
	private int getIndex(int begin, int data) {
		int index = -1;
		for (int i = begin; i < currentIndex; i++) {
			if (datas[i] == data) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void remove(int data) {
		// 查找数据对应的索引
		int index = getIndex(0, data);
		// 循环查找这个数据,直到找到为止
		while (index >= 0) {
			for (int i = index; i < currentIndex; i++) {
				datas[i] = datas[i + 1];
			}
			currentIndex--;
			// 再次查找后序的数据对应的索引
			index = getIndex(index, data);
		}
	}

	public List<Integer> searchOne(int data) {
		List<Integer> retList = new ArrayList<Integer>();
		int index = getIndex(0, data);
		while (index >= 0) {
			retList.add(datas[index]);
			// 再次查找
			index = getIndex(index + 1, data);
		}
		return retList;
	}

	public void printDatas() {
		System.out.println("====================");
		for (int d : datas) {
			System.out.println(d);
		}
	}
	
	public static void main(String[] args) {
		OperateOrderNoIndex t = new OperateOrderNoIndex(10);
		t.insert(3);
		t.insert(4);
		t.insert(3);
		t.insert(1);
		t.printDatas();
		
		t.remove(1);
		t.printDatas();
	}
	

}
