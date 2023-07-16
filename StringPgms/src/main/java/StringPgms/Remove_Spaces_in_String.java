package StringPgms;

public class Remove_Spaces_in_String {
	
	public static void main(String[] args) {
		
		String str="300 min";
		System.out.println("Time:"+Timings(str));
	}
		
		public static int Timings(String str) {
			
			String[] splited = str.split("\\s+");
			int time=0;
			for(int i=0;i<splited.length;i++) {
			System.out.println(splited[i]);
			time =Integer.parseInt(splited[0]);
		
			
			
		}
			return time;
}}
