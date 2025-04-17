## Quick select algorithm
example: [1, 3, 2, 4, 8, 5] => choose k= 2 smallest element
<br/>
i = 0 <br/>
j = 0 <br/>
k = 4 <br/>
iterate: compare: arr[j] < arr[k] => if true => remain else swap and increment var
<br/>

iterate 1: [1, 3, 2, 4, 5, 8] <br/>
iterate 2: [1, 3, 2, 4, 5, 8] <br/>
iterate 3: [1, 2, 3, 4, 5, 8] <br/>

best case O(n) <br/>
worth case O(n^2)