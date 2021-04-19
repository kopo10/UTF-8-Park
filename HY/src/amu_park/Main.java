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

			int typediscount = Integer.parseInt(discount); // 우대사항을 번호로 표시
			String Real_discount = out.Discount2(typediscount); //우대사항을 글자로 표시

			int Real_DayOrNight = Integer.parseInt(DayOrNight); // 주간권 야간권
			if (Real_DayOrNight == 1) {
				run.dayResidentNumber(jumin); // 나이로 인한 할인된 가격
				run.Discount(typediscount); // 상황 할인
				totalprice = run.total_price(run.dayResidentNumber(jumin), count, run.Discount(typediscount)); //총 금액

			} else if (Real_DayOrNight == 2) {  // 주간권 야간권
				run.nightResidentNumber(jumin); // 나이에 따른 가격
				run.Discount(typediscount); // 상황에 따른 할인
									// count 수량
				totalprice = run.total_price(run.nightResidentNumber(jumin), count, run.Discount(typediscount)); //총금액

			}
			
			run.write(input.DayNight(Real_DayOrNight), out.group1(jumin), count, String.valueOf((int) (run.dayResidentNumber(jumin) * run.Discount(typediscount))), Real_discount + " \n"); // csv파일에 입력
			
			out.thanks(totalprice); // 감사인사
			
			String print = "";
			print += out.DayNight(Integer.parseInt(DayOrNight)) + " ";
			print += out.group1(jumin) + " X ";
			print += count + "  ";
			if (Integer.parseInt(DayOrNight) == 1) {
				print += (int) (run.dayResidentNumber(jumin) * run.Discount(typediscount)) + "원  ";
				
			} else {
				print += (int) (run.nightResidentNumber(jumin) * run.Discount(typediscount)) + "원  ";
			}
			print += "*" + Real_discount + "\n";

			real_total_price += totalprice; // 최종 총액을 구하기 위한 값
			get_Print_ArrayList.add(print); //ArrayList에 입력

			if (input.Continue() == 2) {
				out.done();
				out.Poliline1();
				for (int i = 0; i < get_Print_ArrayList.size(); i++) { //구입한 횟수만큼
					out.detail(get_Print_ArrayList.get(i)); //상세 내역을 출력
				}
				out.total_price(real_total_price); // 총 가격 출력
				out.line(); // 줄표시
			
				last = input.LastAsk(); // 마지막으로 묻기
				if (last == 2) {
					break;
				}
			}
		}
	}

}
