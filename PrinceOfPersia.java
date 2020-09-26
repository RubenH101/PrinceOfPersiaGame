import java.util.Scanner;
import java.io.*;

public class PrinceOfPersia {

	Scanner input = new Scanner(System.in);
	int playerHP;
	String playerName;
	String playerWeapon;
	int choice;
	int monsterHP;
	int guardHP;
	String location;

	int silverRing;
	static String filePath;

	public static void main(String[] args) {



		System.out.println();
        Scanner input = new Scanner(System.in);

		if(args.length == 0){
            System.out.println("Play Mode");

			try
			{
					//filePath = "/ASIKEN SYSTEMS/CSULA/CS2011/project/file_example_WAV_1MG.wav";
					SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer();

					audioPlayer.play();

			}

			catch (Exception ex)
			{
					System.out.println("Error with playing sound.");
					ex.printStackTrace();

				}

			//JavaAudioPlaySoundExample ply = new JavaAudioPlaySoundExample();
			//String[] args1 = {};
			//ply.main(args1);
        PrinceOfPersia dungeon;
        dungeon = new PrinceOfPersia();

        dungeon.playerSetUp();
        dungeon.location = "townGate";
        while (true) {
            dungeon.run(dungeon.location, input);
            if (dungeon.playerHP < 0) {
                dungeon.dead();
            }
        }
				//playerSetUp();
			//townGate();
    }
    else{
        if(args[0].equals("-help"))
				System.out.println("\n------------------------------------------------------------------\n");
				System.out.println("            H  E  L  P      M  E  N  U");
				System.out.println("\n------------------------------------------------------------------\n");
			System.out.println();
			System.out.println("Goal of the game is to get past the guard & into the town.");
			System.out.println("This can be achieved either by a fight or ,");
			System.out.println("by gaining the confidence of the guard.");
			System.out.println();
			System.out.println("You can also seek other weapons!!!");
			System.out.println("You start off with a HP(Health points) of 10.");
			System.out.println("You have oppurtunities to gain these HP by visiting other locations.");
			System.out.println("Watch out, though, negative HP will have you DEAD !!!");
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("      B E S T      O F F      L U C K     !!!!");
			System.out.println("\n------------------------------------------------------------------\n");

        System.exit(0);
    }

	}

	public void playerSetUp(){


		playerHP = 10;
		monsterHP = 15;
		guardHP = 20;

		playerWeapon = "Knife";

		System.out.println("Your HP: "+ playerHP);
		System.out.println("Your Weapon: "+ playerWeapon);

		System.out.println("Please enter your name:");

		playerName = input.nextLine();

		System.out.println("Hello " + playerName + ", let's start the game!");


	}

	public void run(String currentLocation, Scanner input) {

		switch (currentLocation) {

			case "townGate":
				System.out.println("\n------------------------------------------------------------------\n");
				System.out.println("You are at the gate of the town.");
				System.out.println("A guard is standing in front of you.");
				System.out.println();
				System.out.println("What do you want to do?");
				System.out.println();
				System.out.println("1: Talk to the guard");
				System.out.println("2: Attack the guard");
				System.out.println("3: Leave");
				System.out.println("\n------------------------------------------------------------------\n");

				choice = input.nextInt();

				if(choice==1){
					if(silverRing==1){
						location = "ending";
					} else{
						System.out.println("Guard: Hello there, stranger. So your name is " + playerName + "? \nSorry but we cannot let stranger enter our town.");
						input.nextLine();
						System.out.println("Hit enter key.");
						input.nextLine();

					}
				} else if(choice==2){
					if (playerWeapon == "Long Sword"){
						guardFight();
					}
					else {
						playerHP = playerHP-1;
						System.out.println("Guard: Hey don't be stupid.\n\nThe guard hit you so hard and you gave up.\n(You receive 1 damage)\n");
						System.out.println("Your HP: " + playerHP);
						input.nextLine();
						System.out.println("Hit enter key.");
						input.nextLine();

					}
				} else if(choice==3){
					location = "crossRoad";
				}
				break;

			case "crossRoad":

				System.out.println("\n------------------------------------------------------------------\n");
				System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n\n");
				System.out.println("1: Go north");
				System.out.println("2: Go east");
				System.out.println("3: Go south");
				System.out.println("4: Go west");
				System.out.println("\n------------------------------------------------------------------\n");

				choice = input.nextInt();

				if(choice==1){
					location = "north";
				}
				else if(choice==2){
					location = "east";
				}
				else if(choice==3){
					location = "townGate";
				}
				else if(choice==4){
					location = "west";
				}
				break;

            case "north":
                String[][] levelNorth = { { "Level 1", "calm river", "can drink water"}, { "Level 2", "raging river", " have to Swim"}, { "Level 3", "voilent river", "need to stay alive" } };
                int level = 0;
                int swim = -10;
								int hpNorth = playerHP;
                for (int i = level; i < levelNorth.length; ++i) {

                    System.out.println("\n------------------------------------------------------------------\n");
                    System.out.println(levelNorth[i][0] + " is a " + levelNorth[i][1] + " You " + levelNorth[i][2]);
                    System.out.println("Hit enter key.");

                    input.nextLine();
                    if(i != 0){
                        swim+= (int)(Math.random() * 10);
                        playerHP = playerHP + swim;
                        System.out.println("Hope your destiny will save you.");
                    } else {
												input.nextLine();
												playerHP = playerHP + 1;
                        System.out.println("Your HP is recovered.");
                    }

                    System.out.println("Your HP: " + playerHP);
                    if (playerHP<1){ return; }

									}
								System.out.println("You made it out alive.");
								System.out.println("Your old HP: " + hpNorth);
								//System.out.println("Your new HP: " + playerHP);
								if(playerHP > hpNorth){
									System.out.println("And you gained HP!!!. Way to go!.");
								}
								else if(playerHP == hpNorth)
									System.out.println("You got out unscathed!!!. Come back again!!!!.");
								else
									System.out.println("But you lost HP!!!. Come back again or better yet dont!!!!.");


                System.out.println("\n\n1: Go back to the crossroad");
                System.out.println("\n------------------------------------------------------------------\n");
                choice = input.nextInt();

                if(choice==1){

                    location = "crossRoad";

                }
                break;

            case "east":
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You walked into a forest and found a Long Sword!");
                playerWeapon = "Long Sword";
                System.out.println("Your Weapon: "+ playerWeapon);
                System.out.println("\n\n1: Go back to the crossroad");
                System.out.println("\n------------------------------------------------------------------\n");

                choice = input.nextInt();

                if(choice==1){
                    location = "crossRoad";
                }
                break;

            case "west":
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You encounter a goblin!\n");
                System.out.println("1: Fight");
                System.out.println("2: Run");
                System.out.println("\n------------------------------------------------------------------\n");

                choice = input.nextInt();

                if(choice==1){
                    fight();
                }
                else if(choice==2){
                    location = "crossRoad";
                }
                break;

            case "ending":
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Guard: Oh you killed that goblin!?? Great!");
                System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
                System.out.println("\n\n           THE END                    ");
                System.out.println("\n------------------------------------------------------------------\n");
                System.exit(0);
                break;

						case "ending2":
								System.out.println("\n------------------------------------------------------------------\n");
								System.out.println("You have defeated the guard.");
								System.out.println("You are now able to enter the town.");
								System.out.println("\n\n           THE END                    ");
								System.out.println("\n------------------------------------------------------------------\n");
								System.exit(0);
                break;

		}

	}

	public void guardFight(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Fool, you dare pull a sword on me?");
		System.out.println("");
		System.out.println("You think to yourself: I can't run away now, either he dies... or I do");
		System.out.println("\n------------------------------------------------------------------\n");
		while((playerHP>=1) && (guardHP>=1)) {
			System.out.println("Your HP: "+ playerHP);
			System.out.println("Guard HP: " + guardHP);
			double top = Math.random();
			double bottom = 100;
			top = (int) (top * 100);
			while (bottom > top) {
				bottom = Math.random();
				bottom = (int) (bottom * 100);
			}
				System.out.println("Enter a number between " + bottom + " and " + top + " to attack the guard.");
				int attackSpeed = input.nextInt();
				int playerDamage = new java.util.Random().nextInt(8)+5;
				if ((attackSpeed > bottom) && (attackSpeed < top)){
					guardHP -= playerDamage;
					System.out.println("You hit the guard, dealing " + playerDamage + " damage.");
					System.out.println("\n------------------------------------------------------------------\n");
				}
				else {
					int guardDamage = new java.util.Random().nextInt(4);
					playerHP -= guardDamage;
					System.out.println("Your attack missed.");
					System.out.println("The guard hits you, dealing " + guardDamage + " damage.");
					System.out.println("\n------------------------------------------------------------------\n");
				}
			}
			if(playerHP < 1){
				dead();
			}
			else if(guardHP < 1){
				location = "ending2";
			}
	}

	public void fight(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Your HP: "+ playerHP);
		System.out.println("Monster HP: " + monsterHP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = input.nextInt();

		if(choice==1){
			attack();
		}
		else if(choice==2){
			location = "crossRoad";
		}
		else{
			fight();
		}
	}

	public void attack(){

		int playerDamage =0;


		if(playerWeapon.equals("Knife")){
			playerDamage = new java.util.Random().nextInt(5)+3;
		}
		else if(playerWeapon.equals("Long Sword")){
			playerDamage = new java.util.Random().nextInt(8)+5;
		}

		System.out.println("You attacked the monster and gave " + playerDamage + " damage!");

		monsterHP -= playerDamage;

		System.out.println("Monster HP: " + monsterHP);

		if(monsterHP<1){ win(); } else if(monsterHP>0){

			int monsterDamage;

			monsterDamage = new java.util.Random().nextInt(4);

			System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");

			playerHP = playerHP - monsterDamage;

			System.out.println("Player HP: " + playerHP);

			if(playerHP<1){ dead(); } else if(playerHP>0){
				fight();
			}

		}

	}

	public void dead(){

		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");
        System.exit(0);

	}

	public void win(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the monster!");
		System.out.println("The monster dropped a ring!");
		System.out.println("You obtaind a silver ring!\n\n");
		System.out.println("1: Go east");
		System.out.println("\n------------------------------------------------------------------\n");

		silverRing = 1;

		choice = input.nextInt();
		if(choice==1){
			location = "crossRoad";
		}
		else{
			win();
		}

	}

}
