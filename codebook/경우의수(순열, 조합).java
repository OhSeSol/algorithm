/*
순열
1~n의 수 중 r개 뽑아 r자리 숫자 만들기

ex) 1~6명 중 3
permutation({1,2,3,4,5,6}, 3, {false, false, false, false, false, false}, {0, 0, 0}, 0}
*/
static void permutation(int[] arr, int r, boolean[] visited, int[] out, int depth){
  if(depth==r){
    System.out.println(Arrays.toString(out));
    return;
  }
  
  for(int i=0; i<arr.length; i++){
    if(!visited[i]){
      visited[i] = true;
      out[depth] = arr[i];
      permutaion(arr, r, visited, out, depth+1);
      visited[i] = false;
    }
  }
}

/*
중복순열
1~n의 수 중 중복 허용하여 r자리 숫자 만들기

ex) 1~6중 3자리
permutaionWithDup({1,2,3,4,5,6}, 3, {0, 0, 0}, 0}
*/
static void permutationWithDup(int[] arr, int r, int[] out, int depth){
  if(depth==r){
    System.out.println(Arrays.toString(out));
    return;
  }
  
  for(int i=0; i<arr.length; i++){
    if(!visited[i]){
      out[depth] = arr[i];
      permutationWithDup(arr, r, out, depth+1);
    }
  }
}

/*
조합
학생 n명 중 r명 뽑기

ex)6명 중 3명
combination({1,2,3,4,5,6}, 3, {0, 0, 0}, 0, 0}
*/
static void combination(int[] arr, int r, int[] out, int depth, int start){
  if(depth==r){
    System.out.println(Arrays.toString(out));
    return;
  }

  for(int i=start; i<arr.length; i++){
    out[depth] = arr[i];
    combination(arr, r, out, depth+1, i+1);
  }
}

/*
중복 조합
3종류의 공 중 3개 뽑기(중복O, 각 공의 수는 무제한)


combinationWithDup({1,2,3}, 3, {0, 0, 0}, 0, 0}
*/
static void combinationWithDup(int[] arr, int r, int[] out, int depth, int start){
  if(depth==r){
    System.out.println(Arrays.toString(out));
    return;
  }
  
  for(int i=start; i<arr.length; i++){
    out[depth] = arr[i];
    combinationWithDup(arr, r, out, depth+1, i);
  }
}


/*
중복 조합의 응용
공: 7개
바구니: 3개
각 바구니에 담을 수 있는 공의 최대 개수: {3, 4, 4}

바구니에 공을 담는 경우의 수 출력
*/

static void divide(int n, int[] capacity, int[] out, int start){
  if(n==0){
    System.out.println(Arrays.toString(out));
    return;
  }

  for(int i=start; i<capacity.length; i++){
    if(capacity[i]>0){
      capacity[i]--;
      out[i]++;             
      divide(n-1, capacity, out, i);                
      out[i]--;                
      capacity[i]++;
    }     
  }
}
