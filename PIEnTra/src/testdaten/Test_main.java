package testdaten;

public class Test_main {
	private Testfaelle testfaelle = new Testfaelle();
	
	
	
	public Test_main() {
		init();
		
	}
	
	
	public static void main( String[] args) {
		
		Test_main test_main = new Test_main();
		
	
		
	}

	public void init() {
		/*System.out.println(this.testfaelle.getTraining1().getKunde().getAnsprechpartner().getVorname());
		System.out.println(this.testfaelle.getOrt2());
		System.out.println(this.testfaelle.getTrainer3());
		System.out.println(this.testfaelle.getmAssistent());
		System.out.println(this.testfaelle.getGww());*/
		System.out.println(this.getTestfaelle().getTraining1());
		
	}

	public Testfaelle getTestfaelle() {
		return testfaelle;
	}



	public void setTestfaelle(Testfaelle testfaelle) {
		this.testfaelle = testfaelle;
	}

}
