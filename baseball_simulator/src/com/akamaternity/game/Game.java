package com.akamaternity.game;

import java.util.List;

import com.akamaternity.xlsx.Player;

/**
 *
 * 試合
 *
 * @author akamaternity
 *
 */
public class Game {
	private List<Player> battingOrder;

	private int inning;
	private int outCount;
	private int batterNum;
	private int runScore;
	private boolean[] runner;

	/**
	 * コンストラクタ
	 *
	 * @param battingOrder 打順のリスト
	 * @throws Exception
	 */
	public Game(List<Player> battingOrder) throws Exception {
		if (battingOrder.size() != 9) {
			throw new Exception("引数　List<Player> のsizeは9でなければなりません。");
		}

		this.battingOrder = battingOrder;
		this.runner = new boolean[4];
	}

	public void play() {
		init();

		for (; this.inning < 9; change()) {
			for (; this.outCount < 3; nextBatter()) {
				Player batter = battingOrder.get(this.batterNum);
				AtBatResult res = batter.getBattingResult();

				this.outCount += res.getOut();

				for (int i = this.runner.length - 1; i >= 0; i--) {
					if (!this.runner[i]) {
						continue;
					}

					this.runner[i] = false;

					if (i + res.getBases() > this.runner.length - 1) {
						this.runScore++;
					} else {
						this.runner[i + res.getBases()] = true;
					}
				}
			}
		}
	}

	private void init() {
		this.inning = 0;
		this.outCount = 0;
		this.batterNum = 0;
		this.runScore = 0;

		for (int i = 1; i < this.runner.length; i++) {
			runner[i] = false;
		}
	}

	public int getRunScore() {
		return runScore;
	}

	private void change() {
		this.inning++;
		this.outCount = 0;

		for (int i = 1; i < this.runner.length; i++) {
			runner[i] = false;
		}
	}

	private void nextBatter() {
		this.batterNum++;
		this.runner[0] = true;

		if (this.batterNum > 8) {
			this.batterNum = 0;
		}
	}

}
