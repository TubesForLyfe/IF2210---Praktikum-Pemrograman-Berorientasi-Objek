#include <iostream>
#include <map>
using namespace std;

int main() {
    map<int, string> m1;
    map<int, string> m2;
    int N;
    int M;
    int i;
    
    cin >> N;
    for (i = 0; i < N; i++) {
        cin >> m1[i];
    }
    
    cin >> M;
    for (i = 0; i < M; i++) {
        cin >> m2[i];
    }

    for (i = 0; i < M; i++) {
        int j = N - 1;
        while (j > 0 && m1[j] != m2[i]) {
            j--;
        }
        if (m1[j] == m2[i]) {
            m1.erase(j);
        }
    }

    for (int i = 0; i < N; i++) {
        if (m1.find(i) != m1.end()) {
            cout << m1[i] << endl;
        }
    }

    return 0;
}