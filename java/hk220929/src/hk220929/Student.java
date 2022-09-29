package hk220929;

public class Student{
	int money;
	String name;
	Student(int money, String name){
		this.money = money;
		this.name = name;
	}
	
	//            매개변수를 객체변수   // int i = 20
	public void use(Object obj) {// Bus bus = bus
		if(obj instanceof Bus) {
			((Bus) obj).takeBus(1000);
		}else if(obj instanceof SubWay){
			((SubWay) obj).takeSub(1000);
		}else if(obj instanceof Integer) {
			System.out.println((int)obj);
		}
	}
	@Override
	public String toString() {
		return null;
	}
	public Boolean equals() {
		return null;
	}
	
}