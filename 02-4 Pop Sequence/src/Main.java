/**
 * @author:Aamperor
 * @Date  :2019年10月28日
 * @desc  :judge the Pop Sequence is correct or not 
 *@refer  :https://www.iteye.com/blog/shmilyaw-hotmail-com-2174707
 */
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int capacity = in.nextInt();
		int seqLength = in.nextInt();
		int line = in.nextInt();
		while(line > 0) {
			int[] stack = new int[seqLength];
			for(int i = 0; i < seqLength; i++) {
				stack[i] = in.nextInt();
			}
			String output = popIsRight(stack,capacity)?"YES":"NO";
			System.out.println(output);			
			line--;
		}
	}
	
	
	
	public static Boolean popIsRight(int[] list,int capacity) {
		for(int i = 0; i < list.length; i++) {
			//判断栈中元素是否大于栈容量
			int count = 1;
			int cur = list[i];
			for(int j = i + 1; j < list.length; j++) {
				if(list[j] < list[i]) {
					count++;
					//比list[i]小的元素必然是递减输出
					if(count > capacity || list[j] > cur) {
						return false;
					}
					cur = list[j];
					
				}
			}
		}
		return true;
	}

}
