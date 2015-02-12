
/**
 * Write a description of class LemonadeClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LemonadeClass
{
    // instance variables - replace the example below with your own
    public int cash;
    public int lemons;
    public int sugar;
    public int lemonade;
    /**
     * Constructor for objects of class LemonadeClass
     */
    public LemonadeClass()
    {
        // initialise instance variables
        cash = 0;
    }
    public LemonadeClass(int cash)
    {
        // initialise instance variables
        this.cash = cash;
    }
    public LemonadeClass(int lemons, int sugar)
    {
        this.lemons = lemons;
        this.sugar = sugar;
    }

    public int getCash(){
        return cash;
    }
    
    public int getLemons(){
        return lemons;
    }
    
    public int getSugar(){
        return sugar;
    }
    
    public int getLemonade(){
        lemonade = lemons/3 + sugar/2;
        return lemonade*16;
    }
    
    public int purchase(int lemon, int suga){
        lemons = lemon + lemons;
        cash-=1;
        sugar = sugar + suga;
        cash-= 1;
        return cash;
    }
    public int sale(int lemona){
        cash = cash + lemona;
        return cash;
    }
    
    public int theft(int cashes){
        cash = cash - cashes;
        return cash;
    }
    public void makeBatch(){
        
    }
    
    public boolean compare(LemonadeClass other){
        int otherCash = other.getCash();
        if(otherCash> cash){
            return false;
        }
        else {
            return true;
        }
    }
    
}
