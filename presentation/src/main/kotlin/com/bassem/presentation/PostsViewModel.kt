package com.bassem.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassem.presentation.mapper.toUi
import com.bassem.redditnews.domain.usecase.FetchPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val fetchPostsUseCase: FetchPostsUseCase) :
    ViewModel() {

    private val _postsState = MutableStateFlow<PostsState>(PostsState.Loading)
    private val intent = MutableSharedFlow<PostsIntent>()
    val postsState: StateFlow<PostsState> = _postsState

    init {
        collectIntent()
        setIntent(PostsIntent.FetchPosts)
    }


    private fun handleIntent(intent: PostsIntent) {
        when (intent) {
            PostsIntent.FetchPosts -> loadPosts()
            PostsIntent.NavigateToPostDetails -> {}
        }
    }

    private fun loadPosts() = viewModelScope.launch {
        _postsState.value = PostsState.Loading
        fetchPostsUseCase().collect { result ->
            result.onSuccess {
                val uiPosts = it.map { it.toUi() }
                _postsState.value = PostsState.Success(uiPosts)
            }.onFailure {

            }

        }
    }

    fun setIntent(intent: PostsIntent) {
        viewModelScope.launch {
            this@PostsViewModel.intent.emit(intent)
        }
    }

    private fun collectIntent() {
        viewModelScope.launch {
            intent.collect {
                handleIntent(it)
            }
        }
    }
}