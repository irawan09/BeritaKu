package irawan.electroshock.beritaku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import irawan.electroshock.beritaku.databinding.ActivityMainBinding
import irawan.electroshock.beritaku.presentation.adapter.NewsAdapter
import irawan.electroshock.beritaku.presentation.viewmodel.NewsViewModel
import irawan.electroshock.beritaku.presentation.viewmodel.NewsViewModelFactory
import java.util.zip.Inflater
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter

    lateinit var viewModel : NewsViewModel

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvNews.setupWithNavController(navController)

        viewModel = ViewModelProvider(this, factory)
            .get(NewsViewModel::class.java)
    }
}