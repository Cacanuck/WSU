cmake_minimum_required(VERSION 3.29)
project(Project5)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(Project5
    Trie.cpp
    Trie.h
        main.cpp)
