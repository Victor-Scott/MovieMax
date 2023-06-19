package br.com.none.moviemax.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.none.moviemax.domain.GetMoviesUseCase
import br.com.none.moviemax.presenter.model.MovieViewObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {

    private val _movies = MutableLiveData<List<MovieViewObject>>()
    val movies : LiveData<List<MovieViewObject>> = _movies

    fun getMovies() {
        viewModelScope.launch {
            getMoviesUseCase()
                .onSuccess { movies ->
                    val listMovie = movies.map { movie -> MovieViewObject(movie) }
                    _movies.postValue(listMovie)
                }
                .onFailure {

                }
        }
    }
}