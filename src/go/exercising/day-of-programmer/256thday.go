package main

import (
	"fmt"
	"time"
)

const (
	layout  = "02.01.2006"
	day = 24 * time.Hour
)

func main() {
	//fmt.Println(dayOfProgrammer(1800))
	//fmt.Println(dayOfProgrammer(2017))
	//fmt.Println(dayOfProgrammer(2016))

	fmt.Println(dayOfProgrammer(1700)) //12.09.1700
	fmt.Println(dayOfProgrammer(1900)) // 12.09.1900
	//fmt.Println(dayOfProgrammer(1918)) //26.09.1918
}

func dayOfProgrammer(year int32) string {
	tm := time.Date(int(year), time.January,01, 12, 00, 00, 0, time.UTC)
	if year == 1800 || year == 1700 || year == 1900 {
		tm = tm.Add(-1 * day)
	}
	if year == 1918 {
		tm = tm.Add(268 * day)
	} else {
		tm = tm.Add(255 * day)
	}
	return tm.Format(layout)
}
