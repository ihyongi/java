package ch10;

public class TypeConversion {

	public static void main(String[] args) {

		int iNum=225;
		byte bNum=(byte)iNum;
		System.out.println(bNum);
		
		double dNum = 1.2;
		float fNum = 0.9F;
		
		int iNum1=(int)dNum +(int)fNum;
		int iNum2=(int)(dNum +fNum);
		
		System.out.println(iNum1);
		System.out.println(iNum2);

	}

}
