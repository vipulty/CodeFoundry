package com.codefoundry.practise.general;

public class SumIndex {
	
	int index = 0;
	
	int remainingsum = 0;

	public SumIndex(int index, int remainingsum) {
		this.index = index;
		this.remainingsum = remainingsum;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getRemainingsum() {
		return remainingsum;
	}

	public void setRemainingsum(int remainingsum) {
		this.remainingsum = remainingsum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + remainingsum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SumIndex other = (SumIndex) obj;		
		if (remainingsum != other.remainingsum)
			return false;
		return true;
	}
	

}
