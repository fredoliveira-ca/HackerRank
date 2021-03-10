package main

import "fmt"

func main() {
	fmt.Println(divisibleSumPairs(6, 3, []int32{1, 3, 2, 6, 1, 2}))
}

func divisibleSumPairs(n int32, k int32, ar []int32) int32 {
	count:= int32(0)

	for i := 0; int32(i) < n; i++ {
		for j := i + 1; int32(j) < n; j++ {
			sum := ar[i] + ar[j]

			if sum % k == 0 {
				count++
			}
		}
	}

	return count
}
