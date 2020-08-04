package com.akamaternity.main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.akamaternity.simulator.Simulator;
import com.akamaternity.simulator.SimulatorResult;
import com.akamaternity.xlsx.Player;
import com.akamaternity.xlsx.Players;

import net.java.amateras.xlsbeans.XLSBeans;
import net.java.amateras.xlsbeans.xssfconverter.WorkbookFinder;

/**
 *
 * メイン
 *
 * @author akamaternity
 *
 */
public class Main {
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("file\\Book1.xlsx");

			Players players = new XLSBeans().load(in, Players.class, WorkbookFinder.TYPE_XSSF);
			List<Player> list = players.getPlayers();

			Simulator simu = new Simulator(list);
			simu.simulate();
			List<SimulatorResult> bestResultlist = simu.getBestResultList();
			List<SimulatorResult> worstResultlist = simu.getWorstResultList();

			for (int i = 0; i < bestResultlist.size(); i++) {
				SimulatorResult res = bestResultlist.get(i);
				System.out.println("平均得点：" + res.getAvgScore());
				for(Integer j : res.getOrder()) {
					System.out.print(list.get(j).getName() + ", ");
				}
				System.out.println();
				System.out.println("--------------------");
			}

			for (int i = 0; i < worstResultlist.size(); i++) {
				SimulatorResult res = worstResultlist.get(i);
				System.out.println("平均得点：" + res.getAvgScore());
				for(Integer j : res.getOrder()) {
					System.out.print(list.get(j).getName() + ", ");
				}
				System.out.println();
				System.out.println("--------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
