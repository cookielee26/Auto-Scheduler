import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class FreeTimeSchedule {
  Scanner scan = new Scanner(System.in);
  int[] timesFrom;
  int[] timesTo;
  private static int num = 0;

  public static void main(String[] args) {
    FreeTimeSchedule myStuff = new FreeTimeSchedule();

    if(args.length >= 1) {
      num = Integer.parseInt(args[0]);
      System.out.println(num + " people are meeting!");
    } else {
      myStuff.runProgram();
    }


    myStuff.askTime();
    myStuff.calculation();

  }

  public void runProgram() {
    System.out.println("How many people are meeting?");
    while (!scan.hasNextInt()) {
      System.out.println("That's not a number!");
      System.out.println("How many people are meeting?");
      scan.next();
    }
    num = scan.nextInt();
  }

  public void askTime() {
    timesFrom = new int[num];
    timesTo = new int[num];

    for(int i = 0; i < num; i++) {
      int ppnum = i+1;
      System.out.println("Person " + ppnum +". What time are you free?");
      System.out.println("from and to:");
      int from = scan.nextInt();
      if(from > 24){
        System.out.println("Wrong hour, Please enter new hour (from)");
        from = scan.nextInt();
        timesFrom[i] = from;
      } else{
        timesFrom[i] = from;
        }
      int to = scan.nextInt();
      if(to > 24){
        System.out.println("Wrong hour, Please enter new hour (to)");
        to = scan.nextInt();
        timesTo[i] = to;
      } else if (to < from) {
        System.out.println("Wrong hour, Please enter new hour (to)");
        to = scan.nextInt();
        timesTo[i] = to;
      } else{
        timesTo[i] = to;
        }
    }
  }

  public void calculation() {
    Arrays.sort(timesFrom);
    Arrays.sort(timesTo);

    int meetFrom = timesFrom[timesFrom.length-1];
    int meetTo = timesTo[0];
    int meetingTime = meetTo - meetFrom;
    if (meetingTime <= 0) {
      System.out.println("You guys cannot meet");
    } else{
      System.out.println("You can meeet for " + meetingTime + "hours, which is from " + meetFrom + " to " +meetTo +".");
      }
  }

}
