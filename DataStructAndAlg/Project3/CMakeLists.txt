cmake_minimum_required(VERSION 3.29)
project(project3)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(project3
        sequence.cpp
        sequence.h

        # uncomment when you are ready for a full test
        # project3TestHarness.cpp

        # comment out when you uncomment and use project3TestHarness.cpp
        Sequence.cpp
        Sequence.h
        project3TestHarness.cpp
)
