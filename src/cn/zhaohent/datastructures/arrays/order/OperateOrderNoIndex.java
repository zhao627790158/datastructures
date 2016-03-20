package cn.zhaohent.datastructures.arrays.order;
/**
 * ��ʾ��������, ����:��Ų��ظ���ֵ
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
		//����������
		int index =0;
		//���� dataӦ�ô�ŵ�λ��
		for(index=0;index<currentIndex;index++){
			if(datas[index]> data){
				break;
			}
		}
		//�����λ���Ժ����������ƶ�һλ
		//�ȳ� β����ʼ�ƶ� ��ֹ������
		for(int i=currentIndex;i>index;i--){
			//��ΪcurrentIndex ����++ ��������ֱ��ʹ��currentIndex
			datas[i]=datas[i-1];
		}
		//��data���õ�Ӧ�ô�ŵ�λ��
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
