// ArrayList<ArrayList<String>> doublearray = new ArrayList<ArrayList<String>>();
package amu_park;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OutPutClass out = new OutPutClass();
		Run run = new Run();
		InputClass input = new InputClass();

		String jumin = "";
		String DayOrNight = "";
		String discount = "";
		String count = "";
		int last = 0;
		int totalprice = 0;
		int real_total_price = 0;

		ArrayList<String> get_Print_ArrayList = new ArrayList<String>();
		while (true) {
			DayOrNight = input.DayOrNight();
			jumin = input.ResidentNumber();
			count = input.HowMany();
			discount = input.Discount();

			int typediscount = Integer.parseInt(discount); // �������� ��ȣ�� ǥ��
			String Real_discount = out.Discount2(typediscount); //�������� ���ڷ� ǥ��

			int Real_DayOrNight = Integer.parseInt(DayOrNight); // �ְ��� �߰���
			if (Real_DayOrNight == 1) {
				run.dayResidentNumber(jumin); // ���̷� ���� ���ε� ����
				run.Discount(typediscount); // ��Ȳ ����
				totalprice = run.total_price(run.dayResidentNumber(jumin), count, run.Discount(typediscount)); //�� �ݾ�

			} else if (Real_DayOrNight == 2) {  // �ְ��� �߰���
				run.nightResidentNumber(jumin); // ���̿� ���� ����
				run.Discount(typediscount); // ��Ȳ�� ���� ����
									// count ����
				totalprice = run.total_price(run.nightResidentNumber(jumin), count, run.Discount(typediscount)); //�ѱݾ�

			}
			
			run.write(input.DayNight(Real_DayOrNight), out.group1(jumin), count, String.valueOf((int) (run.dayResidentNumber(jumin) * run.Discount(typediscount))), Real_discount + " \n"); // csv���Ͽ� �Է�
			
			out.thanks(totalprice); // �����λ�
			
			String print = "";
			print += out.DayNight(Integer.parseInt(DayOrNight)) + " ";
			print += out.group1(jumin) + " X ";
			print += count + "  ";
			if (Integer.parseInt(DayOrNight) == 1) {
				print += (int) (run.dayResidentNumber(jumin) * run.Discount(typediscount)) + "��  ";
				
			} else {
				print += (int) (run.nightResidentNumber(jumin) * run.Discount(typediscount)) + "��  ";
			}
			print += "*" + Real_discount + "\n";

			real_total_price += totalprice; // ���� �Ѿ��� ���ϱ� ���� ��
			get_Print_ArrayList.add(print); //ArrayList�� �Է�

			if (input.Continue() == 2) {
				out.done();
				out.Poliline1();
				for (int i = 0; i < get_Print_ArrayList.size(); i++) { //������ Ƚ����ŭ
					out.detail(get_Print_ArrayList.get(i)); //�� ������ ���
				}
				out.total_price(real_total_price); // �� ���� ���
				out.line(); // ��ǥ��
			
				last = input.LastAsk(); // ���������� ����
				if (last == 2) {
					break;
				}
			}
		}
	}

}
