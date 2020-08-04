package com.akamaternity.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.uncommons.maths.combinatorics.PermutationGenerator;

import com.akamaternity.game.Game;
import com.akamaternity.xlsx.Player;

/**
 *
 * シミュレーション
 *
 * @author akamaternity
 *
 */
public class Simulator {
	public static final int SIMLULATE_TIME_BY_ONE_ORDER = 1000;
	public static final int RESULT_LIST_SIZE = 5;

	private List<Player> playerList;

	private List<SimulatorResult> bestResultList;
	private List<SimulatorResult> worstResultList;

	public Simulator(List<Player> playerList) {
		this.playerList = playerList;
		this.bestResultList = new LinkedList<>();
		this.worstResultList = new LinkedList<>();
	}

	public void simulate() throws Exception {
		PermutationGenerator<Integer> gen = new PermutationGenerator<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

		int count = 0;
		while (gen.hasMore()) {
			System.out.println(++count);

			List<Integer> list = gen.nextPermutationAsList();
			List<Player> battingOrder = new ArrayList<>();

			for (Integer i : list) {
				battingOrder.add(playerList.get(i));
			}

			Game game = new Game(battingOrder);

			int totalScore = 0;

			for (int i = 0; i < SIMLULATE_TIME_BY_ONE_ORDER; i++) {
				game.play();
				totalScore += game.getRunScore();
			}

			SimulatorResult res = new SimulatorResult(list, (double)totalScore / SIMLULATE_TIME_BY_ONE_ORDER);

			setResultList(res);
		}

	}

	private void setResultList(SimulatorResult res) {
		// best
		if (this.bestResultList.isEmpty()) {
			this.bestResultList.add(res);
		} else {
			for (int i = 0 ; i < this.bestResultList.size(); i++) {
				if (res.getAvgScore() > this.bestResultList.get(i).getAvgScore()) {
					this.bestResultList.add(i, res);
					break;
				}
			}
		}

		if (this.bestResultList.size() > RESULT_LIST_SIZE) {
			this.bestResultList.remove(RESULT_LIST_SIZE);
		}

		// worst
		if (this.worstResultList.isEmpty()) {
			this.worstResultList.add(res);
		} else {
			for (int i = 0 ; i < this.worstResultList.size(); i++) {
				if (res.getAvgScore() < this.worstResultList.get(i).getAvgScore()) {
					this.worstResultList.add(i, res);
					break;
				}
			}
		}

		if (this.worstResultList.size() > RESULT_LIST_SIZE) {
			this.worstResultList.remove(RESULT_LIST_SIZE);
		}
	}

	public List<SimulatorResult> getBestResultList() {
		return bestResultList;
	}

	public List<SimulatorResult> getWorstResultList() {
		return worstResultList;
	}
}
