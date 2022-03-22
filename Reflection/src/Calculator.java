import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.*;
import java.text.*;

import java.util.*;


public class Calculator {

	BigDecimal a;
	BigDecimal b;
	String sop;
	BigDecimal wynikB;
	BigDecimal m;
	Class<?> klasa;
	String wynik;



	public String doCalc(String string) {

		StringTokenizer st = new StringTokenizer(string, " \t\n\r\f.,:;()[]\"'?!-{}");
		
		a = new BigDecimal(st.nextToken());
		sop = st.nextToken();
		b = new BigDecimal(st.nextToken());
		
		wynikB = new BigDecimal("0");
		Map<String, Method> znaki = new HashMap<String, Method>();
		klasa = getClass();

		try {
			znaki.put("-", klasa.getDeclaredMethod("subtract"));
			znaki.put("+", klasa.getDeclaredMethod("add"));
			znaki.put("*", klasa.getDeclaredMethod("multiply"));
			znaki.put("/", klasa.getDeclaredMethod("divide"));


			wynikB = ((BigDecimal) znaki.get(sop).invoke(this));

			 DecimalFormat dform = new DecimalFormat("###.######");
			 DecimalFormatSymbols sym = dform.getDecimalFormatSymbols();
			 sym.setDecimalSeparator('.');
			 DecimalFormat df = new DecimalFormat("###.######", sym);

			 wynik = df.format(wynikB);

		} catch (InvocationTargetException e) {
			e.getCause().printStackTrace();
		} catch (Exception e) {
			return "błąd";}
		
		return wynik;
		}
	
	private BigDecimal add() {
		return a.add(b);
	}
	
	private BigDecimal subtract() {
		return a.subtract(b);
	}
	
	private BigDecimal multiply() {
		return a.multiply(b);
	}
	
	private BigDecimal divide() {
		return a.divide(b,7, RoundingMode.HALF_UP);
	}
}
