/*
 * time_test.c
 *
 *  Created on: 2012-8-8
 *      Author: wangwei0312
 */
#include <TimerTest.h>

boost::string TimerTest::time_test1() {
	timer t;
	std::cout << "max timspan: " << t.elapsed_max() / 3600 << "h" << std::endl;
	std::cout << "min timespan: " << t.elapsed_min() << "s" << std::endl;
	std::cout << "noew time elapsed: " << t.elapsed() << "s" << std::endl;
	return "Success";
}
