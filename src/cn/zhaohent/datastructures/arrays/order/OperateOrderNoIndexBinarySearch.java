package cn.zhaohent.datastructures.arrays.order;
/**
 * 演示有序数组, 假设:存放不重复的值
 * 二分查找
 * @author zhaoheng
 *
 */
public class OperateOrderNoIndexBinarySearch {
	private int[] datas = null;
	private int currentIndex = 0;

	public OperateOrderNoIndexBinarySearch(int length) {
		datas = new int[length];
	}
	
	public int insert(int data) {
		//假设是升序
		int index =0;
		//查找 data应该存放的位置
		for(index=0;index<currentIndex;index++){
			if(datas[index]> data){
				break;
			}
		}
		//把这个位置以后的数据向后移动一位
		//先冲 尾部开始移动 防止被覆盖
		for(int i=currentIndex;i>index;i--){
			//因为currentIndex 最后会++ 所以这里直接使用currentIndex
			datas[i]=datas[i-1];
		}
		//把data设置到应该存放的位置
		datas[index] = data;
		currentIndex++;
		return currentIndex-1;
	}

	/**
	 * 二分查找
	 * @param data
	 * @return
	 */
	private int binaySearch(int data){
		//默认 查找有序数组
		int index =-1;
		//用来表示小这面的索引
		int lowIndex=0;
		//表示大的这边的索引
		int highIndex=currentIndex-1;
		while(true){
			if(lowIndex > highIndex){
				//没有找到
				return -1;
			}
			index = (lowIndex+highIndex)/2;
			if(datas[index]==data){
				return index;
			}
			if(data < datas[index]){
				highIndex=index-1;
			}
			if(data>datas[index]){
				lowIndex = index+1;
			}
		}
	}
	
	public void remove(int data) {
		//查找数据对应的索引
		int index =binaySearch(data);
		for(int i = index;i<currentIndex;i++){
			datas[i]=datas[i+1];
		}
		currentIndex--;
		
	}
	public int searchOne(int data) {
		int index = binaySearch(data);
		return index>=0?datas[index]:-1;
	}
	public void printDatas(){
		System.out.println("====================");
		for(int d : datas){
			System.out.println(d);
		}
	}
	
	public static void main(String[] args) {
		OperateOrderNoIndexBinarySearch t = new OperateOrderNoIndexBinarySearch(10);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(1);
		t.printDatas();
		t.remove(1);
		t.printDatas();
		int ret = t.searchOne(1);
		System.out.println("ret=="+ret);
	}
	
	
	
}
