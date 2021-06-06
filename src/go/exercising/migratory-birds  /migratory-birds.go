package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(migratoryBirds([]int32{1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4}))//3
	fmt.Println(migratoryBirds([]int32{1, 4, 4, 4, 5, 5, 5, 3}))//4
	fmt.Println(migratoryBirds([]int32{1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4}))
}

func migratoryBirds(arr []int32) int32 {
	max, _ := groupCountBirds(arr)
	return max
}

func groupCountBirds(arr []int32) (int32, map[int]int) {
	birds := make(map[int]int)
	count := int32(0)

	for _, t := range arr {
		birds[int(t)] = birds[int(t)]+1

		if int32(birds[int(t)]) > count {
			count = int32(birds[int(t)])
		}
	}

	var s []int
	for i, j := range birds {
		if int32(j) == count {
			s = append(s, i)
		}
	}
	sort.Ints(s)

	return int32(s[0]), birds
}
