#include<bits/stdc++.h>
using namespace std;

/*
slodkie_koty wole_psy123
slodkie_koty iskierka15
puszek_the_best_cat SzalonePsiaki
wole_psy123 slodkie _koty
puszek_the_best_cat wole_psy
SzalonePsiaki wole_psy123
*/

// 4.1
string db[421];
int j = 0;

bool exists(string name){
	for(int i = 0; i < 421; i++){
		if(name == db[i]) return true;
	}
	return false;
}

int find_index(string name){
	for(int i = 0; i < 421; i++){
		if(name == db[i]) return i;
	}
}

int main(){
	ifstream in("konta.txt");
	
	// 4.1
	string name;
	int ile_kont = 0;
	int test = 12;
	
	while(test-- ){
		cin >> name;
		
		if(!exists(name)){
			ile_kont++;
			db[j++] = name;
		}
	}
	
	cout << "Jest " << ile_kont << " kont\n";
	
	
	// 4.2
	
	string ignore;
	int hold = ile_kont;
	int i = 0;
	vector<string> V[ile_kont+1];
	
	for(int j = 0; j < ile_kont; j++){
		
	}
	
	for(int j = 0; j < hold; j++){
		cout << db[j] << " : " << V[j].size() << endl;
		//if(V[j].size() == 0) cout << db[j] << endl;
	}
	
	
	
	
	
	
	
}
