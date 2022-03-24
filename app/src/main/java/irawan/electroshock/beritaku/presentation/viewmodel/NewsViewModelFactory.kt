package irawan.electroshock.beritaku.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import irawan.electroshock.beritaku.domain.usecase.GetNewsHeadlinesUseCase
import irawan.electroshock.beritaku.domain.usecase.GetSearchedNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase : GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase : GetSearchedNewsUseCase
) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, getNewsHeadlinesUseCase, getSearchedNewsUseCase) as T
    }
}