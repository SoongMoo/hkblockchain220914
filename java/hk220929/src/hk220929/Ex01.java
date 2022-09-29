package hk220929;

public class Ex01{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = 10;
		obj = new Student(1000, "bsiufvbsv");
		obj = 18.0;
		obj = new Bus(101);
			
		obj = 120;
		System.out.println((int)obj + 10);
		obj = new SubWay(1);
		((SubWay)obj).showSubInfo();
		obj = "bijfbvsiu";
		System.out.println((String)obj + "bvuzbfv");
		
	}

}
