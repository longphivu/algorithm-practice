package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 7, 2016
 * Problem:		Q210_CourseScheduleII.java
 * Source:		https://leetcode.com/problems/course-schedule-ii/
 *
 * Description:	 There are a total of n courses you have to take, labeled from 0 to n - 1.
				Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
				Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
				There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array. 
 *
 * Solution:	Build a map for require courses; 
 * 				Recursive travel through key/course, if any course is impossible return empty array
 * Complexity:	O(n) each course only visit once (store finished course to avoid recalculate)
 * Notes:
 *				
 * Follow up:	
 */
public class Q210_CourseScheduleII {
	
	static int index = 0;
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courseOrder = new int[numCourses];
        
        //build Course prerequisite map
        HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int courseId = prerequisites[i][0];
            int reqCourseId = prerequisites[i][1];
            List<Integer> courseList = courseMap.get(courseId);
            if (courseList == null) {
                courseList = new ArrayList<>();
                courseMap.put(courseId, courseList);                
            }
            courseList.add(reqCourseId);
        }
        
        Set<Integer> finishedCourse = new HashSet<Integer>();
        Set<Integer> visitedCourse = new HashSet<Integer>();
        
       for (int i = 0; i < numCourses; i++) {
           int courseId = i;
           //if there is any course can't be finished return empty array
           if (!findOrderHelper(courseId, courseMap, finishedCourse, visitedCourse, courseOrder))
                return new int[0];
       }
       
       return courseOrder;
    }
	
    private static boolean findOrderHelper(int courseId, Map<Integer, List<Integer>> courseMap, Set<Integer> finishedCourse, Set<Integer> visitedCourse, int[] courseOrder) {
        
        if (finishedCourse.contains(courseId))
            return true;
        if (visitedCourse.contains(courseId))
            return false;
        
        List<Integer> reqCourseList = courseMap.get(courseId);
        if (reqCourseList == null) {
            finishedCourse.add(courseId);
            courseOrder[index++] = courseId;
        } else {
            visitedCourse.add(courseId);
            for (int reqId : reqCourseList) {
                if (!findOrderHelper(reqId, courseMap, finishedCourse, visitedCourse, courseOrder)) {
                    return false;
                }
            }
            visitedCourse.remove(courseId);
        }
        
        //only add to courseOrder if haven't finished this course yet
        if (!finishedCourse.contains(courseId)) {
            finishedCourse.add(courseId);
            courseOrder[index++] = courseId;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		int[][] arr = {{0,1},{1,2},{0,3},{3,0}};
		int n = 4;
		System.out.println(findOrder(n, arr));

	}

}
