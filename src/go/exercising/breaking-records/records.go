package main

import "fmt"

func main() {
	fmt.Println(breakingRecords([]int32{3, 4, 21, 36, 10, 28, 35, 5, 24, 42}))
}


func breakingRecords(scores []int32) []int32 {
	highestScore := scores[0]
	lowestScore := scores[0]
	counterHighestScore := int32(0)
	counterLowestScore := int32(0)

	for _, score := range scores {
		fmt.Println(score, highestScore, lowestScore, counterHighestScore, counterLowestScore)
		if score > highestScore {
			highestScore = score
			counterHighestScore++
		}

		if score < lowestScore {
			lowestScore = score
			counterLowestScore++
		}
	}

	return []int32{counterHighestScore, counterLowestScore}
}
