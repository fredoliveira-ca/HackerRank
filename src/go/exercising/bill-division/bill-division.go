package main

import "fmt"

const (
	msgFairlySplit = "Bon Appetit"
)

func main() {
	bonAppetit([]int32{3, 10, 2, 9}, 1, 12)
	bonAppetit([]int32{3, 10, 2, 9}, 1, 7)
}

func bonAppetit(bill []int32, indexAnnaNotEat int32, annaCharged int32) {
	totalShared := int32(0)

	for i := 0; i < len(bill); i++ {
		if int32(i) != indexAnnaNotEat {
			totalShared += bill[i]
		}
	}

	actual := totalShared/2
	amountAnna := annaCharged - actual

	if amountAnna == 0 {
		fmt.Println(msgFairlySplit)
	} else {
		fmt.Println(amountAnna)
	}

}
