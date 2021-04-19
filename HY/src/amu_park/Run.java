package amu_park;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Run {
	public InputClass inputclass = null;
	public ConstvaluseClass constval = null;
	public OutPutClass output = null;
	public Write write = null;
	
	public Run() {
		inputclass = new InputClass();
		constval = new ConstvaluseClass();
		output = new OutPutClass();
		write = new Write();
	}

	public int dayResidentNumber(String ResidentNumber) {
		Calendar time = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YY");
		int howmuch = 0;
		String b = sdf.format(time.getTime());
		int ThisYear = Integer.parseInt(b);
		int BornYear = Integer.parseInt(ResidentNumber.substring(0, 2));
		int OldOrYoung = (int) ResidentNumber.charAt(6) - 48;

		switch (OldOrYoung / 3) { // 5,6 탈북자는 고려하지 않았다.
		case 0:
			if (ThisYear - 1900 - BornYear < constval.min_Elder1) {
				howmuch = constval.Adult_Day_Price;
			} else {
				howmuch = constval.Elder_Day_Price;
			}
			return howmuch;
		case 1:
			if (ThisYear - 1900 - BornYear < constval.min_baby) {
				howmuch = constval.Kid_Day_Price;
				return howmuch;
			} else if (ThisYear - 1900 - BornYear < constval.Min_Teen1
					&& ThisYear - 1900 - BornYear > constval.Max_Teen2) {
				howmuch = constval.Teen_Day_Price;
			} else {
				howmuch = constval.Adult_Day_Price;
			}

		}
		return howmuch;
	}

	public int nightResidentNumber(String ResidentNumber) {
		Calendar time = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		int howmuch = 0;
		String b = sdf.format(time.getTime());
		int ThisYear = Integer.parseInt(b);
		int BornYear = Integer.parseInt(ResidentNumber.substring(0, 2));
		int OldOrYoung = (int) ResidentNumber.charAt(6) - 48;
		// System.out.println(OldOrYoung);
		switch (OldOrYoung / 3) { // 5,6 탈북자는 고려하지 않았다.
		case 0: // 2000년대 이전 출생자
			if (ThisYear - 1900 - BornYear < constval.min_Elder1) {
				howmuch = constval.Adult_night_Price;
			} else {
				howmuch = constval.Elder_night_Price;
			}
			return howmuch;
		case 1: // 2000년대 이후 출생자
			if (ThisYear - 1900 - BornYear < constval.min_baby) {
				howmuch = constval.Kid_night_Price;
				return howmuch;
			} else if (ThisYear - 1900 - BornYear < constval.Min_Teen1
					&& ThisYear - 1900 - BornYear > constval.Max_Teen2) {
				howmuch = constval.Teen_night_Price;
			} else {
				howmuch = constval.Adult_night_Price;
			}

		}
		return howmuch;
	}

	public double Discount(int discount) {
		double howdiscount = 0;
		switch (discount) {
		case 1:
			howdiscount = 1.0;
			break;
		case 2:
			howdiscount = constval.disabled;
			break;
		case 3:
			howdiscount = constval.DoForNation;
			break;
		case 4:
			howdiscount = constval.ManyChildren;
			break;
		case 5:
			howdiscount = constval.disabled;
			break;
		}
		return howdiscount;
	}

	public int total_price(int Price, String howmany, double discount) {
		int total_price = (int) (Price * Integer.parseInt(howmany) * discount);
		return total_price;	
	}
	
	public void write (String DayOrNight, String HowOld, String Count, String Price, String Discount) throws IOException {
		
		write.write(DayOrNight, HowOld, Count, Price, Discount);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
