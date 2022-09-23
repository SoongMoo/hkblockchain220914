package constructor;


// 멤머 필드, 멤버 메서드, 생성자 : 캡슐화 : 정보의 은닉
public class Member {
	String name;
	int nai;
	String addr;
	
	public Member() {}
	public Member(String name, int nai, String addr) {
		this.name = name;
		this.nai = nai;
		this.addr = addr;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setNai(int nai) {
		this.nai = nai;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public int getNai() {
		return nai;
	}
	public String getAddr() {
		return addr;
	}
	
	
	
	
	
	
}
