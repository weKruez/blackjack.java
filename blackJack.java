
/*TODO: 
    -(check)REMOVE CARD FROM DECKS AFTER PLACED ( USE ARRAY INDEX TO REMOVE CARD FROM 2 DIMENSIONAL STRING ARRAY)
    -Function of multiple decks. 
    -Betting of course will be added. 
    -Eventually splitting and double up will be added, 
    -More specified rules in blackJack v2.0.*/

public class blackJack {
    public static void main(String [] args){
        
        //int deck = 52;
        card x = new card();
        System.out.println("How many players excluding the dealer?");
        int users = IO.readInt();
        /*while(users < 2){
            if(users < 2)
            System.out.println("Error");
            users = IO.readInt();
            continue;
        }*/
        
        String [][] cardArr = {{"♥︎", "♦︎", "♣︎", "♠︎"}, {"2", "3",
            "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}};
        System.out.println("Welcome to BlackJack 1.0." + "\n");
        System.out.println("How many decks?");
        //int numDecks = IO.readInt();
        //deck = deck * numDecks;
        int val = 0;
    player:for(users = users; users >= 0; users--){
        val = 0;
         System.out.println("Deal cards?");
            boolean confirm = IO.readBoolean();
        while(!confirm){
            System.out.println("Must deal cards...");
            System.out.println("Deal cards?");
            confirm = IO.readBoolean();
            continue;
        }
        int suit = (int)(Math.random() * 4 + 1);
        int numCard = (int)(Math.random() * 13 + 1);
        
        
        
        int hitCount = 0;
        String hitConfirm = "hit";
        //System.out.println(cardArr[suit] + cardArr[suit][numCard]);    
        //for(hitCount = 2; hitCount <= 9 || !confirm.equalsIgnoreCase("hit"); hitCount++){ 
        
    top:for(int i = 0; i <= cardArr.length - 1; i++){
        for(int j = 0; j <= cardArr[i].length - 1; j++){
            String suit1 = cardArr[0][suit -1];
            String card1 = cardArr[0][suit-1] + cardArr[1][numCard-1] + "";
            //********************************************************************TEST CASE CARD 1//////********
            //card1 = "@A";
            suit = (int)(Math.random() * 4 + 1);
            numCard = (int)(Math.random() * 13 + 1);
            
            
            String suit2 = cardArr[0][suit -1];
            String card2 = cardArr[0][suit- 1] + cardArr[1][numCard-1] + "";
            
            System.out.println(card1 + " & " + card2);
            
            
            //***********************************************************************TEST CASE CARD 2///////////*****
            //card2 = cardArr[0][suit - 1] + "A";
            
            
            //loopcard: for(int cardloop = 1; cardloop <= 2; cardloop++){
            //if(cardloop == 1){
            
            if(card1.equals(suit1 + "A")){
                if(val > 10)
                    val = val + 1;
                if(val <= 10)
                    val = val + 11;
            }
            
            if(card1.equals(suit1 + "K") || card1.equals(suit1 + "10") || card1.equals(suit1 + "J") || card1.equals(suit1 + "Q"))
                val = val + 10;
            
            if(card1.equals(suit1 + "9"))
                val = val + 9;
            
            if(card1.equals(suit1 + "8"))
                val = val + 8;
            
            if(card1.equals(suit1 + "7"))
                val = val + 7;
            
            if(card1.equals(suit1 + "6"))
                val = val + 6;
            
            if(card1.equals(suit1 + "5"))
                val = val + 5;
            
            if(card1.equals(suit1 + "4"))
                val = val + 4;
            
            if(card1.equals(suit1 + "3"))
                val = val + 3;
            
            if(card1.equals(suit1 + "2"))
                val = val + 2;
            
            
            //else if(cardloop == 2){
            if(card2.equals(suit2 + "A")){
                if(val > 10)
                    val = val + 1;
                if(val <= 10)
                    val = val + 11;
            }
            
            if(card2.equals(suit2 + "K") || card2.equals(suit2 + "10") || card2.equals(suit2 + "J") || card2.equals(suit2 + "Q"))
                val = val + 10;
            
            if(card2.equals(suit2 + "9"))
                val = val + 9;
            
            if(card2.equals(suit2 + "8"))
                val = val + 8;
            
            if(card2.equals(suit2 + "7"))
                val = val + 7;
            
            if(card2.equals(suit2 + "6"))
                val = val + 6;
            
            if(card2.equals(suit2 + "5"))
                val = val + 5;
            
            if(card2.equals(suit2 + "4"))
                val = val + 4;
            
            if(card2.equals(suit2 + "3"))
                val = val + 3;
            
            if(card2.equals(suit2 + "2"))
                val = val + 2;
            
            card1.equals("");
            card2.equals("");
            
            
            
            //}
            
            //outer loop:top
            
            System.out.println(val);
        looptwen:while(val < 21){
            System.out.println("Stay or Hit?");
            hitConfirm = IO.readString();
        bottom: while(!hitConfirm.equalsIgnoreCase("stay") || !hitConfirm.equalsIgnoreCase("hit")){
            if (hitConfirm.equalsIgnoreCase("stay")){
                
                //COMPARE HANDS WITH DEALER
                
                break looptwen;
            }
            else if (hitConfirm.equalsIgnoreCase("hit")){
                hitCount++;
            
                while(hitCount <= 7 || val < 21){
                    
                    val = x.getVal(x.getCard(), val);
                    String nullCard = x.getCard();
                    System.out.println(nullCard);
                    System.out.println(val);
                    nullCard = "";
                    if(nullCard.equals("") || nullCard.equals(card1) || nullCard.equals(card2))
                    x.random();
                    break bottom;
                }
                hitConfirm = IO.readString();
                continue bottom;
            }
            else{
                System.out.println("Bad input, try again.");
                hitConfirm = IO.readString();
                continue bottom;
            }
            
            //bottom
        }
            
        }
            //global array loop
            if(val == 21){
                System.out.println("BLACKJACK!");
                break top;
            }
            if(val > 21){
                System.out.println("BUST!!! YOU LOSE!");
                break top;
            }
            if(val < 21){
                ;
                break top;
            }
            break top;
        }}
        }
        /////////////////////////////
        
                    
                    //NEED to make card [] of some number ALSO a way to decrement the deck when dealt a card
                    //card [] deck = new card [52];
                    
                    //card card333 = new card();
                    //card333.getCard();
                
      
        
}

    
        
    
                    

            
   
//In the proces of making a card class object (OOP), to instiatiate (deal) cards in a loop...Will also create player classes for dealer and multiple players in one game. Also the function of multiple decks. Betting of course will be added. Eventually splitting and double up will be added, in addition to more specified rules in blackJack v2.0.

public static class card{
    
    public String [] [] cardArr = {{"♥︎", "♦︎", "♣︎", "♠︎"}, {"2", "3",
    "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}};
    public int val = 0;
    public int suit = (int)(Math.random() * 4);
    public int numCard = (int)(Math.random() * 13);
 
    public String getCard(){
        for(int i = 0; i <= cardArr.length - 1; i++){
            for(int j = 0; j <= cardArr[i].length - 1; j++){
                String x = (cardArr[0][suit] + cardArr[1][numCard] + "");
                //TEST CASE 3 (NEW CARD)
                //x = "@A";
                //System.out.println(x);
                return x;
                
                }
            }
        return null;
        }
    
    public void random(){
        this.suit = (int)(Math.random() * 4);
        this.numCard = (int)(Math.random() * 13);
        this.val = 0;
    }
    
    public int getVal(String x, int val){
        if(x.equals(cardArr[0][suit] + "A")){
            if(val > 10)
                val = val + 1;
            if(val <= 10)
                val = val + 11;
        }
        
        if(x.equals(cardArr[0][suit] + "K") || x.equals(cardArr[0][suit] + "10") || x.equals(cardArr[0][suit] + "J") || x.equals(cardArr[0][suit] + "Q"))
            val = val + 10;
        
        
        if(x.equals(cardArr[0][suit] + "9"))
            val = val + 9;
        
        
        if(x.equals(cardArr[0][suit] + "8"))
            val = val + 8;
        
        
        if(x.equals(cardArr[0][suit] + "7"))
            val = val + 7;
        
        
        if(x.equals(cardArr[0][suit]+ "6"))
            val = val + 6;
        
        
        if(x.equals(cardArr[0][suit]+ "5"))
            val = val + 5;
        
        if(x.equals(cardArr[0][suit]+ "4"))
            val = val + 4;
        
        
        if(x.equals(cardArr[0][suit] + "3"))
            val = val + 3;
        
        
        if(x.equals(cardArr[0][suit] + "2"))
            val = val + 2;

       return val;
    }
    
    public void sub(String x){
        x =  cardArr[0][suit] + cardArr[1][numCard];
        x = "";
        }

    }
}
    /*public static player {
        
        String name;
        int val;
        
        }
    }
*/


        




    

