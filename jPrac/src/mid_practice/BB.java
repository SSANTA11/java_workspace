package mid_practice;

import java.util.Scanner;

public class BB {
	public void main(String[] args) {
		int nums[] = new int[3], max = 0, sum = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			for (int i = 0; i < 3; i++) {
				nums[i] = sc.nextInt();
				if (nums[i] > nums[max]) {
					max = i;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (i != max) {
					sum += nums[i];
				}
			}
			if (sum <= nums[max]) {
				nums[max] -= 1;
				sum = 0;
				continue;
			} else {
				sum += nums[max];
				System.out.println(sum);
				break;
			}
		}
	}
}
