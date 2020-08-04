package com.akamaternity.game;

/**
 *
 * 打席結果　定数クラス
 *
 * @author akamaternity
 *
 */
public enum AtBatResult {
	SINGLE("単打", 1, 0),
	DOUBLE("二塁打", 2, 0),
	TRIPLE("三塁打", 3, 0),
	HOME_RUN("本塁打", 4, 0),
	BASE_ON_BALLS("四球", 1, 0),
	OUT("アウト", 0, 1)
	;

	private final String name;
	private final int bases;
	private final int out;

	private AtBatResult(String name, int bases, int out) {
		this.name = name;
		this.bases = bases;
		this.out = out;
	}

	public String getName() {
		return name;
	}

	public int getBases() {
		return bases;
	}

	public int getOut() {
		return out;
	}

}
