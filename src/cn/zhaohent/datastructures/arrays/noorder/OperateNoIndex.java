package cn.zhaohent.datastructures.arrays.noorder;
/**
 * ��ʾ������������
 * ����value������
 * @author zhaoheng
 *
 */
public class OperateNoIndex {
	private int[] datas = null;
	private int currentIndex = 0;

	public OperateNoIndex(int length) {
		datas = new int[length];
	}
	
	public int insert(int data) {
		datas[currentIndex] = data;
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
		//�������ݶ�Ӧ������
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
	
	
	
}
