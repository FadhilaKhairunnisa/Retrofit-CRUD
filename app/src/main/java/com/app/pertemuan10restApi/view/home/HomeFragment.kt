package com.app.pertemuan10restApi.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.pertemuan10restApi.R
import com.app.pertemuan10restApi.adapter.HomeAdapter
import com.app.pertemuan10restApi.databinding.FragmentHomeBinding
import com.app.pertemuan10restApi.viewmodel.ViewModelMahasiswa

class HomeFragment : Fragment(){
    lateinit var viewModel : ViewModelMahasiswa
    lateinit var binding : FragmentHomeBinding
    lateinit var adapter : HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        viewModel.getDataMahasiswa().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvUser.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = HomeAdapter(it)
                binding.rvUser.adapter = adapter
            }else{
                binding.rvUser.visibility = View.GONE
            }
        }
        viewModel.showDataMahasiswa()

        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_tambahDataFragment)
        }
    }
}