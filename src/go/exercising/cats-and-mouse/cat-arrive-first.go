package main

import (
	"fmt"
	"math"
)

const (
	catA = "Cat A"
	catB = "Cat B"
	bothCats = "Mouse C"
)
func main() {
	fmt.Println(catAndMouse(2, 5, 4))
	fmt.Println(catAndMouse(22 , 75 , 70))
	fmt.Println(catAndMouse(33 , 86 , 59))
	fmt.Println(catAndMouse(47 , 29 , 89))
}

func catAndMouse(x int32, y int32, z int32) string {
	countCatAMove := math.Abs(float64(x - z))
	countCatBMove := math.Abs(float64(y - z))

	switch {
	case countCatAMove < countCatBMove:
		return catA
	case countCatBMove < countCatAMove:
		return catB
	case countCatAMove == countCatBMove:
		return bothCats
	}

	return "not expected"
}