
/**
 * Write a description of class LemonadeTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LemonadeTester
{
    // instance variables - replace the example below with your own
    public static void main(String [] args){
        LemonadeClass stand = new LemonadeClass();
        LemonadeClass standOther = new LemonadeClass(300);
        
        
        stand.purchase(3,2);
        System.out.println(stand.getCash());
        System.out.println(stand.getLemons());
        System.out.println(stand.getSugar());
        System.out.println(stand.getLemonade());

        System.out.println();
        stand.sale(10);
        
        System.out.println(stand.getCash());
        System.out.println(stand.getLemons());
        System.out.println(stand.getSugar());
        System.out.println(stand.getLemonade());
        System.out.println();
        
        stand.theft(20);
        System.out.println(stand.getCash());
        System.out.println(stand.getLemons());
        System.out.println(stand.getSugar());
        System.out.println(stand.getLemonade());
        System.out.println();
        
        System.out.println(stand.compare(standOther));
        System.out.println();
        
        stand.makeBatch();
        System.out.println(stand.getCash());
        System.out.println(stand.getLemons());
        System.out.println(stand.getSugar());
        System.out.println(stand.getLemonade());
    }
}
