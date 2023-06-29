import java.util.Scanner;

public class Labyrinth {
	
	public static int x;
	public static int y;
	public static int endX;
	public static int endY;
	public static int newX;
	public static int newY;
	public static int randomX;
	public static int randomY;
	public static boolean step;
	public static boolean stepBack;
	public static boolean stepBackNachLinks;
	public static boolean stepBackNachOben;
	public static boolean d;
	
	public static char[][] map1() {
		
		char[][] map1 = new char[][]{
			{' ','.','.','.','.','.','.','.','.','.','.','.','.','.'},           
			{' ','.',' ',' ',' ',' ',' ','.','.',' ',' ',' ',' ','.'},
			{' ','.',' ','.','.','.',' ',' ','.',' ',' ','.',' ','.'},
			{' ','.',' ',' ',' ','.','.',' ','.','.',' ','.',' ','A'},
			{' ','.','.','.',' ','.',' ',' ',' ',' ',' ','.',' ','.'},
			{' ','.',' ',' ',' ','.','.',' ','.','.',' ','.',' ','.'},           //map
			{' ','.',' ','.','.',' ',' ',' ','.',' ',' ','.',' ','.'},
			{' ','>',' ','.',' ',' ','.',' ','.',' ','.','.',' ','.'},
			{' ','.','.','.','.','.','.','.','.','.','.','.','.','.'}
		};
		
		return map1;
	}	
	
	public static char[][] map2() {
		char[][] map2 = new char[][]{
			{' ','.','.','.','.','.','.','.','.','.','.','.'},           
			{' ','.',' ',' ',' ',' ',' ',' ',' ','.',' ','.'},
			{' ','.','.',' ','.','.',' ','.',' ','.',' ','.'},
			{' ','.',' ',' ',' ','.',' ','.','.','.',' ','.'},
			{' ','.',' ','.',' ','.',' ',' ',' ','.',' ','.'},
			{' ','.',' ','.',' ','.','.','.',' ','.',' ','.'},           //карта
			{' ','.',' ','.',' ',' ',' ','.',' ','.',' ','A'},
			{' ','>',' ','.','.','.',' ','.',' ',' ',' ','.'},
			{' ','.','.','.','.','.','.','.','.','.','.','.'}
		};
		
		return map2;
	}
	
	public static char[][] map3() {
		char[][] map3 = new char[][]{
			{' ','.','.','.','.','.','.','.','.','.','.','.','.','.'},           
			{' ','.',' ','.',' ','.',' ',' ',' ','.',' ',' ',' ','.'},
			{' ','.',' ','.',' ','.','.','.',' ','.',' ','.',' ','.'},
			{' ','>',' ','.',' ',' ',' ','.',' ','.',' ','.',' ','.'},
			{' ','.',' ','.',' ','.',' ',' ',' ','.',' ','.',' ','.'},
			{' ','.',' ','.',' ','.',' ','.',' ',' ',' ','.',' ','.'},           //карта
			{' ','.',' ',' ',' ',' ','.','.',' ','.',' ',' ',' ','A'},
			{' ','.',' ','.','.',' ',' ',' ','.','.',' ','.',' ','.'},
			{' ','.','.','.','.','.','.','.','.','.','.','.','.','.'}
		};
		
		return map3;
	}	
	
	public static char[][] platzFrei(char[][] map, boolean step, boolean stepBack, boolean stepBackNachLinks, boolean stepBackNachOben){
		int posX = 0;
		int posY = 0;
		
		for (int i = 0; i < map.length; i++) {					//Überprüfen, ob wir nach rechts gehen können 
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A' && map[i][j] != 'D' ) {
					posX = j;
					posY = i;
				}
			}
		}
		
		if(map[posY][posX-1] == '.' && map[posY-1][posX] == '.' && map[posY+1][posX] == '.') {
			stepBack = false;	
		}
		
		if(map[posY-1][posX] == '.' && map[posY+1][posX] == ' ' && map [posY][posX+1] == ' ') {
			stepBackNachLinks = true;	
		}
		if(stepBack == true) {
			step = false;
		}
		
		for (int i = 0; i < map.length; i++) {					//Überprüfen, ob wir nach rechts gehen können 
			for (int j = 0; j < map[i].length; j++) {
				if((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A' && map[i][j] != 'D' )&& map[i][j-1] == '.' && map[i-1][j] == '.' && map[i+1][j] == '.') {
					stepBack = false;	
				}
				
				if((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A' && map[i][j] != 'D')&& map[i-1][j] == '.' && map[i+1][j] == ' ' && map [i][j+1] == ' ') {
					stepBackNachLinks = true;	
				}
				if(stepBack == true) {
					step = false;
				}
				
				else if (stepBack == false) {
					
					if((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A' && map[i][j] != 'D')&& map[i][j+1] == '.' && map[i+1][j] == '.' && map[i-1][j] == '.') {
						stepBackNachLinks = false;	
					}
					if((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] == '.' && map[i+1][j] == '.' && map[i][j-1] == '.') {
						stepBackNachOben = false;	
					}
					
					if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& (map[i][j+1] == ' '|| map[i][j+1] == 'A')) {
						x = j;
						newX = j+1;
						y = i;
						newY = i;
						step =true;
					}
					
					if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] == 'D') {
						d = true;
						step = true;
						newX = j+1;
						newY = i;
						x = j;
						y = i;
					}
				}	
			}
		}
		
	    if (step != true && stepBack != true) { 							//Überprüfen, ob wir den Schritt zurück machen 
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(stepBackNachOben == false ) {						//Überprüfen, ob wir nach oben gehen können
						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
							if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i-1][j] == ' ') {
								x = j;
								newX = j;
								y = i;
								newY = i-1;
								step =true;
							} else if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i-1][j] == 'D') {
								newX = j;
								newY = i-1;
								x = j;
								y = i;
								step = true;
								d = true;
							}
						}
					}
					if (stepBackNachLinks == false && step != true) {		//Überprüfen, ob wir nach links gehen können		
						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
							if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j-1] == ' ') {
								x = j;
								y = i;
								newX = j-1;
								newY = i;
								step = true;
							} else if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j-1] == 'D') {
								newX = j-1;
								newY = i;
								x = j;
								y = i;
								step = true;
								d = true;
							}
						}	
					}
					if (step != true) {										//Überprüfen, ob wir nach unter gehen können	
						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
							if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i+1][j] == ' ') {
								x = j;
								y = i;
								newX = j;
								newY = i+1;
								step = true;
							} else if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i+1][j] == 'D') {
								newX = j;
								newY = i+1;
								x = j;
								y = i;
								step = true;
								d = true;
							}
						}
					}
//					if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
//						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A') && map[i+1][j] == 'D') {
//							d = true;
//							x = j;
//							y = i;
//							newX = j;
//							newY = i+1;
//							
//						}
//					}
//					if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
//						if (map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i+1][j] == 'D') {
//							step = false;
//							stepBack = true;
//							x = j;
//							y = i;
//							newX = j;
//							newY = i+1;
//						}
//					}
				}
			}	
	    }
	    
	    if (step != true && stepBack == true) {								//Überprüfen, ob wir den Schritt zurück machen 
	    	for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (stepBackNachOben == false) {						//Überprüfen, ob wir nach oben gehen können
						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] == ' ') {
							if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i-1][j] == ' ') {
								x = j;
								y = i;
								newX = j;
								newY = i-1;
								step =true;
							} else if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i-1][j] == 'D') {
								newX = j;
								newY = i-1;
								x = j;
								y = i;
								step = true;
								d = true;
							}
						}
					}
					if (stepBackNachLinks == false && step != true) {		//Überprüfen, ob wir den Schritt zurück machen 
						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] == ' ') {
							if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j-1] == ' ') {
								x = j;
								y = i;
								newX = j-1;
								newY = i;									//Überprüfen, ob wir nach links gehen können
								step = true;
							} else if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j-1] == 'D') {
								newX = j-1;
								newY = i;
								x = j;
								y = i;
								step = true;
								d = true;
							}
						}
					}
//					if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
//						if (map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i-1][j] == 'D') {
//							step = false;
//							stepBack = true;
//							x = j;
//							y = i;
//							newX = j;
//							newY = i-1;
//						}
//					}
//					if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
//						if (map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i+1][j] == 'D') {
//							step = false;
//							stepBack = true;
//							x = j;
//							y = i;
//							newX = j;
//							newY = i+1;
//						}
//					}
					
					if (step != true && stepBack == false) {				//Überprüfen, ob wir den Schritt zurück machen 
						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] != ' ') {
							if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i+1][j] == ' ') {
								x = j;
								y = i;
								newX = j;
								newY = i+1;		
								step = true;	//Überprüfen, ob wir nach unter gehen können
							} else if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i+1][j] == 'D') {
								newX = j;
								newY = i+1;
								x = j;
								y = i;
								step = true;
								d = true;
							}
						}
					}
					if (step != true && stepBack != false) {								
						if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i][j+1] == ' ') {
							if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i+1][j] == ' ') {
								x = j;
								y = i;
								newX = j;
								newY = i+1;
								step = true;
							} else if ((map[i][j] != ' ' && map[i][j] != '.' && map[i][j] != 'A'&& map[i][j] != 'D')&& map[i+1][j] == 'D') {
								newX = j;
								newY = i+1;
								step = true;
								d = true;
							}
						}
					}
				}	
			}
	    }
	    return map;
	}
	
	public static char[][] bewegung(char[][] map, char[][] weg, int newX, int newY, int x, int y, boolean d) {

		if (newX > x && newY == y && d != true) {										//Schritt, wenn wir nach rechts gehen
	    	for (int i = 0; i < map.length; i++) {
	    		for (int j = 0; j < map[i].length; j++) {
	    			map[newY][newX] = '>';
	    			weg[newY][newX] = '>';
	    			map[y][x] = ' ';
				}
	    	}
	    	x = x+1;
	    	step = false;
	    	stepBack = false;
	    	stepBackNachLinks = true;
	    	stepBackNachOben = false;
	    }
	     
	     else if (newX < x && newY == y && d != true) {									//Schritt, wenn wir nach links gehen
		    for (int i = 0; i < map.length; i++) {
		   		for (int j = 0; j < map[i].length; j++) {
		   			map[newY][newX] = '<';
		   			weg[newY][newX] = '<';
		   			map[y][x] = ' ';
				}
	    	}
		    x = x-1;
		    step = false;
		    stepBack = true;
		    stepBackNachLinks = false;
		    stepBackNachOben = false;
	     }
	    
	     else if (newY < y && newX == x && d != true) {									//Schritt, wenn wir nach oben gehen
	    	for (int i = 0; i < map.length; i++) {
	    		for (int j = 0; j < map[i].length; j++) {
	    			map[newY][newX] = '^';
	    			weg[newY][newX] = '^';
	    			map[y][x] = ' ';
				}
	    	}
			y = y-1;
	    	step = false;
	    	stepBack= false;
	    	stepBackNachLinks = false;
	    	stepBackNachOben = false;
	     }
	    
	     else if (newY > y && newX == x && d != true) {									//Schritt, wenn wir nach unter gehen
	    	for (int i = 0; i < map.length; i++) {
	    		for (int j = 0; j < map[i].length; j++) {
	    				map[newY][newX] = 'v';
	    				weg[newY][newX] = 'v';
						map[y][x] = ' ';
				}
	        }	
			y = y+1;
	    	step = false;
	    	stepBack = false;
	    	stepBackNachLinks = true;
	    	stepBackNachOben = true;
	     }
	     else if (d == true) {									//Schritt, wenn wir nach unter gehen
		    	for (int i = 0; i < map.length; i++) {
		    		for (int j = 0; j < map[i].length; j++) {
		    				map[newY][newX] = 'D';
		    				weg[newY][newX] = 'D';
							map[y][x] = ' ';
					}
		        }	
		     }
		return map;
	}

	public static void mapAusgabe(char[][]map, char[][] weg, boolean finisch){
		if (finisch == true) {
			for (int i = 0; i < weg.length; i++) {									//Array mit dem ganzen Weg 
				for (int j = 0; j < weg[i].length; j++) {
					System.out.print(weg[i][j] +"\s");
				}
			System.out.println();
			}
		}
		else {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {				//Gewählte Map
					if (map[i][j] == '>' && map[i][j] == '<' && map[i][j] == 'v' && map[i][j] == '^') {
						x = j;											//x von Startpunkt
						y = i;											// y von Startpunkt
					}
					if (map[i][j] == 'A') {								
						endX = j;										// x von Endpunkt
						endY = i;										// y von Endpunkt
					}
					System.out.print(map[i][j] +"\s");
				}
				System.out.println();
			}
		}
	}
	public static void dunklenMacht(char map[][]) {
	
		int anzahlD = 0;
			
			do {
				randomX = (int) (5+Math.random()*(map[0].length-6));
				randomY = (int) (3+Math.random()*(map.length-3));
				
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {				//Gewählte Map
						if (map[i][j] == ' ' && map[i][j] == map[randomY][randomX]) {
							map[randomY][randomX] = 'D';
							anzahlD += 1;// y von Startpunkt
						}
					}
				}
			} while (anzahlD != 1);
			
		
	}
	

	public static void main (String[] args) {	
	    
		Scanner wählen = new Scanner(System.in);
		int labyrinth;
		int schritte = 0;
		boolean finisch = false;
		char[][]weg = new char[8][14];
		char[][]map;
		
		map = map1();
		System.out.println("Labyrinth 1. ");
		mapAusgabe(map, weg, finisch);
		map = map2();
		System.out.println("\n" + "Labyrinth 2. ");
		mapAusgabe(map, weg, finisch);
		System.out.println("\n" + "Labyrinth 3. ");
		map = map3();
		mapAusgabe(map, weg, finisch);
		
		
		System.out.print("Welcher Labyrinth wählst du? (1, 2 oder 3): ");
		labyrinth = wählen.nextInt(); 						// Welche Map  wählt der Spieler
		
		System.out.println("\n" + "BB-8 auf der Suche ..." + "\n");
		if(labyrinth == 1) {
			map = map1();
			dunklenMacht(map);
			mapAusgabe(map, weg, finisch);
			do {
		    	
		    	schritte += 1;
		    	System.out.println("Schritt " + schritte +": ");
		    	platzFrei(map, step, stepBack, stepBackNachLinks, stepBackNachOben);
		    	bewegung(map, weg, newX, newY, x, y, d);
		    	mapAusgabe(map, weg, finisch);
		    	
			} while((newX != endX || newY != endY) && ( d != true));
		}
		
		else if(labyrinth == 2) {
			map = map2();
			dunklenMacht(map);
			mapAusgabe(map, weg, finisch);
			do {
		    	
		    	schritte += 1;
		    	System.out.println("Schritt " + schritte +": ");
		    	platzFrei(map, step, stepBack, stepBackNachLinks, stepBackNachOben);
		    	bewegung(map, weg, newX, newY, x, y, d);
		    	mapAusgabe(map, weg, finisch);
		    	
			} while((newX != endX || newY != endY) && ( d != true));
		}
		
		else if(labyrinth == 3) {
			map = map3();
			dunklenMacht(map);
			mapAusgabe(map, weg, finisch);
			do {
		    	
		    	schritte += 1;
		    	System.out.println("Schritt " + schritte +": ");
		    	platzFrei(map, step, stepBack, stepBackNachLinks, stepBackNachOben);
		    	bewegung(map, weg,  newX, newY, x, y, d);
		    	mapAusgabe(map, weg, finisch);
		    	
			} while((newX != endX || newY != endY) && ( d != true));
		}
		finisch = true;
		
		if (d == true) {
			System.out.println("ich habe verloren(((");
		} else { 
			
	    System.out.println("Ausgang in " +schritte +" Schritten gefunden." +"\n");
	    System.out.println("So hab ich den Ausgang gefunden: ");
		}
		
	    mapAusgabe(map, weg, finisch);
	}
}