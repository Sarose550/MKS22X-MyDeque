import java.util.Scanner;
public class Calculator{
	public static void main(String[] args){
		System.out.println("8 2 + 99 9 - * 2 + 9 -");
		System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	}
	public static double eval(String input){
		MyDeque<Double> que = new MyDeque<Double>();
		Scanner s = new Scanner(input);
		while(s.hasNext()){
			String stuff = s.next();
			if(stuff.equals("+")){
				double a1 = que.removeLast();
				double a2 = que.removeLast();
				que.addLast(a1+a2);
			}
			else{
				if(stuff.equals("-")){
					double a1 = que.removeLast();
					double a2 = que.removeLast();
					que.addLast(a2-a1);
				}
				else{
					if(stuff.equals("*")){
						double a1 = que.removeLast();
						double a2 = que.removeLast();
						que.addLast(a1*a2);
					}
					else{
						if(stuff.equals("/")){
							double a1 = que.removeLast();
							double a2 = que.removeLast();
							que.addLast(a2/a1);
						}
						else{
							if(stuff.equals("%")){
								double a1 = que.removeLast();
								double a2 = que.removeLast();
								que.addLast(a2%a1);
							}
							else{
								que.addLast(Double.parseDouble(stuff));
							}
						}
					}
				}
			}
		}
		return que.getLast();
	}
}
