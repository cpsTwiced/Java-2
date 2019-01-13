public class Room{
   //Instance variables
   public final String[] roomIndex = {"Empty", "Monster", "Treasure", "Stairs"};
   private String contents;
   private boolean treasureAv;
   //Constructor, creates the deault room at the start of each floor
   public Room(){
      contents = "Empty";
      treasureAv = true;
   }
   //Set method for room type
   public void setContents(int i){
      contents = roomIndex[i];
   }
   //Get method for room type
   public String getContents(){
      return contents;
   }
   //
   public boolean getTreasureAv(){
      return treasureAv;
   }
   //
   public void setTreasureAv(boolean b){
      treasureAv = b;
   }
}
   