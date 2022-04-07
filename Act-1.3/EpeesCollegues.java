public class EpeesCollegues{



public static void main(String[] args) {

String[] prenoms = {"Alban", "Jim", "Bob", "Albatroz", "Jinto", "Bow", "Hijo", "Manu", "Seb", "Teilo", "Charles", "Xavier"};


int k;
String x;

for (int i = 0 ; i < prenoms.length-1; i++ ) {

	for (int j = prenoms.length-1 ; j > i; j-- ) {

	k=0;

	while (k < Math.min(prenoms[j].length(), prenoms[j-1].length())) {


	if (prenoms[j].charAt(k)<prenoms[j-1].charAt(k)) {
	x=prenoms[j];
	prenoms[j]=prenoms[j-1];
	prenoms[j-1]=x;
	k =Math.min(prenoms[j].length(), prenoms[j-1].length());
} 
 else if (prenoms[j].charAt(k)>prenoms[j-1].charAt(k)) {
k=Math.min(prenoms[j].length(), prenoms[j-1].length());
}

else {
k++;
}
}
}
}


for (int i = 0 ; i < prenoms.length; i++ ) {

System.out.println(prenoms[i]);

}

}
}