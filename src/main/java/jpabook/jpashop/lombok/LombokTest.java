package jpabook.jpashop.lombok;

public class LombokTest {

    public static void main(String[] args) {
        LombokMember lMember = new LombokMember();

        lMember.setId(10);
        lMember.setName("kimsujong");
        
        System.out.println( lMember.getId()  );
        System.out.println( lMember.getName() );
    }
}
