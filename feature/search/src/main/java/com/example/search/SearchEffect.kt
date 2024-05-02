package com.example.search

sealed class SearchEffect {
    object OnNotFoundNote : SearchEffect()
}