package amu_park;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OutPutClass {
	public ConstvaluseClass constval = null;

	public OutPutClass() {
		constval = new ConstvaluseClass();
	}

	Calendar time = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YY");
	SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY");
	String b = sdf.format(time.getTime());

	String thisyear = sdf.format(time.getTime());


	public String DayNight(int a) {
		if (a == 1) {
			return "�ְ���";
		} else {
			return "�߰���";
		}
	}

	public String group1(String jumin) {
		String group = "";
		if (Integer.parseInt(jumin.substring(0, 2)) > Integer.parseInt(thisyear)) { // 2000��� ���� �����
			if (Integer.parseInt(sdf1.format(time.getTime())) - 1900 - Integer.parseInt(jumin.substring(0, 2)) < 65) {
				group = "����";
			} else {
				group = "���";
			}
		} else {
			if (Integer.parseInt(jumin.substring(0, 2)) < constval.min_baby) {
				group = "����";
			} else if (Integer.parseInt(jumin.substring(0, 2)) > constval.Min_Teen1
					&& Integer.parseInt(jumin.substring(0, 2)) < constval.Max_Teen2) {
				group = "û�ҳ�";
			} else {
				group = "����";
			}
		}
		return group;

		// �ְ� û�ҳ� ���� ���� ���

	}

	public String Discount2(int discount) {
		if (discount == 1) {
			return "������ ����";
		} else if (discount == 2) {
			return "����� ���";
		} else if (discount == 3) {
 			return "������ ���";
		} else if (discount == 4) {
			return "���ڳ���";
		} else {
			return "�ӻ�� ���";
		}
	}

	public void thanks(int  price) {
		System.out.println("������" + price + "�� �Դϴ�\n�����մϴ�.");
	}
	
	
	
	public void done() {
		System.out.println("Ƽ�� �߱��� �����մϴ�.\n�����մϴ�.\n");
	}

	public void Poliline1() {
		System.out.println("================��������===============");
	}
	
	public void detail (String get_Print_ArrayList) {
		System.out.printf(get_Print_ArrayList);
	}
	
	public void total_price(int totalprice) {
		System.out.println("\n����� �Ѿ��� " + totalprice + "�� �Դϴ�.");		
	}
	
	public void line() {
		System.out.println("=====================================");
	}
	
	
	
	
	
}
