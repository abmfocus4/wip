class Solution {
final String radiant = "Radiant";
final String dire= "Dire";
final char radiantSenator = 'R';
final char direSenator = 'D';
public String predictPartyVictory(String senate) {
Queue<Integer> rQ = new LinkedList();
Queue<Integer> dQ = new LinkedList();
int n = senate.length();
for (int i=0; i < n; i++) {
int c = senate.charAt(i);
if (c == radiantSenator) {
rQ.add(i);
} else {
dQ.add(i);
}
}
while (rQ.isEmpty() == false && dQ.isEmpty() == false) {
int r_idx = rQ.poll();
int d_idx = dQ.poll();
if (r_idx < d_idx) {
rQ.add(r_idx + n);
} else {
dQ.add(d_idx + n);
}
}
if (rQ.size() > dQ.size()) {
return radiant;
} else {
return dire;
}
}
}
