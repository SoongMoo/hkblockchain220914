package hk220919;

public class Ex09 {
	public static void main(String [] args) {
		int num = (int)(Math.random() * 6) + 1;
		System.out.println(num);
		if(num == 1 || num == 4) {
			System.out.println('A');
		}else if(num == 2 || num == 5) {
			System.out.println('B');
		}else if(num == 3 || num == 6) {
			System.out.println('C');
		}
		System.out.println("=== swith ====");
		switch(num){
			case 1: 
			case 4: System.out.println('A');break;
			case 2: 
			case 5: System.out.println('B');break;
			case 3: 
			case 6: System.out.println('C');break;
		}
		
		String location = "서울";
		if (location.equals("서울")) {// if(location == "서울")
			System.out.println("서울 버스요금은 1350원입니다.");
		}else if(location.equals("인천")) {// if(location == "인천")
			System.out.println("인천 버스요금은 1400원입니다.");
		}else if(location.equals("성남")) {// if(location == "성남")
			System.out.println("성남 버스요금은 1450원입니다.");
		}
		System.out.println("=== switch ===");
		location  = "성남";
		switch(location) {
		case "서울":
			System.out.println("서울 버스요금은 1350원입니다.");
			break;
		case "인천":
			System.out.println("인천 버스요금은 1400원입니다.");
			break;
		case "성남":
			System.out.println("성남 버스요금은 1450원입니다.");
			break;
		}
	}
}
