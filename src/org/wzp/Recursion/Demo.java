package org.wzp.Recursion;

public class Demo {
	/**
	 * 累加
	 * @param n
	 * @return
	 */
	public int sum(int n) {
			// 把问题缩小到一个单位的规模
			if(n == 1) {
				return 1;
			}
			// 调用递归
			return sum(n-1) + n;
	}
	/**
	 * 累乘
	 * @param n
	 * @return
	 */
	public int mulSum(int n) {
		if(n == 1)
			return 1;
		return mulSum(n - 1) * n;
	}
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		Demo demo = new Demo();
		System.out.println(demo.sum(5));
		System.out.println(demo.mulSum(5));
	}
}

