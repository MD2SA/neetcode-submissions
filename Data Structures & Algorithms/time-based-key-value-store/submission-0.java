class TimeMap {
	
	private class Data {
		int time;
		String name;
		public Data(int time, String name) {
			this.time = time;
			this.name = name;
		}
	}
	
	private final Map<String, List<Data>> map = new HashMap<>();		

	public TimeMap() {	}
	
	public void set(String key, String value, int timestamp) {
		map.putIfAbsent(key, new ArrayList<>());
		map.get(key).add(new Data(timestamp, value));
	}
	
	public String get(String key, int timestamp) {
		List<Data> list = map.get(key);
		if(list == null || list.isEmpty()) return "";
		
		int lo = 0, hi = list.size()-1; 
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			int stored = list.get(mid).time;
			if(stored < timestamp) {
				lo = mid +1;
			} else if( stored > timestamp) {
				hi = mid - 1;
			} else {
				return list.get(mid).name;
			}
		}
		if(hi<0) return "";
		return list.get(hi).name;
	}
}
