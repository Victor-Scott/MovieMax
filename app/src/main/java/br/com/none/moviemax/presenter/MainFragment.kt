package br.com.none.moviemax.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import br.com.none.moviemax.R
import br.com.none.moviemax.databinding.FragmentMainBinding
import br.com.none.moviemax.presenter.adapter.MovieAdapter
import br.com.none.moviemax.presenter.model.MovieViewObject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.fragmentMainRecyclerView
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            recyclerView.adapter = MovieAdapter(movies)
        }


    }

}