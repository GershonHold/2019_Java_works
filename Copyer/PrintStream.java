public static void main(String[] args) {
	try {
		PrintStream ps=new PrintStream("abccc.txt");
		ps.print("Hello,My friends!");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}