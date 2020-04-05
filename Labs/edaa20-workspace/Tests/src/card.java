public class card{
   public static void main(String args[]){
      //
      card.makeDeck();
   }

   public static card[] makeDeck(){
      card[] cards = new card[52];
      int index=0;
      for (int suit = 0;suit<=3;suit++){
         for (int rank = 1;rank<=13;rank++){
            cards[index] = new card(rank, suit);
         index++;
         }
      }
      return cards;
   }

   public int compareTo(card that){
      if (this.suit < that.suit){
         return -1;
      }
      if (this.suit > that.suit){
         return 1;
      }
      if (this.rank < that.rank){
         if (this.rank == 1) {
            return 1;
         } 
         else {
            return -1;
         }
      }
      if (this.rank > that.rank){
         if (that.rank == 1) {
            return -1;
         } 
         else {
            return 1;
         }
      }
      return 0;
   }

   public static int[] suitHist(card[] cards){
      int[] result = new int[4];
      for (card card:cards){
         result[card.getSuit()] += 1;
      }
      return result;
   }
   public static boolean hasFlush(card[] cards){
      for (int count:suitHist(cards)){
         if (count >= 5){
            return true;
         }
      }
      return false;
   }

   // Mark: Supporting
   private final int rank;
   private final int suit;
   public static final String[] RANKS = {
      null, "Ace", "2", "3", "4", "5", "6", "7",
   "8", "9", "10", "Jack", "Queen", "King"
   };
   public static final String[] SUITS = {
      "Clubs", "Diamonds", "Hearts", "Spades"
   };
   public card(int rank, int suit){
      this.rank = rank;
      this.suit = suit;
   }
   public String toString(){
      return RANKS[this.rank] + " of " + SUITS[this.suit];
   }
   public boolean equals(card that){
      return this.rank == that.rank && this.suit == that.suit;
   }
   
   public int getRank(){
      return this.rank;
   }
   public int getSuit(){
      return this.suit;
   }
   public static int searchUnsorted(card[] cards, card target){
      for (int i = 0; i < cards.length; i++) {
         if (cards[i].equals(target)) {
            return i; 
         }
      }
      return -1;
   }
   public static int searchSorted(card[] cards, card target, int low, int high) {
      if (high < low) { 
         return -1;}
      int mid = (low + high) / 2;
      int comp = cards[mid].compareTo(target);
      if (comp == 0) {
         return mid;
      } 
      else if (comp < 0) {
         return searchSorted(cards, target, mid + 1, high);
      } 
      else {
         return searchSorted(cards, target, low, mid - 1);
      }
   }
}