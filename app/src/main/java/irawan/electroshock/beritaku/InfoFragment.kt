package irawan.electroshock.beritaku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import irawan.electroshock.beritaku.databinding.FragmentInfoBinding
import irawan.electroshock.beritaku.presentation.viewmodel.NewsViewModel

class InfoFragment : Fragment() {
    private lateinit var fragmentInfoBinding: FragmentInfoBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args : InfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        newsViewModel = (activity as MainActivity).viewModel

        fragmentInfoBinding.wvInfo.apply {
            webViewClient = WebViewClient()
            if(article.url!=null){
                article.url?.let { loadUrl(it) }
            } else{
                throw Exception("Your URL is empty")
            }
        }
        fragmentInfoBinding.fabSave.setOnClickListener {
            newsViewModel.saveArticle(article)
            Snackbar.make(view, "Saved!!", Snackbar.LENGTH_LONG).show()
        }
    }
}