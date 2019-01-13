import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;

public class Floor {
	Random random = new Random();
   Scanner kb = new Scanner(System.in);
	//instance variables
	private int numFloor;
	private String typeFloor;
	private ArrayList<Room> room;
	private Monster m;
   //constructor
	public Floor(int n, String t) {
		setNumFloor(n);
		setTypeFloor(t);
		room = new ArrayList<Room>();
	}
	//get and set methods
	public int getNumFloor() {
		return numFloor;
	}
	public void setNumFloor(int numFloor) {
		this.numFloor = numFloor;
	}
	public String getTypeFloor() {
		return typeFloor;
	}
	public void setTypeFloor(String typeFloor) {
		this.typeFloor = typeFloor;
	}
	public ArrayList<Room> getRoom() {
		return room;
	}
	public void setRoom(ArrayList<Room> room) {
		this.room = room;
	}
	//Fill rooms method
	public void fillRooms() {
		//sets one room as stairs
		Room room1 = new Room();
		room1.setContents(3);
		room.add(room1);
		//randomizes the contents of the rooms on a floor
		for(int i=1;i<6;i++) {
			Room tempRoom = new Room();
			int randNum = random.nextInt(3);
			tempRoom.setContents(randNum);
			room.add(tempRoom);
		}
		//shuffle the order of the rooms so it is unknown where the stairs are
		Collections.shuffle(room);
		//creates a "lobby" in the floor so the list of rooms goes from 1-6 in the index
		Room lobby = new Room();
		room.add(0, lobby);
	}
	//battle method
	public void battle(Character c, Monster m) {
      System.out.print("What would you like to do? (Type 1 to Fight, 2 to Run): ");
      while (!kb.hasNextInt()) {
			kb.next();
			System.out.println("A display screen flashes up in front of you. Error. Invalid input. Please try again.");
			System.out.print("What would you like to do? (Type 1 to Fight, 2 to Run): ");
	   }
      int battleChoice = kb.nextInt();
      while(battleChoice < 1 || battleChoice > 2){
         System.out.println("A display screen flashes up in front of you. Error. Invalid input. Please try again.");
         battleChoice = kb.nextInt();
      }
      while (battleChoice == 1 || battleChoice == 2){
         if(battleChoice == 1){
            //Health available
   		   while(c.getHealth() > 0 && m.getHealth() > 0){
               //Character attacks monster
               c.damage(m);
               //If still alive monster will retaliate
               if(m.getHealth() > 0){
                  m.attackPlayer(c);
               }
               //Otherwise the player has won the battle and gain
               else{
                  System.out.print(m.getName() + " has been defeated. ");
                  c.gainXP(m);
                  c.addMGold(m);
                  System.out.println(" You exit the room and return to the entrance.");
                  battleChoice = 0;
                  System.out.println("\nYour status screen flashes in front of you" + c);
               }
            }
            if(c.getHealth() <= 0){
               //Monster death ending dialogue
               int temp = m.getHealth();
               System.out.println(m.getName() + "'s Health: " + m.getHealth() + "/" + temp);
               System.out.println(c.getName() + "'s Health: 0/" + c.getMaxHealth());
               System.out.println("\n-----------------------------");
		         System.out.println("They say that when you're about to die, your life flashes before your very eyes.");
               System.out.println("But that's not always true. Not if you die before you can even process it. Like you did.");
               System.out.println("You feel cold. Even in a virtual body it felt chillingly cold.");
               System.out.println("You look down to see a gaping hole where your heart used to be."); 
               System.out.println("A display box flashing before your eyes, with the words: YOU HAVE DIED. GAME OVER.");
               System.out.println("The shock, and reactionary instinct kill before you can even utter a sound. ");
		         System.out.println("Before you can notice you were shedding pixels not blood. Before your body breaks down and disperse completely.");
               System.out.println("Omega. The ultimate end. You were Lost to the Abyss..."); 
               System.out.println("-----------------------------\n");
		         System.out.println("This is (not) the end");
               System.exit(0);
            }
         }
         else{      
            if(c.getAgility() >= m.getAgility()){
               System.out.println("\nYou successfully ran away! \nYou continue your adventure!");
               battleChoice = 0;
            }
            else{
               System.out.println("\nThe monster is much faster than you! \nYou are unable to run away, and must stand your ground and fight!");      
               battleChoice = 1;
            }
         }
      }
	}
	//Enter room method
	public void enterRoom(Character c, int progress, String weaponType, ArrayList<Monster> monsterList) {
		int roomChoice = 100;
		//while loop to continue giving the player the option of entering a room
		while(roomChoice!=0) {
			System.out.print("\nThere are 6 rooms. Which one would you like to enter? (Enter a value from 1 - 6): ");
			while (!kb.hasNextInt()) {
				kb.next();
				System.out.println("A display screen flashes up in front of you. Error. Invalid input. Please try again.");
				System.out.print("\nThere are 6 rooms. Which one would you like to enter? (Enter a value from 1 - 6): ");
			}
			roomChoice = kb.nextInt();
			while(roomChoice < 1 || roomChoice > 6){
            System.out.println("A display screen flashes up in front of you. Error. Invalid input. Please try again.");
            roomChoice = kb.nextInt();
			}
         //check if the input is valid
			if(roomChoice>0 && roomChoice<=6) {
				Room roomEntering = room.get(roomChoice);
				System.out.println("You have entered a "+ roomEntering.getContents() +" room.");
				//options available if the room is stairs
				if (roomEntering.getContents().equals("Stairs")) {
					kb.nextLine();
					System.out.print("This room contains stairs. Do you want to go down the stairs? (Y/N): ");
					String goDownStairs = kb.nextLine();
					int stairsInput = 0;
					//check if the input is valid
					while(stairsInput == 0) {
						if (goDownStairs.equals("Y")) {
							roomChoice = 0;
							stairsInput++;
						}else if(goDownStairs.equals("N")) {
							System.out.println("You exit the room and return to the entrance.");
							stairsInput++;
						}else {
							System.out.println("A display screen flashes up in front of you. Error. Invalid input. Please try again.");
							System.out.print("This room contains stairs. Do you want to go down the stairs? (Y/N): ");
							goDownStairs = kb.nextLine();
						}
					}
				}else if (roomEntering.getContents().equals("Monster")) {
				//spawn monster (difficulty depends on the floor they are on) and start battles with battle method
					if(progress<3) {
						int randMonster = random.nextInt(6);
						Monster monsterSpawned = new Monster(monsterList.get(randMonster).getName(), monsterList.get(randMonster).getDesc(), monsterList.get(randMonster).getHealth(), monsterList.get(randMonster).getStrength(), monsterList.get(randMonster).getExp(), monsterList.get(randMonster).getGold(), monsterList.get(randMonster).getAgility());
						System.out.println("\nYou encounter a " + monsterSpawned.getName() + ". A display falshes in front of you.\n" + monsterSpawned);
						System.out.println("You currently have " + c.getHealth() + "/" + c.getMaxHealth() + " Health.");
						battle(c, monsterSpawned);
					   System.out.println("You exit the room and return to the entrance.");
               }else if(progress>3 && progress<6) {
						int randMonster = random.nextInt(6)+6;
						Monster monsterSpawned = new Monster(monsterList.get(randMonster).getName(), monsterList.get(randMonster).getDesc(), monsterList.get(randMonster).getHealth(), monsterList.get(randMonster).getStrength(), monsterList.get(randMonster).getExp(), monsterList.get(randMonster).getGold(), monsterList.get(randMonster).getAgility());
						System.out.println("You encounter a " + monsterSpawned.getName() + ". A display falshes in front of you.\n" + monsterSpawned);
						System.out.println("You currently have " + c.getHealth() + "/" + c.getMaxHealth() + " Health.");
						battle(c, monsterSpawned);
					   System.out.println("You exit the room and return to the entrance.");
               }else if(progress>6 && progress<9){
						int randMonster = random.nextInt(6)+12;
						Monster monsterSpawned = new Monster(monsterList.get(randMonster).getName(), monsterList.get(randMonster).getDesc(), monsterList.get(randMonster).getHealth(), monsterList.get(randMonster).getStrength(), monsterList.get(randMonster).getExp(), monsterList.get(randMonster).getGold(), monsterList.get(randMonster).getAgility());
						System.out.println("You encounter a " + monsterSpawned.getName() + ". A display falshes in front of you.\n" + monsterSpawned);
						System.out.println("You currently have " + c.getHealth() + "/" + c.getMaxHealth() + " Health.");
						battle(c, monsterSpawned);
					   System.out.println("You exit the room and return to the entrance.");
               }
					//different possibilities of a treasure room, can't get treasure more than once per treasure room (treasureAv)
				}else if (roomEntering.getContents().equals("Treasure")) {
					int treasureItem = random.nextInt(3);
					//gives the player gold (amount depends on floor and luck attribute level)
					if (treasureItem==0 && room.get(roomChoice).getTreasureAv()) {
						int treasureAmount = c.getLuck()*progress*5;
						System.out.println("This room contains "+treasureAmount+" gold. You pick it up.");
						c.setGold(c.getGold()+treasureAmount);
						System.out.println("You exit the room and return to the entrance.");
                  room.get(roomChoice).setTreasureAv(false);
						//gives the player a potion (size of potion depends on floor progress)
					}else if(treasureItem==1 && room.get(roomChoice).getTreasureAv()) {
						if(progress<=3) {
							//health can't exceed max health
							if(c.getHealth()+100>c.getMaxHealth()) {
								c.setHealth(c.getMaxHealth());
							}else {
								c.setHealth(c.getHealth()+100);
							}
							System.out.println("You find a small potion. You gain 100 heath points. Your health is now "+c.getHealth());
							System.out.println("You exit the room and return to the entrance.");
                     room.get(roomChoice).setTreasureAv(false);
						}else if(progress>3 && progress<6) {
							if(c.getHealth()+200>c.getMaxHealth()) {
								c.setHealth(c.getMaxHealth());
							}else {
								c.setHealth(c.getHealth()+200);
							}
							System.out.println("You find a medium potion. You gain 200 heath points. Your health is now "+c.getHealth());
							System.out.println("You exit the room and return to the entrance.");
                     room.get(roomChoice).setTreasureAv(false);
						}else {
							if(c.getHealth()+300>c.getMaxHealth()) {
								c.setHealth(c.getMaxHealth());
							}else {
								c.setHealth(c.getHealth()+300);
							}
							System.out.println("You find a Large potion. You gain 300 heath points. Your health is now "+c.getHealth());
							System.out.println("You exit the room and return to the entrance.");
                     room.get(roomChoice).setTreasureAv(false);
						}
					//upgrades the players weapon, both strength and the associated attribute for the players weapon (amount depends on floor progress)
					}else if(treasureItem==2 && room.get(roomChoice).getTreasureAv()){					
						if(progress<=3) {
                     //Repetitive code, slight change though due to different weapns affecting different parameters
							if (weaponType.equals("Holy Sword")) {
								c.setStrength(c.getStrength()+10);
								c.setAgility(c.getAgility()+10);
								System.out.println("You find an upgrade station. Your strength increases by 10 and your agility increases by 10.");
							   System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);
						}else if(weaponType.equals("Brute Axe")) {
								c.setStrength(c.getStrength()+10);
								c.setMaxHealth(c.getMaxHealth()+100);
								c.setHealth(c.getHealth()+100);
								System.out.println("You find an upgrade station. Your strength increases by 10 and your current and max health increases by 100.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}else if(weaponType.equals("Emporer's Lance")) {
								c.setStrength(c.getStrength()+10);
								c.setLuck(c.getLuck()+10);
								System.out.println("You find an upgrade station. Your strength increases by 10 and your luck increases by 10.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}
						}else if(progress>3 && progress<6) {
							//Same as above however now the effect changes due to how far the player has advanced
                     if (weaponType.equals("Holy Sword")) {
								c.setStrength(c.getStrength()+20);
								c.setAgility(c.getAgility()+20);
								System.out.println("You find an upgrade station. Your strength increases by 20 and your agility increases by 20.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}else if(weaponType.equals("Brute Axe")) {
								c.setStrength(c.getStrength()+20);
								c.setMaxHealth(c.getMaxHealth()+200);
								c.setHealth(c.getHealth()+200);
								System.out.println("You find an upgrade station. Your strength increases by 20 and your current and max health increases by 200.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}else if(weaponType.equals("Emporer's Lance")) {
								c.setStrength(c.getStrength()+20);
								c.setLuck(c.getLuck()+20);
								System.out.println("You find an upgrade station. Your strength increases by 20 and your luck increases by 20.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}
						}else {
                     //Same as the above
							if (weaponType.equals("Holy Sword")) {
								c.setStrength(c.getStrength()+30);
								c.setAgility(c.getAgility()+30);
								System.out.println("You find an upgrade station. Your strength increases by 30 and your agility increases by 30.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}else if(weaponType.equals("Brute Axe")) {
								c.setStrength(c.getStrength()+30);
								c.setMaxHealth(c.getMaxHealth()+300);
								c.setHealth(c.getHealth()+300);
								System.out.println("You find an upgrade station. Your strength increases by 30 and your current and max health increases by 300.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}else if(weaponType.equals("Emporer's Lance")) {
								c.setStrength(c.getStrength()+30);
								c.setLuck(c.getLuck()+30);
								System.out.println("You find an upgrade station. Your strength increases by 30 and your luck increases by 30.");
								System.out.println("You exit the room and return to the entrance.");
                        room.get(roomChoice).setTreasureAv(false);;
							}
						}
					}else {
						System.out.println("You have already taken the treasure.");
					}
				//empty room, nothing happens
				}else {
					System.out.println("This room is empty. You exit and return to the entrance.");
				}
			}else {
				System.out.println("Invalid input.");
				System.out.print("There are 6 rooms. Which one would you like to enter? (Enter a value from 1 - 6): ");
				while (!kb.hasNextInt()) {
				   kb.next();
				   System.out.println("A display screen flashes up in front of you. Error. Invalid input. Please try again.");
				   System.out.print("\nThere are 6 rooms. Which one would you like to enter? (Enter a value from 1 - 6): ");
			   
            }
			   roomChoice = kb.nextInt();
			}
		}
	}
	//creates a shop on the safe floor
	public void safeFloor(Character c, String weaponType) {
		//put options in ArrayList to easily print throughout the method
		ArrayList<String> safeFloorShop = new ArrayList<String>();
		safeFloorShop.add("1. Small potion: heals 100 health points (50 gold).");
		safeFloorShop.add("2. Medium potion: heals 200 health points (100 gold).");
		safeFloorShop.add("3. Large potion: heals 300 health points (150 gold).");
		safeFloorShop.add("4. Full heal: heals to max health points (200 gold).");
		safeFloorShop.add("5. Weapon upgrade: Increases your strength and the associated attribute of your weapon by 10 (200 gold).");
		String shop = Arrays.toString(safeFloorShop.toArray()).replace("[", "").replace("]", "").replaceAll(", ", "\n");
		System.out.println("You have entered a safe floor. There is a selection of actions available.");
		System.out.println(shop);
		System.out.print("Choose an option or enter 6 to go to the next floor: ");
		int shopChoice = kb.nextInt();
		//while loop to allow the player to buy more than one weapon
		while(shopChoice != 6) {
			if (shopChoice == 1 && c.getGold() >= 50) {
				if(c.getHealth()+100>c.getMaxHealth()) {
					c.setHealth(c.getMaxHealth());
				}else {
					c.setHealth(c.getHealth()+100);
				}
				c.setGold(c.getGold()-50);
				System.out.println("Your health has been increased by 100 health points. You now have "+c.getGold()+" gold.\n");
				System.out.print("Choose an option or enter 6 to go to the next floor: ");
				shopChoice = kb.nextInt();
			}else if(shopChoice == 2 && c.getGold() >= 100) {
				if(c.getHealth()+200>c.getMaxHealth()) {
					c.setHealth(c.getMaxHealth());
				}else {
					c.setHealth(c.getHealth()+200);
				}
				c.setGold(c.getGold()-100);
				System.out.println("Your health has been increased by 200 health points. You now have "+c.getGold()+" gold.\n");
				System.out.print("Choose an option or enter 6 to go to the next floor: ");
				shopChoice = kb.nextInt();
			}else if(shopChoice == 3 && c.getGold() >= 150) {
				if(c.getHealth()+300>c.getMaxHealth()) {
					c.setHealth(c.getMaxHealth());
				}else {
					c.setHealth(c.getHealth()+300);
				}
				c.setGold(c.getGold()-150);
				System.out.println("Your health has been increased by 300 health points. You now have "+c.getGold()+" gold.\n");
				System.out.print("Choose an option or enter 6 to go to the next floor: ");
				shopChoice = kb.nextInt();
			}else if(shopChoice == 4 && c.getGold() >= 200) {
				c.setHealth(c.getMaxHealth());
				c.setGold(c.getGold()-200);
				System.out.println("Your health has been restored. You now have "+c.getGold()+" gold.\n");
				System.out.print("Choose an option or enter 6 to go to the next floor: ");
				shopChoice = kb.nextInt();
			}else if(shopChoice == 5 && c.getGold() >= 200) {
				c.setGold(c.getGold()-200);
				if (weaponType.equals("Holy Sword")) {
					c.setStrength(c.getStrength()+10);
					c.setAgility(c.getAgility()+10);
					System.out.println("Your strength and your agility have been increased by 10. You now have "+c.getGold()+" gold.\n");
					System.out.print("Choose an option or enter 6 to go to the next floor: ");
					shopChoice = kb.nextInt();
				}else if(weaponType.equals("Brute Axe")) {
					c.setStrength(c.getStrength()+10);
					c.setMaxHealth(c.getMaxHealth()+100);
					c.setHealth(c.getHealth()+100);
					System.out.println("Your strength has been increased by 10 and your current and max health have been increased by 100. You now have "+c.getGold()+" gold.\n");
					System.out.print("Choose an option or enter 6 to go to the next floor: ");
					shopChoice = kb.nextInt();
				}else if(weaponType.equals("Emporer's Lance")) {
					c.setStrength(c.getStrength()+10);
					c.setLuck(c.getLuck()+10);
					System.out.println("Your strength and your luck have been increased by 10. You now have "+c.getGold()+" gold.\n");
					System.out.print("Choose an option or enter 6 to go to the next floor: ");
					shopChoice = kb.nextInt();
				}
			}else if(shopChoice<0 || shopChoice>6){
				System.out.println("A display screen flashes up in front of you. Error. Invalid input. Please try again.");
				System.out.println(shop);
				System.out.print("\nChoose an option or enter 6 to go to the next floor: ");
				shopChoice = kb.nextInt();
			//prompt if player does not have enough gold for the item chosen
			}else {
				System.out.println("A display screen flashes up in front of you. Error. You do not have enough gold for this item.\n");
				System.out.println(shop);
				shopChoice = kb.nextInt();
			}
		}
		System.out.println("You have left this safe floor and moved on to the next floor.");
	}
	//boss floor method, spawns boss and calls the battle method
	public void bossFloor(Character c, ArrayList<Monster> monsterList) {
		Monster boss = monsterList.get(18);
		//Boss encounter dialogue
      System.out.println("You have made it to the boss floor where " + boss.getName() + " is awaiting you. A display flashes in front of you.\n" + boss);
		System.out.println("Your display flashes in front of you." + c);
		System.out.println("\n-----------------------------");
		System.out.println("You see the name on the display and it all makes sense. It was Kayaba who tried to kill you after all. Both the boss' name and design\nwere his idea afterall. Both which you had rejected. Although it was surprising knowing how softhearted he was.");
      System.out.println("You glance over at the beast in front of you. Similar in base to the dragons of myths, yet completely cybernetic in design.");
      System.out.println("It may have just been a supersized toy robot... Decked out with heavy artillery that is.");
      System.out.println("Razor sharp saw like wings. A long tail with a drill tip at the end. Daggerlike ears. Sharpened fangs and claws.");
      System.out.println("You steel yourself one last time. This was it. Win or lose, your last battle in this world."); 
      System.out.println("You raised your weapon over your head, and with a warcry dashed to face your foe.");
		System.out.println("-----------------------------\n");
		while (c.getHealth() > 0 && boss.getHealth() > 0) {
			c.damage(boss);
			if (boss.getHealth() > 0) {
				boss.attackPlayer(c);
			}else {
            //Boos win ending dialogue
            System.out.println("You stand there, putting your full weight on the weapon which has been driven into the ground. The only thing keeping you standing.");
            System.out.println("You watch the cybernatic dragon lay unmoving on the floor, his drill tail severed. As pixels slowly flow off of his body, dispersing.");
				System.out.print("A display box flashes in front of your eyes, reading: \nCONGRATULATIONS " + c.getName() + "!");
				System.out.println("You have defeated the World's End!! \nYour status screen flashes in front of you, a report on your journey:" + c);
				System.out.println("The game has been completed. Operations will terminate. Forced Log Out Activated.");
				System.out.println("\n-----------------------------");
		      System.out.println("Before you could savor your victory, or even panic, you were englufed in darkness, and just as quickly had a bright light flashed in front");
            System.out.println("of you. Unable to stand. Unable to hear. Unable to feel. \nAs your senses grow numb and thoughts become hazy, you realize you are starting to drift.");
            System.out.println("You squint, blinking before carefully opening your eyes to see curved glass above you. Curved glass which was automatically retracting.");
            System.out.println("The cryogenics pod your tired mind slowly recognises. A clamor of hands rush to pull you out of the pod, and babble of voices deafen you."); 
            System.out.println("A few weeks had passed. The culprit who changed the code had been discovered, or more accurately, you recognised. It had been an attempted \nmurder after all.");
		      System.out.println("Surprisingly the real mastermind was Adam. Someone who had been your friend university. Apparently he had been jealous that you had been \nchosen over him for the promotion, and subsequent headship of the project. That and some crazy vision he had chased, wanting to create a \nvirtual Eden.");
            System.out.println("It seems jealousy and delusions cause people to do things you never thought they were capable. Kayaba was also taken in, although not the \nculprit like you had suspected, and even if he was manipulated into it, he was still and accessory. He WOULD likely get off easier at least."); 
            System.out.println("While you haen't fully recovered. Who gets over mental trauma from repeated death battles, and existential crises that quickly? \nYou are on the road to recovery with the help of your therapist. And just maybe at some point in the future you would be fine. \nBecause you had one. A future. You struggled. You scrapped. You survived. \nAnd you would continue to do so for the rest of your life, virtual or physical. You were grateful to still have one."); 
            System.out.println("-----------------------------\n");
			}
		}
		if(c.getHealth() <= 0) {
         //Boos death ending dialogue
         int temp = boss.getHealth();
         System.out.println("World's End's Health: " + boss.getHealth() + "/" + temp);
         System.out.println(c.getName() + "'s Health: 0/" + c.getMaxHealth());
         System.out.println("\n-----------------------------");
		   System.out.println("You fall to one knee as you take a fatal blow. You are unable to summon the strength to keep on fighting.");
         System.out.println("Unable to stand. Unable to hear. Unable to feel. \nAs your senses grow numb and thoughts become hazy, you realize you are starting to drift.");
         System.out.println("You did everything you could, didn't you? Yet it wasn't enough. You came so close. Victory. Escape. Freedom. \nAll in the palms of your hands, yet you failed. Right at the end, right where it mattered most. You were defeated.");
         System.out.println("Were your colleagues watching this? Were they trying to save you? Would they miss him? Would anyone? Your friends? \nYour Family? Would they ever know what happened? Would anyone known the truth? So many regrets, so very many. This was the end."); 
         System.out.println("There was no more. Could a virtual being even go to heaven or hell? Or would they be lost in the void? Sent to a recycle bin?");
		   System.out.println("As your eyes close the last thing you saw was World's End's drill tiped tail, spinning furiously and rapidly approaching you. \nAnd then no more. No more pain. No more suffering. No more joy. No more anger. Simply nothing.");
         System.out.println("As easily, and as routinely, as the night falls everday. As if no different to that, you were Lost to the Abyss."); 
         System.out.println("-----------------------------\n");
         System.out.println("This is (not) the end");
		   System.exit(0);
      }
	}
}

