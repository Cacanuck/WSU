cmake_minimum_required(VERSION 3.29)
project(Project6)

set(CMAKE_CXX_STANDARD 20)

add_executable(Project6 main.cpp
        hashfunction.h
        Record.h
        Slot.h
        hashfunction.cpp
        Database.cpp
        Database.h
        HashTable.cpp
        HashTable.h
)
