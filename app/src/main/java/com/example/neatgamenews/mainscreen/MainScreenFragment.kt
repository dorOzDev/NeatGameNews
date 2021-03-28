package com.example.neatgamenews.mainscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.neatgamenews.R
import com.example.neatgamenews.databinding.FragmentMainScreenBinding
import com.example.neatgamenews.databinding.LayoutBottomNavigationBinding
import com.example.utils.exhaustive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    private var _bindingBottomNav: LayoutBottomNavigationBinding? = null
    private val bindingBottomNav get() = _bindingBottomNav!!

    private val viewModel: MainScreenViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        _bindingBottomNav = LayoutBottomNavigationBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachListeners()
    }

    private fun attachListeners() {

        attachBottomNavigationListener()
    }

    private fun attachBottomNavigationListener() {


        bindingBottomNav.bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.likes_page -> {
                    viewModel.onLikesTabClicked()
                }

                R.id.news_page -> {
                    viewModel.onNewsTabClicked()
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        _bindingBottomNav = null
    }
}