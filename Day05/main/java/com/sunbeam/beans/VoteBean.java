package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

public class VoteBean {
	private int userId;
	private int candidateId;
	private Candidate candidate;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	
	public void Voted() {
		try(UserDao userDao = new UserDaoImpl(); CandidateDao candDao = new CandidateDaoImpl()){
			User u = userDao.findById(userId);
			System.out.println(u);
			if(u.getStatus()==0)
			{
				int count = candDao.incrementVote(candidateId);
				if(count == 1)
				{
				   count = userDao.updateStatus(userId, true);
				   if(count == 1)
				   {
				   System.out.println("voted successfully");
				   }
				}
			 
			   else
			   {
				System.out.println("already voted");
			   }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
}