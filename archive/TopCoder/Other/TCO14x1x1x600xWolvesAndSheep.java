package prob;/* This only solved for immediately adjacent wolves, not for wolves at a distance */

import java.util.*;

public class TCO14x1x1x600xWolvesAndSheep {
	public int getmin(String[] f){
		boolean[] cf = new boolean[f[0].length()];
		boolean[] rf = new boolean[f.length];
		int sum = 0;
		for(int i=0; i<f.length; i++){
			for(int j=0; j<f[i].length(); j++){
				if(f[i].charAt(j) == 'S'){
					if(i>0 && f[i-1].charAt(j) == 'W')
							rf[i-1] = true;
					if((i+1) < f.length  && f[i+1].charAt(j) == 'W')
							rf[i] = true;
					if(j>0 && f[i].charAt(j-1) == 'W')
							cf[j] = true;
					if((j+1) < f[i].length() && f[i].charAt(j+1) == 'W')
							cf[j+1] = true;
				}
			}
		}
		System.out.println(Arrays.toString(cf));
		for(int i=0; i<f.length; i++){
			System.out.println(rf[i]+" "+f[i]);
		}
		for(int i=0; i<cf.length; i++)
			if(cf[i]) sum++;
		for(int i=0; i<rf.length; i++)
			if(rf[i]) sum++;
		return sum;
	}
}

/**
Problem Statement
    
Farmer John has a huge rectangular pasture for his sheep. The pasture is divided into a grid of unit square cells. The sheep can travel freely between the cells. There is a wall around the pasture, so the sheep cannot leave it.  One day, Farmer John found that wolves have infested the pasture through holes in the wall. Farmer John has fixed those holes, but the damage has been done: there are now some wolves in the pasture. More precisely, some cells of the pasture contain sheep, some contain wolves and some are empty. There are no cells that contain both sheep and wolves, and Farmer John would like to keep it that way. To make sure that the wolves cannot reach his sheep, Farmer John is going to build some fences.  Each new fence has to be placed either between two rows or between two columns of cells. Each fence will start at one end of the pasture and reach all the way to the other end. Neither sheep nor wolves can cross the fences. The new fences must be placed in such a way that none of the wolves will be able to reach a sheep.  You are given a String[] field. For each i and j, character j of element i of field represents the cell in row i, column j of the grid. (All indices in the previous sentence are 0-based.) Each character in field will be one of 'S' (a cell with sheep), 'W' (a cell with wolves), and '.' (an empty cell).  Return the smallest number of new fences needed to separate the wolves from the sheep.
Definition
    
Class:
WolvesAndSheep
Method:
getmin
Parameters:
String[]
Returns:
int
Method signature:
int getmin(String[] field)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Constraints
-
field will contain between 1 and 16 elements, inclusive.
-
Each element of field will contain between 1 and 16 characters, inclusive.
-
Each element of field will contain the same number of characters.
-
Each character of each element of field will be 'S', 'W' or '.'.
Examples
0)

    
{"W.WSS",
 "WW.S.",
 ".SSS.",
 "SSS.S",
 ".SS.S"}
Returns: 2
The optimal solution is to build two fences: one between rows 1 and 2, the other between columns 2 and 3. (All those indices are 0-based.) This will divide the pasture into four smaller rectangles. One of those rectangles (the 2 by 3 rectangle in the top left corner) will contain only wolves, the other three will contain only sheep.
1)

    
{".....",
 ".....",
 "....."}
Returns: 0
There are no animals, thus we need no fences.
2)

    
{".SS",
 "...",
 "S..",
 "W.W"}
Returns: 1

3)

    
{"WWWSWWSSWWW",
 "WWSWW.SSWWW",
 "WS.WSWWWWS."}
Returns: 10

4)

    
{".W.S.W.W",
 "W.W.S.W.",
 ".S.S.W.W",
 "S.S.S.W.",
 ".S.W.W.S",
 "S.S.W.W.",
 ".W.W.W.S",
 "W.W.S.S."}
Returns: 7

5)

    
{"W.SSWWSSSW.SS",
 ".SSSSW.SSWWWW",
 ".WWWWS.WSSWWS",
 "SS.WSS..W.WWS",
 "WSSS.SSWS.W.S",
 "WSS.WS...WWWS",
 "S.WW.S.SWWWSW",
 "WSSSS.SSW...S",
 "S.WWSW.WWSWSW",
 ".WSSS.WWSWWWS",
 "..SSSS.WWWSSS",
 "SSWSWWS.W.SSW",
 "S.WSWS..WSSS.",
 "WS....W..WSS."}
Returns: 24

6)

    
{"WW..SS",
 "WW..SS",
 "......",
 "......",
 "SS..WW",
 "SS..WW"}
Returns: 2

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
*/