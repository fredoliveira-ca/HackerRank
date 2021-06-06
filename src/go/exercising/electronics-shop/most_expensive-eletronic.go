package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(getMoneySpent([]int32{3, 1}, []int32{5, 2, 8}, 10))
	fmt.Println(getMoneySpent([]int32{4}, []int32{5}, 5))
}

func getMoneySpent(keyboards []int32, drives []int32, b int32) int32 {
	var sum []int32
	
	for _, keyboard := range keyboards {
		for _, drive := range drives {
			if keyboard + drive <= b {
				sum = append(sum, keyboard + drive)
			}
		}
	}
	sort.Slice(sum, func(i, j int) bool { return sum[i] > sum[j] })

	if len(sum) > 0 {
		return sum[0]
	}

	return -1
}
