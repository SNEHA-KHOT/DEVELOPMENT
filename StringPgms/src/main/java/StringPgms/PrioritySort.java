package StringPgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.google.common.collect.ComparisonChain;
public class PrioritySort {
	
	 
	

		public static void main(String[] args) {
				
			 
			 
			 List<Priority> list = new ArrayList<>();
				
				list.add(new Priority(2) );
				list.add(new Priority(1) );
				list.add(new Priority(0) );
				list.add(new Priority(3) );
		 
				//Collections.sort(list, new Comparator<Priority>()
	
				System.out.println(list);
		
	 
	Collections.sort(list, new Comparator<Priority>() {
		
		 @Override
			public int compare(Priority m1,Priority m2) {
				
				int j=1,k=1;
				
				Map<Integer,Integer> wMap=new HashMap<>();
				for(Priority Ticket:list ) {
					
				wMap.put(k++,j++);
				}
				wMap.put(0,j++);
				System.out.println(wMap);
				
				
			//return ComparisonChain.start().compare(wMap.get(m1.getPid()),wMap.get(m1.getPid())).result() ;
				
				if(wMap.get(m1.getPid()) == wMap.get(m1.getPid())) return 0;
				else if(wMap.get(m1.getPid()) > wMap.get(m1.getPid())) return 1;
				else return -1;

				/*if(m1.getPid() == m1.getPid())return 0;
				else if(m1.getPid() > m1.getPid()) return 1;
				else return -1;*/
			
		 }});
	

	System.out.println(list);
	for (Priority p :list ) {
		System.out.println("Priority "+p.getPid());
	}
		
		
}}
	
	
	


