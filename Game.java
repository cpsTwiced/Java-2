/*REFERENCE: https://www.youtube.com/watch?v=I9yc9jj01-M for audio clip
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.media.*;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Game extends Application{
   private Text text;
   @Override
   public void start(Stage primaryStage){
      //Creates text
      text = new Text("You've descended into Floor 10, and come face to face with the boss, it roars in greeting.\nA diplay message pops up in front of you. \nAfter the boss is done, close this window to continue your quest.");
      Font font = Font.font("Arial", FontWeight.BOLD,20);
      text.setFont(font);
      //Accesses the audio file
      String musicFile = "MonsterRoar.mp3";
      Media sound = new Media(new File(musicFile).toURI().toString());
      MediaPlayer mediaPlayer = new MediaPlayer(sound);
      mediaPlayer.play();
      //Presents it on the stage
      StackPane root = new StackPane(text);
      primaryStage.setScene(new Scene(root, 1200, 450));
      primaryStage.setTitle("Monster's Roar");
      primaryStage.show();
   }
   
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
      //SPAWNING MONSTERS
	   //MUST ALSO CONSIDER GETTING RID OF THE SPAWNED MONSTER IF THE PLAYER CHOOSE TO RUN AWAY OR ONCE THE MONSTER HAS BEEN DEFEATED
	   //divide them into different attributes? 
	
	   //MONSTER LEVEL 1
	   //MONSTER 1 (type 1)
	 	int tempHealth, tempStrength, tempExp, tempGold, tempAgil;
		tempHealth = rand.nextInt(100) + 250;
		tempStrength = rand.nextInt(15) + 30;
		tempExp = rand.nextInt(10) + 40;
		tempGold = rand.nextInt(20) + 40;
		tempAgil = rand.nextInt(10) + 5;
		Monster cherufe = new Monster("Cherufe", "Cherufe, a beast made of fire and rock has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
		monsterList.add(cherufe);
	
   	//MONSTER 2 (type 1)
		tempHealth = rand.nextInt(100) + 250;
		tempStrength = rand.nextInt(15) + 30;
		tempExp = rand.nextInt(10) + 40;
		tempGold = rand.nextInt(20) + 40;
		tempAgil = rand.nextInt(10) + 5;
		Monster olitiau = new Monster("Olitiau", "Olitiau, a giant bat-like demon has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(olitiau);	   
	
   	//MONSTER 3 (type 2)
		tempHealth = rand.nextInt(100) + 250;
		tempStrength = rand.nextInt(15) + 30;
		tempExp = rand.nextInt(10) + 40;
		tempGold = rand.nextInt(20) + 40;
		tempAgil = rand.nextInt(10) + 5;
		Monster reaver = new Monster("Reaver", "Reaver, a giant caterpillar has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(reaver);	   
   	
   	//MONSTER 4 (type 2)
		tempHealth = rand.nextInt(100) + 250;
		tempStrength = rand.nextInt(15) + 30;
		tempExp = rand.nextInt(10) + 40;
		tempGold = rand.nextInt(20) + 40;
		tempAgil = rand.nextInt(10) + 5;
		Monster mutalisk = new Monster("Mutalisk", "Mutalisk, a flying bat-like creature has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(mutalisk);	   
	
   	//MONSTER 5 (type 3)
		tempHealth = rand.nextInt(100) + 250;
		tempStrength = rand.nextInt(15) + 30;
		tempExp = rand.nextInt(10) + 40;
		tempGold = rand.nextInt(20) + 40;
		tempAgil = rand.nextInt(10) + 5;
		Monster dragoon = new Monster("Dragoon", "Dragoon, a four-legged spider-like creature has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(dragoon);	   
	
   	//MONSTER 6 (type 3)
		tempHealth = rand.nextInt(100) + 250;
		tempStrength = rand.nextInt(15) + 30;
		tempExp = rand.nextInt(10) + 40;
		tempGold = rand.nextInt(20) + 40;
		tempAgil = rand.nextInt(10) + 5;
		Monster typhon = new Monster("Typhon", "Typhon, a giant monster with a giant human head and his body covered with dragon wings has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(typhon);	   
	
   	//MONSTER LEVEL 2
   	//MONSTER 7 (type 1)
		tempHealth = rand.nextInt(100) + 450;
		tempStrength = rand.nextInt(15) + 40;
		tempExp = rand.nextInt(10) + 50;
		tempGold = rand.nextInt(20) + 60;
		tempAgil = rand.nextInt(10) + 15;
		Monster ahool = new Monster("Ahool", "Ahool, a massive bat-like creature has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(ahool);	   
	
   	//MONSTER 8 (type 1)
		tempHealth = rand.nextInt(100) + 450;
		tempStrength = rand.nextInt(15) + 40;
		tempExp = rand.nextInt(10) + 50;
		tempGold = rand.nextInt(20) + 60;
		tempAgil = rand.nextInt(10) + 15;
		Monster chimera = new Monster("Chimera", "Chimera, a ferocious, fire breathing monster with a head of a lion and a goat with a snake for a tail has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(chimera);	   
		
   	//MONSTER 9 (type 2)
		tempHealth = rand.nextInt(100) + 450;
		tempStrength = rand.nextInt(15) + 40;
		tempExp = rand.nextInt(10) + 50;
		tempGold = rand.nextInt(20) + 60;
		tempAgil = rand.nextInt(10) + 15;
		Monster cyclops = new Monster("Cyclops", "Cyclops, a giant monster with a bulging eye on the forehead has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(cyclops);	   
	
   	//MONSTER 10 (type 2)
		tempHealth = rand.nextInt(100) + 450;
		tempStrength = rand.nextInt(15) + 40;
		tempExp = rand.nextInt(10) + 50;
		tempGold = rand.nextInt(20) + 60;
		tempAgil = rand.nextInt(10) + 15;
		Monster minotaur = new Monster("Minotaur", "Minotaur, a monster with a bull head has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(minotaur);	   
	
   	//MONSTER 11 (type 3)
		tempHealth = rand.nextInt(100) + 450;
		tempStrength = rand.nextInt(15) + 40;
		tempExp = rand.nextInt(10) + 50;
		tempGold = rand.nextInt(20) + 60;
		tempAgil = rand.nextInt(10) + 15;
		Monster manticore = new Monster("Manticore", "Manticore, a monster with a human head, a lion's body, and bat wings has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(manticore);	   
	
		//MONSTER 12 (type 3)
		tempHealth = rand.nextInt(100) + 450;
		tempStrength = rand.nextInt(15) + 40;
		tempExp = rand.nextInt(10) + 50;
		tempGold = rand.nextInt(20) + 60;
		tempAgil = rand.nextInt(10) + 15;
		Monster echidna = new Monster("Echidna", "Echidna, a snake woman has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(echidna);	   
	
   	//MONSTER LEVEL 3
   	//MONSTER 13 (type 1)
		tempHealth = rand.nextInt(100) + 600;
		tempStrength = rand.nextInt(15) + 55;
		tempExp = rand.nextInt(15) + 70;
		tempGold = rand.nextInt(20) + 75;
		tempAgil = rand.nextInt(10) + 30;
		Monster archon = new Monster("Archon", "Archon, a powerful, spherical warrior has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(archon);	   
	
   	//MONSTER 14 (type 1)
		tempHealth = rand.nextInt(100) + 600;
		tempStrength = rand.nextInt(15) + 55;
		tempExp = rand.nextInt(15) + 70;
		tempGold = rand.nextInt(20) + 75;
		tempAgil = rand.nextInt(10) + 30;
		Monster cerberus = new Monster("Cerberus", "Cerberus, a three-headed dog has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(cerberus);	   
	
   	//MONSTER 15 (type 2)
		tempHealth = rand.nextInt(100) + 600;
		tempStrength = rand.nextInt(15) + 55;
		tempExp = rand.nextInt(15) + 70;
		tempGold = rand.nextInt(20) + 75;
		tempAgil = rand.nextInt(10) + 30;
		Monster empousai = new Monster("Empousai", "Empousai, an evil goddess, daughter of Hecate has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(empousai);	   
	
   	//MONSTER 16 (type 2)
		tempHealth = rand.nextInt(100) + 600;
		tempStrength = rand.nextInt(15) + 55;
		tempExp = rand.nextInt(15) + 70;
		tempGold = rand.nextInt(20) + 75;
		tempAgil = rand.nextInt(10) + 30;
		Monster gaasyendietha = new Monster("Gaasyendietha", "Gaasyendietha, a dragon spewing fire has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(gaasyendietha);	   
	
   	//MONSTER 17 (type 3)
		tempHealth = rand.nextInt(100) + 600;
		tempStrength = rand.nextInt(15) + 55;
		tempExp = rand.nextInt(15) + 70;
		tempGold = rand.nextInt(20) + 75;
		tempAgil = rand.nextInt(10) + 30;
		Monster karura = new Monster("Karura", "Karura, a divine creature with human torso and birdlike head has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(karura);	   

   	//MONSTERE 18 (type 3)
		tempHealth = rand.nextInt(100) + 600;
		tempStrength = rand.nextInt(15) + 55;
		tempExp = rand.nextInt(15) + 70;
		tempGold = rand.nextInt(20) + 75;
		tempAgil = rand.nextInt(10) + 30;
		Monster centaur = new Monster("Centaur", "Centaur, a wild, half-men, half-horse creature has appeared.", tempHealth, tempStrength, tempExp, tempGold, tempAgil);
      monsterList.add(centaur);	   
	
	   //BOSS
		Monster boss = new Monster("World's End", "The Master of the Undergound Cavern and the final boss of the game. A cybernetic dragon of sorts.", 2000, 200, 300, 300, 90);
      monsterList.add(boss);	   
	
		//Intro
		System.out.println("LOST ABYSS");
      System.out.println("\n-----------------------------");
		System.out.println("You open your eyes and find yourself in a space which seems to have no end in sight. The area is devoid of any objets and has neither a \nfloor nor a ceiling. You look down and notice a that your body seems to have an ethereal attribute to it.");
      System.out.println("Before you can process this you hear a beeping and watch as a what appears to be a dialogue box appears before you, not too dissimilar to \nthat of a game..."); 
      System.out.println("You jolt in sudden realization as memories come rushing back. It looked like a game menu because it WAS a game menu. \nYou were inside the prototype game for a fully immersive Virtual Mass Multiplayer Online Role-Playing Game (VMMORPG), that your company, \nFuture Trails Inc. created.");
      System.out.println("By entering a cryogenics pod, it allows the player to enter the game as a virtual body, with their body structure, and physical attributes \nbeing set into the console before starting, which would constantly moniter the individual's physical condition. In addition mental data \nwas reconstructed allowing the player to retain their own memories, be capable of coherent thought and consciousness within this world.");
      System.out.println("Recognising the game for which you were the head of the development team, you break yourself out of your musing to pay attention to the \nscreen.");
		System.out.println("-----------------------------\n");
		//Character creation 
      System.out.print("What is your character name?: ");
		String name = sc.next(); 
		Character character = new Character(name,"Your character",500,500,25,10,5,0,0,1);
		System.out.println("The screen accepts the input before disappearing to be replaced by another.");
      System.out.println("\nThere are four classes to chose from: Paladin, Berserker, Theif and Ninja. \nEnter 1 to become a Paladin, a tank type class who are masters of endurance. \nEnter 2 to become a Berserker, reckless attackers who boast fighting prowess."); 
      System.out.print("Enter 3 to become a Theif, favoured by fortune these characters are better at finding treasure on the wayside. \nEnter 4 to become a Ninja, masters of stealth who can never settle for second in terms of speed. \nWhat class will you choose?: ");
		//Error checking for job
      while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("A display screen flashs up in front of you. Error. Invalid input. Please try again.");
			System.out.print("What class will you choose? (1,2,3,4): ");
	   }
      int job = sc.nextInt();
		while(job < 1 || job > 4){
         System.out.print("A dsiplay screen flashes up in front of you. Error. No player class exits for the desginated mumber, please choose an appropriate class to be assigned to you: ");
         job = sc.nextInt();
      }
      String jobDesc = ".", appearance = ".";
		//Based on whichever job you choose increase the corresponding stat 
		if(job == 1){
			character.setHealth(character.getHealth()+500);
         character.setMaxHealth(character.getMaxHealth()+500);
         jobDesc = "Paladin";
         character.setDescription("An inexperienced " + jobDesc + " dressed as if a knight from Arthurian legends, ");
         appearance = "Glistening silver plated armour adorns your body, as you are covered from head to toe in an extra layer of clothing. A helmet down to \nthe gauntlets, all the way down to the boots, every peice of the arour offering you extra protection and making you like a knight of yore.";
      }
		if(job == 2){
			character.setStrength(character.getStrength()+50);
			jobDesc = "Berserker";
         character.setDescription("A young " + jobDesc + " with a crazy look in their eye and a bloodthirsty smile, ");
         appearance = "Your body is covered in what appears to be thin feathered coats made of lionskin. Your entire ensemble being made of different animal \nhides, such as crocodile hide boots. They doesn't as offer much in the way of protection, but gives of an aura of intimidation.";
		}
      if(job == 3){
			character.setLuck(character.getLuck()+25);
			jobDesc = "Theif";
         character.setDescription("A greedy " + jobDesc + " who will do anything for the right price, ");
		   appearance = "You looked no different fronm a regular mercenary, with an iron mail shirt and pants, and a leather arm guard attached to your left \nshoulder. The difference perhaps lay in the a pouch you had looped to your pants, containing lock picking tools amongst others.";
      }
		if(job == 4){
			character.setAgility(character.getAgility()+25);
			jobDesc = "Ninja";
		   character.setDescription("A silent " + jobDesc + " who is the master of the night and, blends in with the shadows, ");
         appearance = "Garbed in black cloth from the heath toe, with a face mask allowing only your eyes to show. Small guantlets with built in knife throwers \nadorn your arms, and your boots are of the softest material available so as not to make a sound when you run.";
      }
      //Continue character creation - weapon choice
		System.out.println("\nOnce again the dialogue box dissolves to be replaced by one another just as quickly.");
      System.out.println("The current demo version contains 3 weapon types. The Holy Sword. The Brute Axe. The Emporer's Lance. \nEnter 1 for The Holy Sword, a thin completely white Eastern longsword, known as a tachi, it allows for fluidity of movement.");
      System.out.println("Enter 2 for The Brute Axe, a large black cruved axe, its gives off an oppresive aura which seems to boost the user's vitality. \nEnter 3 for The Emporer's Lance, a silver and golden decorative trident, its design gives makes the user look a bit more like royalty.");
		System.out.print("Which weapon will you choose to equip?: ");
      while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("A display screen flashs up in front of you. Error. Invalid input. Please try again.");
			System.out.print("Which would waepon will you choose to equip? (1, 2, 3): ");
	   }
      int weapon = sc.nextInt();
		while (weapon < 1 || weapon > 3){
         System.out.print("A display screen flashes up in front of you. Error. No weapon type exits for the desginated mumber, please choose an appropriate weapon to equip: ");
         weapon = sc.nextInt();
      }
      String wepName = "";
		//Based on whichever weapon you choose increase the corresponding stat 
		if(weapon == 1){
			character.setStrength(character.getStrength()+50);
			character.setAgility(character.getAgility()+25);
			wepName = "Holy Sword";
		}
		if(weapon == 2){
			character.setStrength(character.getStrength()+50);
			character.setHealth(character.getHealth()+300);
         character.setMaxHealth(character.getMaxHealth()+300);
			wepName = "Brute Axe";
		}
		if(weapon == 3){
			character.setStrength(character.getStrength()+50);
			character.setLuck(character.getLuck()+25);
			wepName = "Emporer's Lance";
		}
      character.setDescription(character.getDescription() + "equipped with The " + wepName);
		
      System.out.println("Once that screen reads the input and disappears, one last screen appears, being your status screen.");
      System.out.println(character);
      
      
      System.out.println("\n-----------------------------");
		System.out.println("FULL ASSIMILATION START");
      System.out.print("The last screen disappears, and the surroundings fade to a black, where slowly chaning colour once again to result in what looks like an \nundergroun cavern. You look around, and then down as you notice the glow coming from your body.");
      System.out.println("You watch in fascination as your body \nslowly becomes more corporeal, eventually looking like what you would see in a mirror, before, with a flash of light your apparel changes.");
      System.out.println(appearance);
      System.out.println("Amazed and satisfied with the appearance of your avatar and surroundings in this virtual world you decide to proceed with the testing \nand you begin your joruney. Resolved to reach depths of this 10 floor cavern and defeat the boss awaiting you, to end this demo in a \nsuccess. All the while you have an uncomfortable feeling, as something feels very wrong, although you cannot identify what.");
      System.out.println("As if to cement that feeling, word's flash in front of your face. A game title. But not the title that was supposed to be used. \nWELCOME TO LOST ABYSS");
      System.out.println("-----------------------------");
		
      
      
      
      
      //an Arraylist of floors that the user will be currFlooring through
		ArrayList<Floor> floors = new ArrayList<Floor>();
		
		//starts currFloor at floor 1 
		int currFloor = 1;
		String type =".";
		
      //while character is not on the final floor currFloor forward
		while (currFloor <= 10) {
		   Floor f1 = new Floor(currFloor, type);
		   // floors 1,2,4,5,7, and 8 are Monster floors	
		   if (currFloor == 1 || currFloor == 2 || currFloor == 4 || currFloor == 5 || currFloor == 7 || currFloor == 8 )	{
            f1.fillRooms();
	         type = "Monster Floor";
            System.out.print("\nA display flashes in front of you. You arrive at Floor " + currFloor + " this is a " + type + ". You are at the entrance.");
            f1.enterRoom(character, currFloor, wepName, monsterList);
         }
      	else if (currFloor == 3 || currFloor == 6 || currFloor == 9 ){
   			type = "Safe Floor";
   		   System.out.println("You are on Floor " + currFloor + " this is a " + type);
   		   //Dialogue output
            if(currFloor == 3){
               System.out.println("\n-----------------------------");
		         System.out.println("You finally make it to a safe floor and your body which was previously running on adrenaline sudden feels more like lead. As you have \ntime to process the events that led you here, you come to a sudden, horrible realisation that you had subconsiously been ignoring.");
               System.out.print("Those battles.. Those monsters... They died easily enough, and disappeared, but that was the issue! They shouldn't have been killable at \nall. Your team had worked in a features to cause battles to end when a combatents health dropped down to 50%, so why exactly did it \nreach 0.");
               System.out.println("You remember the reason for that change. Since the virtual world used constructed your avatar by scanning your neural pathways, \nto recreate your mental data, throught the wires connecting to your real body in the pod. While it allowed electrical impulses to flow \nthough, it meant your very nerves were connected to the mental data in a sense.");
               System.out.println("If a player was to die in the virtual world, it would delete their avatar, including the stored mental data. And if that happened there \nwas a good chance that by passing on an electrical message to your brain, through the pod, it would tell your brain it had died.");
               System.out.println("This could result in rendering the player brain dead, and then causing their nerves to shut down one by one, resulting in their death in \nthe real world too. While it wasn't guaranteed, it was dangerous enough to warrant changing the code.");
               System.out.println("You wonder why exactly this feature was in the game then. You try to access the logout button that should appear on the menu open reaching \na safe floor, but it wasn't there. Before you can delve into a panic you decide to steel yourself and move onwards.");
               System.out.println("-----------------------------\n");
		      }
            else if(currFloor == 6){
               System.out.println("\n-----------------------------");
		         System.out.println("You reached another safe floor. Noting another shop type arrangement, lacking in variety though it was, you were sure it would prove \nuseful. If at least some of the code was the same, the enemies were only likely to get stronger, noy to mention the boss...");
               System.out.println("Thinking about that you realise that had just under haflway to go before you reached the end. It's strange, while you had been here \nfor what certainly felt like hours, you'd be surprised if it had been more than minutes in the real world. Was the rest of your team");
               System.out.println("watching your progress from the outside. Were the confused? Shocked? Worried? Trying to fix the issue? Trying to get you out? You were \nsomewhat surprised they hadn't simply tried to remove you from the pod, but then again, it was possibly that they couldn't, or worse");
               System.out.println("that they wouldn't. That they were all in on it to get rid of you. Someone had to have changed the files on you after all. Speculation \nwouldn't help though, not without information. You lay on the floor of the room, eagle spread, your eye lids frowing heavy.");
               System.out.println("The last thing you remember thinking before you fell asleep was the memory of one of your teammates, Kayaba, which you luck before you \nentered the pod. To do your best not to die... Before you could pursue this line of thought you gave into the lull of the darkness.");
               System.out.println("You awoke feeling somewhat more refreshed later. Unaware of how much time had passed, and unable to tell what time it was. You gathered \nyourself, glancing at the shop before making preparations to move onwards to the next floor.");
               System.out.println("-----------------------------\n");
		      }
            else if(currFloor == 9){
               System.out.println("\n-----------------------------");
		         System.out.println("The final floor. The game seemed to follow the same structure as planned, and thus the next floor should be the last safe floor, \nThe only thing standing between you, and freedom and reality.");
               System.out.println("It was also however the biggest hurdle, and the most likely thing to send him to his potential death out of all the dangers in this \nvirtual reality.");
               System.out.println("You scan the floor, this was it. Your preparations for the final battle should begin. There was no way to beat this boss unless you and \nyour gear were in the best condition possible, not like this gold would come in use in the real life."); 
               System.out.println("It was time for your journey to end! For you to get answers! For you to return! Resolutely, you advanced.");
               System.out.println("-----------------------------\n");
		      }
            f1.safeFloor(character, wepName);
         }		
		   else if (currFloor == 10){
	   		type = "Final Floor";
            System.out.println("You are on the Floor " + currFloor + ", the Final Floor. Through a long and arderous journey, you have reached the " + type);
            launch(args);
   		   f1.bossFloor(character, monsterList);
         }
         currFloor++;
         if(currFloor < 10){
            System.out.println("\nYour status screen flashes in front of you" + character);
		   }
      }
      System.out.println("Fin");
	}
}
