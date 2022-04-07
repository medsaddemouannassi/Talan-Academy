public class Ageapprenti{



public static void main(String[] args) {

int[] ages = {45, 54, 23, 32, 64, 46, 28, 82};

int i,j,ind,x;

for (i = 0 ; i < ages.length; i++ ) {

ind=i;

for (j = i+1 ; j < ages.length; j++ ) {


if (ages[j]>ages[ind]) {

ind=j;

}

}




x=ages[ind];



ages[ind]=ages[i];



ages[i]=x;



}



for (i = 0 ; i < ages.length; i++ ) {



System.out.println(ages[i]);



}



}



}