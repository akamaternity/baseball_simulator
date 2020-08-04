package com.akamaternity.simulator;

import java.util.List;

/**
 *
 * シミュレーション結果を格納するクラス
 *
 * @author akamaternity
 *
 */
public class SimulatorResult {

	private double avgScore;
	private List<Integer> order;

	public SimulatorResult(List<Integer> order, double avgScore) {
		this.order = order;
		this.avgScore = avgScore;
	}

	public double getAvgScore() {
		return avgScore;
	}
	public List<Integer> getOrder() {
		return order;
	}
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}
	public void setOrder(List<Integer> order) {
		this.order = order;
	}
}
