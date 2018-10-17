
public class Model implements Ifinals {
private int niodim;	
private int triple;	
private int mobilePhone;
private double numOfHours; 
private String[] date;

	public Model(){
	
}



public double calcTheSalary(int niodim,int triple,int mobilePhone,double numOfHours){
	this.niodim=niodim;
	this.triple=triple;
	this.mobilePhone=mobilePhone;
	this.numOfHours=numOfHours;
	int numOfMadraga= whichMadraga(this.niodim);
	
	if(this.numOfHours!=0){
		if(numOfMadraga==3){
			return (madraga3()+clacTriple()+clacMobilePhone()+clacHours());
		}else if(numOfMadraga==2){
			return (madraga2()+clacTriple()+clacMobilePhone()+clacHours());
		}else if(numOfMadraga==1){
			return (madraga1()+clacTriple()+clacMobilePhone()+clacHours());
		}else
			return (noMadrage()+clacTriple()+clacMobilePhone()+clacHours());
		}else{
			return 0;
}
}

public int whichMadraga(int niodim){
	int numOfNiodim=niodim;
	if(numOfNiodim >= NUM_OF_NIODIM_MADRAGA_3){
		return 3;
	}else if(numOfNiodim>= NUM_OF_NIODIM_MADRAGA_2){
		return 2;
	}else if(numOfNiodim >= NUM_OF_NIODIM_MADRAGA_1){
		return 1;
	}else
		return 0;
}

	private int noMadrage() {
		return ((this.niodim)*(PRICE_PER_NIOD_WITHOUT_MADRAGA));
	
	
}


	private int madraga1(){
		int numOfNiodimMoreThenMadraga=this.niodim-(NUM_OF_NIODIM_MADRAGA_1);
		int moneyForNiodim=MONEY_MADRAGA1 + (numOfNiodimMoreThenMadraga * PRICE_PER_NIOD_MADRGA_1);
		return moneyForNiodim;
	}
	
public int madraga2(){
	int numOfNiodimMoreThenMadraga=this.niodim-(NUM_OF_NIODIM_MADRAGA_2);
	int moneyForNiodim=MONEY_MADRAGA2 + (numOfNiodimMoreThenMadraga * PRICE_PER_NIOD_MADRGA_2);
	return moneyForNiodim;
	}

public int madraga3(){
	int numOfNiodimMoreThenMadraga=this.niodim-(NUM_OF_NIODIM_MADRAGA_3);
	int moneyForNiodim=MONEY_MADRAGA3 + (numOfNiodimMoreThenMadraga * PRICE_PER_NIOD_MADRGA_3);
	return moneyForNiodim;
}

private int clacTriple(){
	 return this.triple*PRICE_PER_TRIPLE;
}

private int clacMobilePhone(){
	 return this.mobilePhone*PRICE_PER_MOBILE_PHONE;
}
private double clacHours(){
	 return this.numOfHours* PRICE_PER_HOUR;
}


}