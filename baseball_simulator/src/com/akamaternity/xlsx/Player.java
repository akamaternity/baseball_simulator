package com.akamaternity.xlsx;

import com.akamaternity.game.AtBatResult;

import net.java.amateras.xlsbeans.annotation.Column;
import net.java.amateras.xlsbeans.annotation.PostProcess;

/**
 *
 * 選手
 *
 * @author akamaternity
 *
 */
public class Player {

	/** Name（名前） */
	private String name;

	/** Games（試合数） */
	private int g;

	/** Plate Appearances（打席） */
	private int pa;

	/** At Bats（打数） */
	private int ab;

	/** Runs（得点） */
	private int r;

	/** Hits（安打） */
	private int h;

	/** Two-Base Hits（二塁打） */
	private int twb;

	/** Three-Base Hits（三塁打） */
	private int thb;

	/** Home Runs（本塁打） */
	private int hr;

	/** Total Bases（塁打） */
	private int tb;

	/** Runs Batted In（打点） */
	private int rbi;

	/** Stolen Bases（盗塁） */
	private int sb;

	/** Caught Stealing（盗塁死） */
	private int cs;

	/** Sacrifice Bunts（犠打） */
	private int sac;

	/** Sacrifice Flys（犠飛） */
	private int sf;

	/** Base on Balls（四球） */
	private int bb;

	/** Hit By Pitch（死球） */
	private int hbp;

	/** Strikeouts（三振） */
	private int so;

	/** Grounded into Double Plays（併殺打） */
	private int gidp;

	/** Batting Avarage（打率） */
	private double avg;

	/** Slugging Percentage（長打率） */
	private double slg;

	/** On-base Percentage（出塁率） */
	private double obp;

	private AtBatResult[] battingResultList;

	@PostProcess
	public void createBattingResultList() {
		int ab_bb = this.ab + this.bb;

		this.battingResultList = new AtBatResult[ab_bb];

		int bb = this.bb;
		int s = this.h - this.twb - this.thb - this.hr;
		int d = this.twb;
		int t = this.thb;
		int hr = this.hr;

		int index = 0;

		// bb
		for (int i = 0; i < bb; i++, index++) {
			this.battingResultList[index] = AtBatResult.BASE_ON_BALLS;
		}

		// single
		for (int i = 0; i < s; i++, index++) {
			this.battingResultList[index] = AtBatResult.SINGLE;
		}

		// double
		for (int i = 0; i < d; i++, index++) {
			this.battingResultList[index] = AtBatResult.DOUBLE;
		}

		// triple
		for (int i = 0; i < t; i++, index++) {
			this.battingResultList[index] = AtBatResult.TRIPLE;
		}

		// home run
		for (int i = 0; i < hr; i++, index++) {
			this.battingResultList[index] = AtBatResult.HOME_RUN;
		}

		// out
		for(; index < ab_bb; index++) {
			this.battingResultList[index] = AtBatResult.OUT;
		}

	}

	/**
	 * 打席の結果を取得
	 *
	 * @return AtBatResult 打席の結果
	 */
	public AtBatResult getBattingResult() {
		int r = (int)(Math.random() * this.battingResultList.length);
		return this.battingResultList[r];
	}

	//
	// setter
	//

	@Column(columnName = "名前")
	public void setName(String name) {
		this.name = name;
	}

	@Column(columnName = "試合数")
	public void setG(int g) {
		this.g = g;
	}

	@Column(columnName = "打席")
	public void setPa(int pa) {
		this.pa = pa;
	}

	@Column(columnName = "打数")
	public void setAb(int ab) {
		this.ab = ab;
	}

	@Column(columnName = "得点")
	public void setR(int r) {
		this.r = r;
	}

	@Column(columnName = "安打")
	public void setH(int h) {
		this.h = h;
	}

	@Column(columnName = "二塁打")
	public void setTwb(int twb) {
		this.twb = twb;
	}

	@Column(columnName = "三塁打")
	public void setThb(int thb) {
		this.thb = thb;
	}

	@Column(columnName = "本塁打")
	public void setHr(int hr) {
		this.hr = hr;
	}

	@Column(columnName = "塁打")
	public void setTb(int tb) {
		this.tb = tb;
	}

	@Column(columnName = "打点")
	public void setRbi(int rbi) {
		this.rbi = rbi;
	}

	@Column(columnName = "盗塁")
	public void setSb(int sb) {
		this.sb = sb;
	}

	@Column(columnName = "盗塁死")
	public void setCs(int cs) {
		this.cs = cs;
	}

	@Column(columnName = "犠打")
	public void setSac(int sac) {
		this.sac = sac;
	}

	@Column(columnName = "犠飛")
	public void setSf(int sf) {
		this.sf = sf;
	}

	@Column(columnName = "四球")
	public void setBb(int bb) {
		this.bb = bb;
	}

	@Column(columnName = "死球")
	public void setHbp(int hbp) {
		this.hbp = hbp;
	}

	@Column(columnName = "三振")
	public void setSo(int so) {
		this.so = so;
	}

	@Column(columnName = "併殺打")
	public void setGidp(int gidp) {
		this.gidp = gidp;
	}

	@Column(columnName = "打率")
	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Column(columnName = "長打率")
	public void setSlg(double slg) {
		this.slg = slg;
	}

	@Column(columnName = "出塁率")
	public void setObp(double obp) {
		this.obp = obp;
	}

	//
	// getter
	//

	public String getName() {
		return name;
	}

	public int getG() {
		return g;
	}

	public int getPa() {
		return pa;
	}

	public int getAb() {
		return ab;
	}

	public int getR() {
		return r;
	}

	public int getH() {
		return h;
	}

	public int getTwb() {
		return twb;
	}

	public int getThb() {
		return thb;
	}

	public int getHr() {
		return hr;
	}

	public int getTb() {
		return tb;
	}

	public int getRbi() {
		return rbi;
	}

	public int getSb() {
		return sb;
	}

	public int getCs() {
		return cs;
	}

	public int getSac() {
		return sac;
	}

	public int getSf() {
		return sf;
	}

	public int getBb() {
		return bb;
	}

	public int getHbp() {
		return hbp;
	}

	public int getSo() {
		return so;
	}

	public int getGidp() {
		return gidp;
	}

	public double getAvg() {
		return avg;
	}

	public double getSlg() {
		return slg;
	}

	public double getObp() {
		return obp;
	}

}
