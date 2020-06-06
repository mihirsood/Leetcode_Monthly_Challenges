#include<bits/stdc++.h>
using namespace std;

bool myF(vector<int> a , vector<int> b){
    if(a[0]==b[0]){
        return a[1]<b[1];
    }
    else{
        return a[0]<b[0];
    }
}


vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        int size = people.size();

        sort(people.begin(),people.end(), myF);
        vector<vector<int>> newPeople(size,{INT_MAX , 0});
        //return people;
        for(int i=0;i<size;i++){
            int myVal = people.at(i).at(0);
            int myPos = people.at(i).at(1);
            int count=0 , j=0;
            while(j<size){
                if(count==myPos && newPeople.at(j).at(0) ==INT_MAX ){
                    break;
                }
                if(newPeople.at(j).at(0)>=myVal){
                    count++;
                }

                j++;


            }
            newPeople.at(j).at(0)=myVal;
            newPeople.at(j).at(1)=myPos;
        }
        return newPeople;
}


int main(){
    int size;
    cin>>size;
    vector<vector<int>> v;
    for(int i=0;i<size;i++){
        int va;
        int p;
        cin>>va>>p;
        vector<int> h{va,p};
        v.push_back(h);
    }
    v=reconstructQueue(v);
    for(int i=0;i<size;i++)
        cout<<v.at(i).at(0)<<" "<<v.at(i).at(1)<<endl;
    return 0;
}
