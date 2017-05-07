package com.ralf.queue;

import java.util.ArrayList;
import java.util.List;

public class Josephus {

	public static List<Integer> execute(int n, int m) {

		List<Integer> list = new ArrayList<Integer>();
		CircleQueue<Integer> queue = new CircleQueue<>();

		for (int i = 0; i < n; i++) {
			queue.enQueue(i);
		}

		while (queue.size() > 0) {

			for (int i = 0; i < m; i++) {
				Integer temp = queue.deQueue();
				if (i == m - 1) {
					list.add(temp);
				} else {
					queue.enQueue(temp);
				}
			}

		}

		return list;
	}
}
