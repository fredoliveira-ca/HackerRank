package main

import "fmt"

func main() {
	fmt.Println(birthday([]int32{1, 2, 1, 3, 2}, 3, 2))
	fmt.Println(birthday([]int32{1, 1, 1, 1, 1, 1}, 3, 2))
	fmt.Println(birthday([]int32{4}, 4, 1))
	fmt.Println(birthday([]int32{4, 4, 3, 5, 1, 1}, 18, 7))
	fmt.Println(birthday([]int32{2, 2, 2, 1, 3, 2, 2, 3, 3, 1, 4, 1, 3, 2, 2, 1, 2, 2, 4, 2, 2, 3, 5, 3, 4, 3, 2, 1, 4, 5, 4}, 10, 4))
	fmt.Println(birthday([]int32{2, 5, 1, 3, 4, 4, 3, 5, 1, 1,  2, 1, 4, 1, 3, 3, 4, 2, 1}, 18, 7)) //3

}

func birthday(s []int32, sumD int32, qtdM int32) int32 {
	count := int32(0)

	if len(s) == 1 && s[0] == sumD {
		count++
	} else {
		for i := 0; int32(i) <= int32(len(s)) - qtdM; i++ {
			sum := s[i]

			for j := i; int32(j+1) < qtdM + int32(i) && sum <= sumD; j++ {
				sum += s[j+1]
			}

			if sum == sumD {
				count++
			}
		}
	}

	return count
}