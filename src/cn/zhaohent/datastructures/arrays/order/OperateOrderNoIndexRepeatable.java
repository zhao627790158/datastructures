package cn.zhaohent.datastructures.arrays.order;

import java.util.ArrayList;
import java.util.List;

/**
 * ���Բ����ظ�ֵ ,��������
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
		// ����������
		int index = 0;
		// ���� dataӦ�ô�ŵ�λ��
		for (index = 0; index < currentIndex; index++) {
			if (datas[index] > data) {
				break;
			}
		}
		// �����λ���Ժ����������ƶ�һλ
		// �ȳ� β����ʼ�ƶ� ��ֹ������
		for (int i = currentIndex; i > index; i--) {
			// ��ΪcurrentIndex ����++ ��������ֱ��ʹ��currentIndex
			datas[i] = datas[i - 1];
		}
		// ��data���õ�Ӧ�ô�ŵ�λ��
		datas[index] = data;
		currentIndex++;
		return currentIndex - 1;
	}

	/**
	 * ��ȡ����data�������е�����λ��
	 * 
	 * @param begin
	 *            ��ʼ���ҵ�λ��
	 * @param data
	 *            Ҫ��������������
	 * @return �������ʼλ�������һ������
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
		// �������ݶ�Ӧ������
		int index = getIndex(0, data);
		// ѭ�������������,ֱ���ҵ�Ϊֹ
		while (index >= 0) {
			for (int i = index; i < currentIndex; i++) {
				datas[i] = datas[i + 1];
			}
			currentIndex--;
			// �ٴβ��Һ�������ݶ�Ӧ������
			index = getIndex(index, data);
		}
	}

	public List<Integer> searchOne(int data) {
		List<Integer> retList = new ArrayList<Integer>();
		int index = getIndex(0, data);
		while (index >= 0) {
			retList.add(datas[index]);
			// �ٴβ���
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
