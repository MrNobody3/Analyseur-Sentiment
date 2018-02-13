package com.service;

import com.bo.WordPolarity;

public interface AnalysisSentiment {
	
	public double getTextPolarity(String tokens);
	
	public void addWord(WordPolarity word);
	
	public void destinationRating();
}
