package Tiktok;
import java.util.*;
public class first {
	static ArrayList p1pos=new ArrayList();
	static ArrayList p2pos=new ArrayList();
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		char board[][]= {{' ','|',' ','|',' '},
							{'-','+','-','+','-'},
							{' ','|',' ','|',' '},
							{'-','+','-','+','-'},
							{' ','|',' ','|',' '}};
		display(board);
		while(true) {
			System.out.println("Enter first player position");
			int p1=sc.nextInt();
			while((p1pos.contains(p1))||(p2pos.contains(p1)))
			{
				System.out.println("Postion is already occupied");
				p1=sc.nextInt();
			}
			insert(board,p1,'X');
			Checkforwinner();
			display(board);
			
			System.out.println("Enter Second player position");
			int p2=sc.nextInt();
			while((p1pos.contains(p2))||(p2pos.contains(p2))) {
				System.out.println("Postion is already occupied");
				p2=sc.nextInt();
			}
			insert(board,p2,'O');
			Checkforwinner();
			display(board);
			System.out.println(p1pos);
			System.out.println(p2pos);
		}
	}
	static void display(char board[][]) {
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	static void insert(char board[][],int pos,char sym) {
		if(sym=='X') {
			p1pos.add(pos);
		}
		else
			p2pos.add(pos);
		switch(pos)
		{
		case 1: board[0][0]=sym;
				break;
		case 2:board[0][2]=sym;
				break;
		case 3:board[0][4]=sym;
				break;
		case 4:board[2][0]=sym;
				break;
		case 5:board[2][2]=sym;
				break;
		case 6:board[2][4]=sym;
				break;
		case 7:board[4][0]=sym;
				break;
		case 8:board[4][2]=sym;
				break;
		case 9:board[4][4]=sym;
				break;
		default:System.out.println("Invalid Entey");
		}
	}
	static void Checkforwinner() {
		List toprow=Arrays.asList(1,2,3);
		List midrow=Arrays.asList(4,5,6);
		List botrow=Arrays.asList(7,8,9);
		List leftcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rigcol=Arrays.asList(3,6,9);
		List dig1=Arrays.asList(1,5,9);
		List dig2=Arrays.asList(3,5,7);
		List<List> masterlist =new ArrayList<List>();
		masterlist.add(toprow);
		masterlist.add(midrow);
		masterlist.add(botrow);
		masterlist.add(leftcol);
		masterlist.add(midcol);
		masterlist.add(rigcol);
		masterlist.add(dig1);
		masterlist.add(dig2);
		for(List l:masterlist)
		{
			if(p1pos.containsAll(l))
			{
				System.out.println("p1 is the Winner");
				System.exit(0);
			}
			else if(p2pos.containsAll(l)) {
				System.out.println("p2 is the winner");
				System.exit(0);
			}
			else if((p1pos.size() + p2pos.size())==9)
			{
				System.out.println("It draw");
				System.exit(0);
			}
				
		}
	}
}
