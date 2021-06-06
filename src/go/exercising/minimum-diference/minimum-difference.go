package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {
	fmt.Println("Minimum Absolute Difference: ", minimumAbsoluteDifference([]int32{4, 3, 1, 2, 10, 15}))
	fmt.Println("Minimum Absolute Difference: ", minimumAbsoluteDifference([]int32{5, 8, 2, 19}))
	fmt.Println("Minimum Absolute Difference: ", minimumAbsoluteDifference([]int32{1, 5, 10, 15, 50}))

	fmt.Println("Minimum Absolute Difference: ", minimumAbsoluteDifference2([]int32{4, 3, 1, 2, 10, 15}))
	fmt.Println("Minimum Absolute Difference: ", minimumAbsoluteDifference2([]int32{5, 8, 2, 19}))
	fmt.Println("Minimum Absolute Difference: ", minimumAbsoluteDifference2([]int32{1, 5, 10, 15, 50}))
}

func minimumAbsoluteDifference2(arr []int32) int32 {
	sort.Slice(arr, func(i, j int) bool { return arr[i] < arr[j] })

	minDiff := math.Abs(float64(arr[0] - arr[1]))

	for i := 0; i < len(arr)-1; i++ {
		aux := math.Abs(float64(arr[i] - arr[i+1]))

		if aux < minDiff {
			minDiff = aux
		}
	}

	return int32(minDiff)
}

func minimumAbsoluteDifference(arr []int32) int32 {
	minDiff := math.Abs(float64(arr[0] - arr[1]))

	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			aux := math.Abs(float64(arr[i] - arr[j]))

			if aux < minDiff {
				minDiff = aux
			}
		}
	}

	return int32(minDiff)
}
