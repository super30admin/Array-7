/*
**Time Complexity (TC):** O(N)

**Space Complexity (SC):** O(1)

Where:
- `N` is the number of elements in the `wD` array.
*/

class Solution {
public:
    int shortestWordDistance(vector<string>& wD, string w1, string w2) {
        int f1=-1,f2=-1,res=INT_MAX,li=-10000000;
        for(int i=0;i<wD.size();i++)
        {
            if((w1==w2)&&(w1==wD[i]))
            {
                res=min(res,i-li);li=i;
            }
            else if(w1==wD[i])f1=i;
            else if(w2==wD[i])f2=i;
            if((f1!=-1)&&(f2!=-1))res=min(res,abs(f1-f2));
        }
        
        return res;
    }
};