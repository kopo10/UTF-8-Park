package amu_park;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Write {
	public void write (String DayOrNight, String HowOld, String Count, String Price, String Discount) throws IOException {
		FileOutputStream output = new FileOutputStream("C:\\Users\\류한열\\Desktop\\out133.csv", true);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		Calendar cal =Calendar.getInstance();
		OutPutClass out = new OutPutClass();
		Run run = new Run();
		InputClass intput = new InputClass();
		
		String write = "";
		
		write = sdf.format(cal.getTime()) + String.format(",%s,%s,%s,%s,%s\n", DayOrNight, HowOld, Count, Price, Discount);
		output.write(write.getBytes());
		output.close();			
	   
	}	
}



//날짜 권종 연령구분 수량 가격 우대사항	