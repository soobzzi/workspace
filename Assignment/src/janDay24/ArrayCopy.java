package janDay24;


import java.util.Vector;

public class ArrayCopy {
	
		public Vector<String> moveToVector(String[] datas){
		
			Vector<String> v = new Vector<String>();
			
			for(int x = datas.length-1 ; x>=0 ; x--) {
				v.add(datas[x]);
				//v.addElement(datas[x]);
			//v�� ù��°���� datas[4]�� ���;ߵǰ� ���ʴ�� ����ִ´� 0����
							
			}
			return v;//�Ųٷ� ��µ�
					
		}
	
	public static void main(String args[]) {
		
		
		ArrayCopy ac = new ArrayCopy();
		String datas[]= {"1","2","3","4","5"};
		System.out.println(ac.moveToVector(datas));
			
			
		}
	}

