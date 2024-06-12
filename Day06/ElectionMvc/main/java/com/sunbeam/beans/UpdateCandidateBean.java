package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateCandidateBean {
    private int id;
    private String name;
    private String party;
    private int votes;
    private int count;
    
	public UpdateCandidateBean() {
		
	}
    
	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
    
    public void updateCandidate() {
    	Candidate c = new Candidate(id, name, party, votes);
    	System.out.println(id);
    	try(CandidateDao candDao = new CandidateDaoImpl()){
    		  count = candDao.update(c);
    		  System.out.println(count);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
