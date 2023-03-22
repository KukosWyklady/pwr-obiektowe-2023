# Simple Makefile, do not use this shit :P

CXX := clang++
CXX_OPT := -O3
CXX_DBG := # -ggdb3
CXX_WARN := -Weverything -Wno-c++98-compat-pedantic -Wno-shadow-field-in-constructor \
 			-Wno-weak-vtables -Wno-padded -Wno-global-constructors -Wno-exit-time-destructors \
			-Wno-ctad-maybe-unsupported

CXX_FLAGS := $(CXX_OPT) $(CXX_DBG) $(CXX_WARN)

.PHONY:all
all:
	$(MAKE) app --no-print-directory

.PHONY:app
app:
	$(CXX) $(CXX_FLAGS) ./src/*.cpp ./app/*.cpp -I./include -o ./app.out

.PHONY:test
test:
	$(CXX) $(CXX_FLAGS) ./src/*.cpp ./test/*.cpp -I./include -o ./test.out

.PHONY:analyze
analyze: app test
	clang++ --analyze -Xanalyzer -analyzer-output=text -I./include ./src/*.cpp ./app/*.cpp test/*.cpp

.PHONY:memcheck
memcheck: test
	valgrind --leak-check=full --show-leak-kinds=all --error-exitcode=1 ./test.out

.PHONY:regression
regression:
	$(MAKE) clean --no-print-directory
	$(MAKE) app --no-print-directory
	$(MAKE) test --no-print-directory
	$(MAKE) analyze --no-print-directory
	./test.out
	$(MAKE) memcheck --no-print-directory

.PHONY:clean
clean:
	rm -rf app.out
	rm -rf test.out