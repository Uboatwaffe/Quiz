#include<bits/stdc++.h>
using namespace std;

bool correct(int x){
	int ile = 0;
	
	int i = 2;
	
	while(x != 0){
		if(x % i == 0 && i % 2 != 0){
			ile++;
		}
		i++;
	}
	
	if(ile == 3) return true;
	return false
}

int main(){
	ifstream in("liczby.txt");
	ofstream out("wyniki_liczby.txt");
	
	while(in.eof()){
		cout << correct()
	}
}
