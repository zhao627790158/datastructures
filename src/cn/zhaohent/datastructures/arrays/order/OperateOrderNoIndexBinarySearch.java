package cn.zhaohent.datastructures.arrays.order;
/**
 * ��ʾ��������, ����:��Ų��ظ���ֵ
 * ���ֲ���
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

	/**
	 * ���ֲ���
	 * @param data
	 * @return
	 */
	private int binaySearch(int data){
		//Ĭ�� ������������
		int index =-1;
		//������ʾС���������
		int lowIndex=0;
		//��ʾ�����ߵ�����
		int highIndex=currentIndex-1;
		while(true){
			if(lowIndex > highIndex){
				//û���ҵ�
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
		//�������ݶ�Ӧ������
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
