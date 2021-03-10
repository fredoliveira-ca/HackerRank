package main

import "fmt"

func main() {
	fmt.Println(maximumSum([]int32{4, -1, -2, 1, 3}))
	//fmt.Println(maximumSum([]int32{4, 1, 2, 3, 4}))
}

func maximumSum(arr []int32) int64 {
	sum:= int64(0)

	for i := 0; i < len(arr); i++ {
		if len(arr) == i+1 && arr[i] > arr[i-1] {
			sum += int64(arr[i])
			return sum
		}

		if arr[i] > 0 && arr[i+1] > 0 && arr[i] < arr[i+1] {
			sum += int64(arr[i])
		} else {
			sum = int64(0)
		}
	}

	return sum
}
