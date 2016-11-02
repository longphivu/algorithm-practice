package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 2, 2016
 * Problem:		Q207_CourseSchedule.java
 * Source:		https://leetcode.com/problems/course-schedule/
 *
 * Description:	There are a total of n courses you have to take, labeled from 0 to n - 1.
				Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
				Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
				For example:
				2, [[1,0]]
				There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
				2, [[1,0],[0,1]]
				There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * Solution:	Build a map for require courses; 
 * 				Recursive travel through key/course, if any course is impossible return false
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q207_CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
        Map<Integer, List<Integer>> requireMap = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int courseId = prerequisites[i][0];
            int requireId = prerequisites[i][1];
            
            List<Integer> requireCourses = requireMap.get(courseId);
            if (requireCourses == null) {
                requireCourses = new ArrayList<>();
                requireMap.put(courseId, requireCourses);
            }
            requireCourses.add(requireId);
        }
        
        Set<Integer> visitedCourse = new HashSet<>();
        Set<Integer> finishedCourse = new HashSet<>();
        for (int courseId : requireMap.keySet()) {
            if (!canFinishCheck(courseId, requireMap, visitedCourse, finishedCourse))
                return false;
        }
        
        return true;
    }
    
    private static boolean canFinishCheck(int courseId, Map<Integer, List<Integer>> requireMap, Set<Integer> visitedCourse, Set<Integer> finishedCourse) {
        
        if (visitedCourse.contains(courseId))
            return false;
        else
            visitedCourse.add(courseId);
        
        List<Integer> requireList = requireMap.get(courseId);
        //only need to check if current course have prerequisite courses
        if (requireList != null) {
            for (int requireId : requireList) {
                if (!finishedCourse.contains(requireId) && !canFinishCheck(requireId, requireMap, visitedCourse, finishedCourse)) {
                    return false;
                }
            }
        }
        
        //current course is able to finish
        finishedCourse.add(courseId);
        visitedCourse.remove(courseId);
        
        return true;
    }
}
