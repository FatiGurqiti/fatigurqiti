package org.fdev.website.domain.module

data class UiItem<T>(
    val item: T,
    val name: String,
    val onClick: () -> Unit
)
