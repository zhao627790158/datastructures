package cn.zhaohent.datastructures.arrays;
/**
 * 可以存放重复值的简单小案例
 * @author zhaoheng
 *
 */
public class OperateWithIndex {

	private int[] datas = null;
	private int currentIndex = 0;
	public OperateWithIndex(int length) {
		datas=new int[length];
	}

	public int insert(int data) {
		datas[currentIndex] = data;
		currentIndex++;
		return currentIndex-1;
	}

	public void remove(int index) {
		for(int i = index;i<currentIndex;i++){
			datas[i]=datas[i+1];
		}
		currentIndex--;
	}
	public int searchOne(int index) {
		//只简单演示算法思路
		//校验怎么的先不管了
		return datas[index];
	}
	public void printDatas(){
		System.out.println("====================");
		for(int d : datas){
			System.out.println(d);
		}
	}
	
	public static void main(String[] args) {
		OperateWithIndex t  = new OperateWithIndex(10);
		t.insert(2);
		t.insert(3);
		t.insert(5);
		t.insert(6);
		t.printDatas();
		t.remove(1);
		t.printDatas();
		
		t.searchOne(2);
	}

}
