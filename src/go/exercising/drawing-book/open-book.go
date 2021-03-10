package main

import "fmt"

func main() {
	fmt.Println(pageCount(6, 2))
	fmt.Println(pageCount(6, 5))

}

func pageCount(n int32, p int32) int32 {
	minimumBeginning := int32(0)
	minimumEnd := int32(0)

	for i := 0; int32(i) < p; i += 2 {
		if int32(i) == p || int32(i+1) == p {
			break
		} else {
			minimumBeginning++
		}
	}
	for i := n; i >  p ; i -= 2 {
		if n % 2 == 0 && n - p == 1 {
			minimumEnd++
		}
		if i == p || i-1 == p {
			break
		} else {
			minimumEnd++
		}
	}

	if minimumBeginning > minimumEnd {
		return minimumEnd
	} else {
		return minimumBeginning
	}
}
