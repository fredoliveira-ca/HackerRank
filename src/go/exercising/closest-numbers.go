package main

import (
	"fmt"
	"math"
	"sort"
)

type diff struct {
	i          int32
	j          int32
	difference float64
}

func main() {
	numbers := []int32{4, 2, 1, 3}
	closestNumbers(numbers)
}

func closestNumbers(numbers []int32) {
	var aux []diff
	sort.Slice(numbers, func(i, j int) bool { return numbers[i] < numbers[j] })
	var minDiff = math.Abs(float64(numbers[0] - numbers[0+1]))

	for i := 0; i < len(numbers)-1; i++ {
		d := diff{
			numbers[i],
			numbers[i+1],
			math.Abs(float64(numbers[i] - numbers[i+1])),
		}
		aux = append(aux, d)

		if d.difference < minDiff {
			minDiff = d.difference
		}
	}

	for _, diff := range aux {
		if diff.difference == minDiff {
			fmt.Println(diff.i, diff.j)
		}
	}

}
