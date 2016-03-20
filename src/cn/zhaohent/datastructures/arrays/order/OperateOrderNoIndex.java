package cn.zhaohent.datastructures.arrays.order;
/**
 * 演示有序数组, 假设:存放不重复的值
 * @author zhaoheng
 *
 */
public class OperateOrderNoIndex {
	private int[] datas = null;
	private int currentIndex = 0;

	public OperateOrderNoIndex(int length) {
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

	private int getIndex(int data){
		int index =-1;
		for(int i =0;i<currentIndex;i++){
			if(datas[i]==data){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void remove(int data) {
		//查找数据对应的索引
		int index =getIndex(data);
		for(int i = index;i<currentIndex;i++){
			datas[i]=datas[i+1];
		}
		currentIndex--;
		
	}
	public int searchOne(int data) {
		int index = getIndex(data);
		return datas[index];
	}
	public void printDatas(){
		System.out.println("====================");
		for(int d : datas){
			System.out.println(d);
		}
	}
	
	public static void main(String[] args) {
		OperateOrderNoIndex t = new OperateOrderNoIndex(10);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(1);
		t.printDatas();
		
		t.remove(1);
		t.printDatas();
	}
	
	
	
}
