package DivideAndConqure;

import java.util.ArrayList;
import java.util.List;

public class TheSkyLineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
      if (buildings.length == 0){
        return new ArrayList<>();
      }
      return merge(buildings, 0, buildings.length-1);

    }

    public List<List<Integer>> merge(int[][] buildings, int start, int end){
      List<List<Integer>> res = new ArrayList<>();

      if (end==start){
        List<Integer> temp = new ArrayList<>();
        // add x into temp [x, h]
        temp.add(buildings[start][0]);
        temp.add(buildings[start][2]);
        res.add(temp);

        temp = new ArrayList<>();
        // add y into temp[y, 0]
        temp.add(buildings[start][1]);
        temp.add(0);// the original code is  add(00) ?
        res.add(temp);
        return res;
      }

      int mid = (end + start) >>> 1; //Unsigned shift right operator, Num > > > 1, which is equivalent to num divided by                                        //2, ignoring the sign bits, and filling the empty bits with 0
      List<List<Integer>> finalLeft = merge(buildings, start, mid);
      List<List<Integer>> finalRight = merge(buildings, mid + 1, end);
      int h1=0;
      int h2 =0;
      int i=0;
      int j = 0;
      while(i < finalLeft.size() || j < finalRight.size()){
        long x = 0;
        // when one list to the end point, set this x as the max value to stop unnecessary count
        long x1 = i < finalLeft.size()? finalLeft.get(i).get(0): Long.MAX_VALUE;
        long x2 = j < finalRight.size()? finalRight.get(j).get(0):Long.MAX_VALUE;

        if(x1 < x2){
          // when x1 is smaller
          h1 = finalLeft.get(i).get(1);
          x = x1;
          i++;
        }
        else if (x1 > x2){
          h2 = finalRight.get(j).get(1);
          x = x2;
          j++;
        }
        else{
          h1 = finalLeft.get(i).get(1);
          h2 = finalRight.get(j).get(1);
          x = x1;
          i++;
          j++;
        }

        int height = Math.max(h1, h2);
        // when res is not empty and what we add into res is not equal to the final height in res
        if (res.isEmpty() || height!=res.get(res.size()-1).get(1)){
          List<Integer> temp = new ArrayList<>();
          temp.add((int)x);
          temp.add(height);
          res.add(temp);
        }
      }
      return res;
    }
  }
