package amu_park;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;

	public InputClass() {
		sc = new Scanner(System.in);

	}

	public String DayOrNight() {
		String DayOrNight;
		System.out.printf("권종을 선택하세요\n1. 주간권\n2. 야간권\n");
		DayOrNight = sc.next();
		return DayOrNight;
	}

	public String ResidentNumber() {
		String ResidentNumber;
		System.out.printf("주민번호를 입력하세요\n");
		ResidentNumber = sc.next();
		return ResidentNumber;

	}

	public String HowMany() {
		String HowMany = "";

		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");

		HowMany = sc.next();
		while (Integer.parseInt(HowMany) > 10) {
			System.out.println("수량 초과입니다 다시 선택해주세요");
			HowMany = sc.next();
			if (Integer.parseInt(HowMany) < 11) {
				break;
			}
		}
		return HowMany;
	}

	public String Discount() {
		String Discount;
		System.out.println("우대사항을 선택하세요\n1. 없음(나이 우대는 자동처리)\n2. 장애인\n3. 국가유공장\n4. 다자녀\n5. 임산부");
		Discount = sc.next();
		return Discount;
	}

	public int price(int total_price) {
		System.out.println("가격은 : " + total_price + "입니다\n감사합니다");
		return 0;
	}

	public int Continue() {
		int Continue;
		System.out.println("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료");
		Continue = sc.nextInt();
		return Continue;
	}

	public String DayNight(int a) {
		if (a == 1) {
			return "주간권";
		} else {
			return "야간권";
		}
	}

	public String group1(String b) {
		if (Integer.parseInt(b) == 1) {
			return "유아";
		} else if (Integer.parseInt(b) == 2) {
			return "청소년";
		} else if (Integer.parseInt(b) == 3) {
			return "성인";
		} else {
			return "노인";
		}
	}

	public String Discount2(int discount) {
		if (discount == 1) {
			return "우대사항 없음";
		} else if (discount == 2) {
			return "장애인 우대";
		} else if (discount == 3) {
			return "유공자 우대";
		} else if (discount == 4) {
			return "다자녀우대";
		} else {
			return "임산부 우대";
		}
	}

	public int LastAsk() {
		int a = 0;
		System.out.println("계속 진행(1: 새로운 주문, 2: 프로그램 종료) :");
		a = sc.nextInt();
		return a;
	}

}