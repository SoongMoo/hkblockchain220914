package hk220922;

public class Ex01Test {

	public static void main(String[] args) {
		/*  상품 정보를 가지는 Goods라는 클래스가 있고
		 * 클래스에는 멤버가  private로 
		 * goodsName, goodsPrice, goodsContent가 있다.
		 * 
		 * 고객 정보를 가지는 Member라는 클래스가 있고 
		 * 클래스에는 멤버가 private로 
		 * memberName, memberAddr, memberAge가 있다.
		 * 
		 * 다음과 같이 출력되게 하시오.
		 * "성남에 사는 나이가 30인 이숭무님이 30000원짜리 손선풍기를 사셨습니다."
		 */
		Goods goods = new Goods();
		goods.setGoodsContent("값 싼 선풍기입니다.");
		goods.setGoodsName("손선풍기");
		goods.setGoodsPrice(30000);
		
		Member member = new Member();
		member.setMemberAddr("성남");
		member.setMemberAge(30);
		member.setMemberName("이숭무");
		
		String goodsName = goods.getGoodsName();
		int goodsPrice = goods.getGoodsPrice();
		
		String memberName = member.getMemberName();
		String memberAddr = member.getMemberAddr();
		int memberAge =  member.getMemberAge();
		
		System.out.println(
				memberAddr + "에 사는 나이가 " +
				memberAge + "인 이숭무님이 " + 
				goodsPrice + "원짜리 " + 
				goodsName + "를 사셨습니다.");
	}
}
