package com.genkey.common.modules.basic

sealed class RepoResultState<out T>
{
    data class Success<T>(val value: T) : RepoResultState<T>()
    data class Error(val exception: Throwable) : RepoResultState<Nothing>()
    data class Progress(val current: Int, val total: Int) : RepoResultState<Nothing>()
}