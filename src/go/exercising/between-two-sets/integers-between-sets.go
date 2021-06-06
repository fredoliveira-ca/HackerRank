package main

import "fmt"

func getTotalX(a []int32, b []int32) int32 {
	firstFirstSet := a[0]
	lastFirstSet := a[len(a)-1]
	firstSecondSet := b[0]
	var factors []int32

	if len(a) == 1 {
		for i := lastFirstSet; i <=firstSecondSet; i += firstFirstSet{
			factors = append(factors, i)
		}
	} else {
		for i := lastFirstSet; i <=firstSecondSet; i += lastFirstSet * firstFirstSet - lastFirstSet{
			factors = append(factors, i)
		}
	}

	fmt.Println(firstFirstSet, lastFirstSet, factors)

	for i := 0; i < len(b); i++ {
		for j := 0; j < len(factors); j++ {

			fmt.Println(b[i], factors[j], b[i] % factors[j], factors)
			if b[i] % factors[j] != 0 {
				factors = append(factors[:j], factors[j+1:]...)
				j = 0
			}
		}
	}

	return int32(len(factors))
}

func main() {
	fmt.Println(getTotalX([]int32{1}, []int32{100})) // 9
	//fmt.Println(getTotalX([]int32{1}, []int32{72, 48})) // 8

	//fmt.Println(getTotalX([]int32{2}, []int32{20, 30, 12}))
	//fmt.Println(getTotalX([]int32{3, 4}, []int32{24, 48}))
	//fmt.Println(getTotalX([]int32{2, 6}, []int32{24, 36}))
	//fmt.Println(getTotalX([]int32{2, 4}, []int32{16, 32, 96}))
}
